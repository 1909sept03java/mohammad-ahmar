package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.ReimService;
// employee pending reim
@WebServlet("/viewRiem")
public class ViewRiem extends HttpServlet{

	private static final long serialVersionUID = 1772588434947273567L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		setAccessControlHeaders(resp);
		HttpSession session = req.getSession();
		ReimService u = new ReimService();
		int eid = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
		u.viewPendingReim(eid,2);
		resp.getWriter().write((new ObjectMapper()).writeValueAsString(u.resolvedRequest(eid, 2)));

			
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// check whether a session already exists, and create one if not 
		// overloaded version take a boolean parameter, if false returns null if not session exists
		// matching the incoming request's JSESSIONID token
		doGet(req, resp);
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "*");
	//resp.setHeader("Access-Control-Allow-Origin:" , "*"); 
		//	resp.setHeader("Access-Control-Allow-Credentials:" , "true");
		//	resp.setHeader("Content-type:" , "application/json");
	}

	
}

/*
 setAccessControlHeaders(resp);
		HttpSession session = req.getSession();
		List<Reim> u = new ArrayList<>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE EMP_ID = ? AND REIM_CHECK = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
			pstmt.setInt(1, s3);
			pstmt.setInt(2, 2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				double balance = rs.getDouble("BALANCE");
				String details = rs.getString("DETAILS");
				int check = rs.getInt("REIM_CHECK");
				
				u.add(new Reim(reimId,s3,balance,details,check));
				//	resp.sendRedirect("viewRiem");
			}
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(u));

		
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 */


