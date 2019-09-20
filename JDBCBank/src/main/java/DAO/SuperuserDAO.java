package DAO;

import java.util.List;

import beans.UserTable;

public interface SuperuserDAO {

	public void checkUsers();
	public void createUser();
	public void checkSuperUser();
	public void tryAgainSuper();
	public void giveUserOp();
	public void giveSuperUserOp();
	public void deleteUser();
	public void viewUser();
		
	
}
