package DAO;

import java.util.List;

import beans.AccountTable;

public interface AccountTableDAO {
	public List<AccountTable> getAllUsers();
	public void viewAcct();
	public void createAcct();
	public void deleteAcct();
	public void giveUserOp();
	public void tryAgain();
	public void checkUsers();
	

}
