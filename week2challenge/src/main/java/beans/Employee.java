package beans;

public class Employee {
public	int EmployeeID;
	public String employeeFirstName;
	public String employeeLastName;
	public int deptId;
	public double salary;
	public String email;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String firstName, String lastName, int deptId, double salary, String email) {
		// TODO Auto-generated constructor stub
		this.EmployeeID = employeeId;
		this.employeeFirstName = firstName;
		this.employeeLastName = lastName;
		this.deptId = deptId;
		this.salary = salary;
		this.email = email;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Department [id= " + EmployeeID + " firstname= " + employeeFirstName + " lastname= " + employeeLastName 
			+	" deptid= " + deptId + " salary= " + salary + ", email= " + email + "]";
	}
	

}
