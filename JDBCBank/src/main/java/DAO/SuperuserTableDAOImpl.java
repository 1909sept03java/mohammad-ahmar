package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.UserTable;
import util.ConnectionUtil;

public class SuperuserTableDAOImpl implements SuperuserDAO{

	public void checkSuperUser() {
		Scanner a = new Scanner(System.in);
		System.out.print("Enter your super-username: ");
		String name = a.next();

		System.out.print("Enter your super-password: ");
		String pass = a.next();

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM SUPERUSER_TABLE WHERE SUPERUSER_USERNAME = ? AND SUPERUSER_PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,pass);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			if(!rs.next()) {
				while(i > 0 ) {
					System.out.println("Wrong username and password try again final attempt");
					tryAgainSuper(); i--;
				} 
			} else {
				System.out.println("Welcome " + name);
				System.out.println();
				giveSuperUserOp(); // move on to next step and give user options
			}
		} catch (SQLException e) {
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}

	public void tryAgainSuper() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String name = sc.next();

		System.out.print("Enter your password: ");
		String pass = sc.next();

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM SUPERUSER_TABLE WHERE SUPERUSER_USERNAME = ? AND SUPERUSER_PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,pass);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
			} else {
				System.out.println("Welcome " + name);
				System.out.println();
				giveSuperUserOp(); // move on to next step and give user options
			}
		} catch (SQLException e) {
		} catch (IOException e) {
			e.printStackTrace();	

		}
	}

	public void giveUserOp () {
		Scanner s = new Scanner(System.in);
		int selection = 0;
		while(selection != 9) {
			System.out.println("Bank main menu: " + "\n" + "View acct press 1" + "\n" + "create acct press 2" + "\n" +
					"delete acct press 3 " + "\n" + "deposit or withdraw press 4 " + "\n" + "exit to main menu press 9");
			System.out.print("Enter selection: ");
			selection = s.nextInt();
			switch(selection) {
			case 9: System.out.println("Exiting to main menu "); System.out.println();break; 
			case 1: viewUser(); System.out.println(); System.out.println();break;
			case 2: createUser(); System.out.println();break;
			case 3: deleteUser();System.out.println(); System.out.println();break;
			case 4: System.out.println("deposit/withdraw"); System.out.println();break;
			}
		}
	}

	public void giveSuperUserOp() {
		Scanner s = new Scanner(System.in);
		int selection = 0;
		while(selection != 9) {
			System.out.println("Superuser main menu: " + "\n" + "\n"  +"create user press 2" + "\n" +
					"delete user press 3 " + "\n"  +"view specfic user press 4" + "\n"+" Press 5 to view all users" + "\n" +"exit to main menu press 9");
			System.out.print("Enter selection: ");
			selection = s.nextInt();
			switch(selection) {
			case 9: System.out.println("Exiting to main menu "); System.out.println();break; 
			//case 1: getAllUsers(); System.out.println(); System.out.println();break;
			case 2: createUser(); System.out.println();break;
			case 3: deleteUser(); System.out.println(); System.out.println();break;
			case 4: viewUser(); System.out.println(); break;
			case 5: UserTableDAO cd = new UserTableDAOImpl();
			for (UserTable c : cd.getAllUsers()) {
				System.out.println(c);
			}
			System.out.println(); break; // move
			}
		}
	}

	public void deleteUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username id you want to delete: ");
		String user = sc.next();
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM USER_TABLE WHERE USER_ID = ?";
			//set this values using PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("User has been deleted");
		System.out.println();
	}

	public void viewUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user id to view detaisl: ");
		int id = 0;
		id = sc.nextInt();

		try (Connection conn = ConnectionUtil.getConnection()) {
			UserTable u = null;
			String sql = "SELECT * FROM USER_TABLE WHERE USER_ID = ?"; //change
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userid = rs.getInt("USER_ID");  //change
				String username = rs.getString("USER_USERNAME");
				String password = rs.getString("USER_USERPASS");
				String firstname = rs.getString("USER_FIRSTNAME");
				String lastname = rs.getString("USER_LASTNAME");
				String email = rs.getString("USER_EMAIL");
				u = new UserTable(userid, username, password,firstname,lastname,email);
				System.out.println(u);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void checkUsers() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String name = sc.next();

		System.out.print("Enter your password: ");
		String pass = sc.next();

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USER_TABLE WHERE USER_USERNAME = ? AND USER_USERPASS = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,pass);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			if(!rs.next()) {
				while(i > 0 ) {
					System.out.println("Wrong username and password try again final attempt");
					tryAgainSuper(); i--;
				} 
			} else {
				System.out.println("Welcome " + name);
				System.out.println();
				giveUserOp(); // move on to next step and give user options
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}

	}

	@Override
	public void createUser() {
		Scanner s = new Scanner(System.in);
		System.out.print("Make a username: ");
		String user = s.next();
		System.out.print("Make a password: ");
		String pass = s.next();
		System.out.print("Firstname: ");
		String firstname = s.next();
		System.out.print("Lastname: ");
		String lastname = s.next();
		System.out.print("Email: ");
		String email = s.next();

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO USER_TABLE (USER_USERNAME, USER_USERPASS, USER_FIRSTNAME, USER_LASTNAME, USER_EMAIL) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2,pass);
			pstmt.setString(3,firstname);
			pstmt.setString(4, lastname);
			pstmt.setString(5,email);
			pstmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("User has been created");
		System.out.println();
	}

}


