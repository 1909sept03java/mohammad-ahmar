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
// employee function
@WebServlet("/resRiem")
public class ResolvedRiem extends HttpServlet{

	private static final long serialVersionUID = 1772588434947273567L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	/*	ReimDAO u2 = new ReimDAOImpl();
		int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
		u2.resolvedRequest(s3);
		resp.getWriter().write((new ObjectMapper()).writeValueAsString(u2));
		*/
		setAccessControlHeaders(resp);
		HttpSession session = req.getSession();
		ReimService r2 = new ReimService();
		int eid = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
		r2.resolvedRequest(eid, 1);
		resp.getWriter().write((new ObjectMapper()).writeValueAsString(r2.resolvedRequest(eid, 1)));

		
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
 * try (Connection con = ConnectionService.getConnection()) {			
			List<Reim> u2 = new ArrayList<>();
			String sql2 = "SELECT * FROM REIM WHERE EMP_ID = ? AND REIM_CHECK = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			int s3 = Integer.parseInt(session.getAttribute("id").toString()); //get id from session details
			pstmt2.setInt(1, s3);
			pstmt2.setInt(2, 1);
			ResultSet rs2 = pstmt2.executeQuery();
			while(rs2.next()) {
				int reimId2 = rs2.getInt("REIM_ID");
				double balance2 = rs2.getDouble("BALANCE");
				String details2 = rs2.getString("DETAILS");
				int check2 = rs2.getInt("REIM_CHECK");
		
				 
				u2.add(new Reim(reimId2,s3,balance2,details2,check2));
		}
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(u2));

		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  
  */
