package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reim;
import com.revature.service.ConnectionService;
import com.revature.service.ReimService;

@WebServlet("/myResolvedEmployee")
public class myResolvedEmployee extends HttpServlet{

	private static final long serialVersionUID = 1567323488195489618L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setAccessControlHeaders(resp);
		HttpSession session = req.getSession();
		ReimService r2 = new ReimService();
		resp.getWriter().write((new ObjectMapper()).writeValueAsString(r2.myResolvedEmployee()));
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
			String sql = "SELECT * FROM REIM WHERE REIM_CHECK = 0 OR REIM_CHECK = 1";
			PreparedStatement pstmt = con.prepareStatement(sql);
		//	int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details so manager dosnt show up as a employee under his table
		//	pstmt.setInt(1, s3);
		//	pstmt.setInt(2, 2);
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
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(u));
		
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
