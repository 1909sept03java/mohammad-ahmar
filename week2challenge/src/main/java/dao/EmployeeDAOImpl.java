package dao;

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		List<Employee> cl = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("EMP_FIRSTNAME");
				String lastName = rs.getString("EMP_LASTNAME");
				int deptId = rs.getInt("DEPARTMENT_ID");
				double salary = rs.getDouble("SALARY");
				String email = rs.getString("EMP_EMAIL");
				cl.add(new Employee(employeeId, firstName, lastName, deptId, salary, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	

}
