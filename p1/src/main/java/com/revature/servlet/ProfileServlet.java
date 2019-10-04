package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 8343002811379165553L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("man id").equals(0)) { // 0 for employees 1 for managers
			/*	resp.getWriter().write("welcome to your profile, " + session.getAttribute("username") + " "
						+ session.getAttribute("password")); */
			req.getRequestDispatcher("Profile.html").forward(req, resp);
		} else if (session != null && session.getAttribute("man id").equals(1)) {
			req.getRequestDispatcher("Manager.html").forward(req,resp);
		}
		else {
			resp.getWriter().write("Invalid credientails try again");
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}