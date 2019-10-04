package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.service.ConnectionService;

public class EmployeeDAOImpl implements EmployeeDAO{

	public Employee checkEmp(Credentials creds) {
		Employee e = null;
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_USER = ? AND EMP_PASS = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, creds.getUsername());
			pstmt.setString(2, creds.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = (rs.getInt("EMP_ID"));
				String username = (rs.getString("EMP_USER"));
				String password = (rs.getString("EMP_PASS"));
				int manid = (rs.getInt("MAN_ID"));
				e = new Employee(id,username,password,manid);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		return e;

	}

	public List<Employee> viewEmp(int id) {
		List<Employee> u= new ArrayList<>(); 
		try (Connection conn = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?"; //change
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userid = rs.getInt("EMP_ID");  //change
				String username = rs.getString("EMP_USER");
				String password = rs.getString("EMP_PASS");
				int managerid = rs.getInt("MAN_ID");
				u.add(new Employee(userid, username, password,managerid));				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public boolean updateEmp(String username, String password, int id) {
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "UPDATE EMPLOYEE SET EMP_USER = ?, EMP_PASS = ? WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2,password);
			pstmt.setInt(3,id);
			pstmt.executeUpdate();
			
		} 
		 catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return false;
			
		}

		
	}
	
	
	
	

