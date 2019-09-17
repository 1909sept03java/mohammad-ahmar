package dao;

import java.util.List;

import beans.Department;

public interface DepartmentDAO {
	public List<Department> getDepartment();
	public Department getDepartmentById(int id);
	public void createCave(Department department);
	public void updateCave(Department department);
	public void deleteCave(Department department);
}
