package Dao;

import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;


public interface EmployeeDAO {

	public Employee checkEmp(Credentials creds);
	public List<Employee> viewEmp(int id);
	public boolean updateEmp(String username, String password, int id);

}
