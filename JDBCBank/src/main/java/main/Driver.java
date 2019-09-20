package main;
import java.util.Scanner;

import DAO.AccountTableDAO;
import DAO.AccountTableDAOImpl;
import DAO.SuperuserDAO;
import DAO.SuperuserTableDAOImpl;
import DAO.UserTableDAO;
import DAO.UserTableDAOImpl;
import beans.AccountTable;
import beans.UserTable;

/*superuser info
username= TOM
password =JERRY
*/
public class Driver {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int selection = 0;
		while(selection != 9) {
			System.out.println("Main menu: " + "\n" + "Login press 1" + "\n" + "regiester press 2" + "\n" +
					"Superusers press 3 "+"\n" + "Exit press 9");
			System.out.print("Enter selection: ");
			selection = sc.nextInt();
			switch(selection) {
			case 9: System.out.println("Good bye "); break; 
			case 1: AccountTableDAO c = new AccountTableDAOImpl(); c.checkUsers();	break;	
			case 2: UserTableDAO cd = new UserTableDAOImpl(); cd.createUser(); break;
			case 3: SuperuserDAO cdd = new SuperuserTableDAOImpl(); cdd.checkSuperUser(); break;
			}
		}
	}

	}

