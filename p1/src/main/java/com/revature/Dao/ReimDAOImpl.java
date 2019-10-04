package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reim;
import com.revature.service.ConnectionService;

public class ReimDAOImpl implements ReimDAO {

	//method returns all reim requets made by empid
	public List<Reim> getEmpId(int id) {
		List<Reim> c1 = new ArrayList<>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//	int reimId = rs.getInt("REIM_ID");
				double balance = rs.getDouble("BALANCE");
				String details = rs.getString("DETAILS");
				int check = rs.getInt("REIM_CHECK");
				c1.add(new Reim(balance, details, check));
				System.out.println(balance);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return c1;

	}

	public List<Reim> viewPendingReim(int eid, int status) {
		List<Reim> u = new ArrayList<>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE EMP_ID = ? AND REIM_CHECK = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eid);
			pstmt.setInt(2, status);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double balance = rs.getDouble("BALANCE");
				String details = rs.getString("DETAILS");
				int check = rs.getInt("REIM_CHECK");

				u.add(new Reim(reimId,eid,balance,details,check));

			}

		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return u;
	}
	
	public List<Reim> resolvedRequest(int eid, int status) {
		List<Reim> u2 = new ArrayList<>();
	try (Connection con = ConnectionService.getConnection()) {			
		String sql2 = "SELECT * FROM REIM WHERE EMP_ID = ? AND REIM_CHECK = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setInt(1, eid);
		pstmt2.setInt(2, status);
		ResultSet rs2 = pstmt2.executeQuery();
		while(rs2.next()) {
			int reimId2 = rs2.getInt("REIM_ID");
			double balance2 = rs2.getDouble("BALANCE");
			String details2 = rs2.getString("DETAILS");
			int check2 = rs2.getInt("REIM_CHECK");


			u2.add(new Reim(reimId2,eid,balance2,details2,check2));
		}

	}catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return u2;
	
}
	
	public boolean approveOrDeny(int value, int manid, int reimid) {
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "UPDATE REIM SET REIM_CHECK = ?, MANAGER_RESOLVED_ID = ? WHERE REIM_ID = ? AND MANAGE_ID = 1"; 
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1, value);
			pstmt.setInt(2,manid);
			pstmt.setInt(3,reimid);
			pstmt.executeUpdate();
			
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
		}

	public List<Reim> myPendingReim(int empid) {
		List<Reim> u = new ArrayList<>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE MANAGE_ID = 1 AND REIM_CHECK = 2 AND EMP_ID != ?"; //testing with 3
			PreparedStatement pstmt = con.prepareStatement(sql);
//			int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
			pstmt.setInt(1, empid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				int eId = rs.getInt("EMP_ID");
				double balance = rs.getDouble("BALANCE");
				String details = rs.getString("DETAILS");
				int check = rs.getInt("REIM_CHECK");
							 
				u.add(new Reim(reimId,eId,balance,details,check));
			}

		
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return u;
	}
	
	public List<Reim> myResolvedEmployee() {
		List<Reim> u = new ArrayList<>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE REIM_CHECK = 0 OR REIM_CHECK = 1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				int eId = rs.getInt("EMP_ID");
				double balance = rs.getDouble("BALANCE");
				String details = rs.getString("DETAILS");
				int check = rs.getInt("REIM_CHECK");
				int manageid = rs.getInt("MANAGE_ID");
				int manRes = rs.getInt("MANAGER_RESOLVED_ID");
								 
				u.add(new Reim(reimId,eId,balance,details,check,manageid,manRes));
				
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return u;
	}

	public boolean submitReim(int eid,int balance, String details) {
		
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "INSERT INTO REIM (EMP_ID,BALANCE,DETAILS) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1, eid);
			pstmt.setInt(2,balance);
			pstmt.setString(3,details);
			pstmt.executeUpdate();
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
		
		}
	
	public List<Reim> singleEmp(int eid) {
		List<Reim> z = new ArrayList<>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE EMP_ID = ? AND MANAGE_ID = 1"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,eid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				int eId = rs.getInt("EMP_ID");
				double balance = rs.getDouble("BALANCE");
				String details = rs.getString("DETAILS");
				int check = rs.getInt("REIM_CHECK");
				int manageid = rs.getInt("MANAGE_ID");
				int manRes = rs.getInt("MANAGER_RESOLVED_ID");
				z.add (new Reim(reimId,eId,balance,details,check,manageid,manRes));

			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return z;
	}

}
	



