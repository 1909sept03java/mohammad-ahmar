package com.revature.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;

import Dao.EmployeeDAO;
import Dao.EmployeeDAOImpl;

public class AuthenticationService {
	
	// if credentials are not recognized, return null
	// if they are, return user associated with them
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
	
	
	
}