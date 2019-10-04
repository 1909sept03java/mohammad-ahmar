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

@WebServlet("/singleEmp")
public class singleEmp extends HttpServlet{


	private static final long serialVersionUID = -8774810045583036472L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		req.getRequestDispatcher("singleEmp.html").forward(req, resp); //when user clicks button take to this page
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ReimService rs = new ReimService();
		int eid = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
		rs.singleEmp(eid);

		resp.getWriter().write((new ObjectMapper()).writeValueAsString(rs.singleEmp(eid)));
		resp.sendRedirect("profile");
		}
	}


/*
 * HttpSession session = req.getSession();
		// grab credentials from the request - use getParameter for form data
		
		List<Reim> z = new ArrayList<>();
 try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIM WHERE EMP_ID = ? AND MANAGE_ID = 1"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			int s2=Integer.parseInt(req.getParameter("id"));
		//	int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
			pstmt.setInt(1,s2);
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
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(z));

				//	resp.sendRedirect("profile");
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
			// set user information as session attributes (not request attributes)
		//	session.setAttribute("id", u.getID());
	//	resp.sendRedirect("profile"); //take back to login aftr update info
		}
		*/


