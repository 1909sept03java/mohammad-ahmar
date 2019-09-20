package DAO;
import java.util.List;

import beans.UserTable;

public interface UserTableDAO {

	public List<UserTable> getAllUsers();
	public void createUser();
	public void deleteUser();
	public void viewUser();
	
}
