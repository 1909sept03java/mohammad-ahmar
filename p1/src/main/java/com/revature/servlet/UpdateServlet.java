package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.beans.Employee;
import com.revature.service.ConnectionService;
import com.revature.service.EmployeeService;

import Dao.EmployeeDAO;
import Dao.EmployeeDAOImpl;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 641722825162807525L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("Update.html").forward(req, resp); //when user clicks button take to this page
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	doGet(req, resp);
		// check whether a session already exists, and create one if not 
		// overloaded version take a boolean parameter, if false returns null if not session exists
		// matching the incoming request's JSESSIONID token
		HttpSession session = req.getSession();
		// grab credentials from the request - use getParameter for form data
	
		EmployeeService es = new EmployeeService();
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		int id = Integer.parseInt(session.getAttribute("id").toString());
		es.updateEmp(user,pass,id);
		
		
		resp.sendRedirect("login"); //take back to login aftr update info
		}
	}
//}


//works
/*
try (Connection con = ConnectionService.getConnection()) {
	String sql = "UPDATE EMPLOYEE SET EMP_USER = ?, EMP_PASS = ? WHERE EMP_ID = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	String s=req.getParameter("username");
	String s2=req.getParameter("password");
	int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
	pstmt.setString(1, s);
	pstmt.setString(2,s2);
	pstmt.setInt(3,s3);
	pstmt.executeUpdate();
	System.out.println(s);
	System.out.println(s2);
	System.out.println(s3);
//	session.setAttribute("username", u.getUser()); null pointer exception
//	session.setAttribute("password", u.getPass());
} 
 catch (SQLException e) {
	e.printStackTrace();
}
*/