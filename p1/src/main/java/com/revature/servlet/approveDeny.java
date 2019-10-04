package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ReimService;

@WebServlet("/approveDeny")
public class approveDeny extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("approveDeny.html").forward(req, resp); //when user clicks button take to this page
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int s2=Integer.parseInt(req.getParameter("value"));
		int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
		int s=Integer.parseInt(req.getParameter("id"));

		ReimService r2 = new ReimService();
		r2.approveOrDeny(s2, s3, s);
		resp.sendRedirect("profile"); //take back to login aftr update info
		
	}
}
/*
try (Connection con = ConnectionService.getConnection()) {
	String sql = "UPDATE REIM SET REIM_CHECK = ?, MANAGER_RESOLVED_ID = ? WHERE REIM_ID = ? AND MANAGE_ID = 1"; 
	PreparedStatement pstmt = con.prepareStatement(sql);
	int s2=Integer.parseInt(req.getParameter("value"));
	int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
	int s=Integer.parseInt(req.getParameter("id"));
	
//	int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
	pstmt.setInt(1, s2);
	pstmt.setInt(2,s3);
	pstmt.setInt(3,s);
	pstmt.executeUpdate();
	
} 
 catch (SQLException e) {
	e.printStackTrace();
}
	// set user information as session attributes (not request attributes)
//	session.setAttribute("id", u.getID());
resp.sendRedirect("profile"); //take back to login aftr update info
}
*/
