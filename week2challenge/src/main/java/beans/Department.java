package beans;

public class Department {
	public int deptId;
	public String departName;
	
	public Department() {
		super();
	}

	public Department(int deptId, String deptName) {
		// TODO Auto-generated constructor stub
		this.deptId = deptId;
		this.departName = deptName;
	}

	public Department(String deptName) {
		// TODO Auto-generated constructor stub
		this.departName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	public String toString() {
		return "Department [id=" + deptId + ", name=" + departName + "]";
	}
	
	
}
