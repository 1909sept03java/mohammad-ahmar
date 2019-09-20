package beans;

public class UserTable {

	private int id;
	private String userName;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;

	public UserTable () {
		super();
	}
	
	
	public UserTable(int id, String userName, String userPass, String userFirst, String userLast, String userEmail) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.userName = userName;
		this.userPassword = userPass;
		this.userFirstName = userFirst;
		this.userLastName = userLast;
		this.userEmail = userEmail;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + userName + ", password=" + userPassword + " +"
				+ "userFirstname= " + userFirstName +  " lastname=" + userLastName + " + email = " + userEmail + " ]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
