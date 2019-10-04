package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Reim;

import Dao.ReimDAOImpl;

// taking the place of a mapping within my web.xml - annotation-based config vs xml config
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = -1319793763433572026L;

	// return a JSON representation of the currently authenticated user for a
	// request's JSESSIONID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setAccessControlHeaders(resp);
		// grab current session, if it exists, otherwise return null
		HttpSession session = req.getSession(false);
		
		
		  try { // grab session attributes and place them within a user object 
		int id = Integer.parseInt(session.getAttribute("id").toString()); 
		String username = session.getAttribute("username").toString(); 
		String password = session.getAttribute("password").toString(); 
		  int mid = Integer.parseInt(session.getAttribute("man id").toString()); 
		  Employee u = new Employee(id, username, password, mid); 
		 //  String e = u.toString(); // use
	//	  ObjectMapper (part of the Jackson api) to convert Java object to JSON 
		  resp.getWriter().write((new ObjectMapper()).writeValueAsString(u));
		  
		 
		  } catch (Exception e) { 
			  e.printStackTrace();
		  resp.getWriter().write("{\"session\":null}"); }
		 
		 /*
	//------------------------------------------------------------------	
		try {
			// grab session attributes and place them within a user object
			double balance = Double.parseDouble(session.getAttribute("balance").toString());
			String details =  session.getAttribute("details").toString();
			int check =  Integer.parseInt(session.getAttribute("check").toString());
			Reim u2 = new Reim(balance, details, check);
		//	String e1 = u2.toString();
			// use ObjectMapper (part of the Jackson api) to convert Java object to JSON
			// representation
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(u2)); 
			//details when logging in
			//---------------------------------
			//details when trying to view pending riem 
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
			
		}
		*/
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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