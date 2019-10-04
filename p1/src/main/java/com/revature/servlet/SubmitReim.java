package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ReimService;

@WebServlet("/SubmitReim") //after hitting request button do this
public class SubmitReim extends HttpServlet{
	private static final long serialVersionUID = -8979690890762900779L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("submitReim.html").forward(req, resp); //when user clicks reuqest button do this
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		ReimService r2 = new ReimService();
		int eid = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
		int balance= Integer.parseInt(req.getParameter("amount").toString());
		String details=req.getParameter("details");  //get paramter name from forms
		r2.submitReim(eid, balance, details);
		resp.sendRedirect("profile"); //take back to login aftr update info
	}
	
}
//}


/*
 HttpSession session = req.getSession();
		
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "INSERT INTO REIM (EMP_ID,BALANCE,DETAILS) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
			int s= Integer.parseInt(req.getParameter("amount").toString());
			String s2=req.getParameter("details");  //get paramter name from forms
			pstmt.setInt(1, s3);
			pstmt.setInt(2,s);
			pstmt.setString(3,s2);
			pstmt.executeUpdate();
			System.out.println(s3);
			System.out.println(s);
			System.out.println(s2);
		//	session.setAttribute("username", u.getUser()); null pointer exception
		//	session.setAttribute("password", u.getPass());
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
			// set user information as session attributes (not request attributes)
		//	session.setAttribute("id", u.getID());
		resp.sendRedirect("profile"); //take back to login aftr update info
		}
		*/
