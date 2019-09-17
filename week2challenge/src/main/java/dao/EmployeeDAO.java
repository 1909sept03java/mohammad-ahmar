package dao;

import java.util.List;

import beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployee();
	public Employee getEmployeeById(int id);
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
}
