package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Department;
import util.ConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		List<Department> cl = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM DEPARTMENT";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int deptId = rs.getInt("DEPARTMENT_ID");
				String deptName = rs.getString("DEPARTMENT_NAME");
				cl.add(new Department(deptId,deptName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCave(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCave(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCave(Department department) {
		// TODO Auto-generated method stub
		
	}
	
	
}
