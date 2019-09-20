package beans;

public class SuperuserTable {

	private int id;
	private String username;
	private String password;
	
	public SuperuserTable(int id, String userName, String userPass) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = userName;
		this.password = userPass;
	}
	
	public String toString() {
		return "SuperUser [id=" + id + ", username=" + username + ", password=" + password + " +"
			 + " ]";
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
