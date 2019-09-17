package main;

import beans.Department;
import beans.Employee;
import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class Driver {

	public static void main(String[] args) {
		/*
		try {
			Connection conn = ConnectionUtil.getConnection();
			System.out.println(conn);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		EmployeeDAO cd = new EmployeeDAOImpl();
		for (Employee c : cd.getEmployee()) {
			System.out.println(c);
		}
	}

}
