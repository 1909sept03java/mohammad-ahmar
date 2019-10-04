package com.revature.service;

import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;

import Dao.EmployeeDAO;
import Dao.EmployeeDAOImpl;

public class EmployeeService {
	
	private EmployeeDAO ed = new EmployeeDAOImpl();
	
	public EmployeeService() {
		
	}
	
	public Employee checkEmp(Credentials cred) {
		return ed.checkEmp(cred);
	}
	
	public List<Employee> viewEmp(int id) {
		return ed.viewEmp(id);
	}
	
	public boolean updateEmp(String username, String password, int id) {
		return ed.updateEmp(username, password, id);
	}
	
	

}
