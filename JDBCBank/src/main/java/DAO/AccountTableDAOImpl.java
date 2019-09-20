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

import beans.AccountTable;
import beans.UserTable;
import util.ConnectionUtil;

public class AccountTableDAOImpl implements AccountTableDAO{

	@Override
	public List<AccountTable> getAllUsers() {
		// TODO Auto-generated method stub		
		List<AccountTable> c1 = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNT_TABLE";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("USER_ID");
				int bankid = rs.getInt("BANK_ACCOUNT_ID");
				double balance = rs.getInt("BALANCE");
				double deposit = rs.getInt("DEPOSIT");
				double withdraw = rs.getInt("WITHDRAW");

				c1.add(new AccountTable(id,bankid,balance,deposit,withdraw));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c1;
	}

	public void viewAcct() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter your user id: ");
		int user = 0;
		user = s.nextInt();
		AccountTable a = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNT_TABLE WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("BANK_ACCOUNT_ID");
				int bid = rs.getInt("USER_ID");
				float balnce = rs.getFloat("BALANCE");
				float dep = rs.getFloat("DEPOSIT");
				float ttl = dep + balnce;
				a = new AccountTable(id,bid,ttl);
				System.out.println(a);
			//	System.out.println(ttl);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Acct view screen: ");
	}


	public void createAcct() {
		Scanner s = new Scanner(System.in);
		System.out.print("To create acct please first enter user id: ");
		int user = 0;
		user = s.nextInt();
		System.out.println("Enter the balance you would liek to add: ");
		double balance;
		balance = s.nextDouble();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ACCOUNT_TABLE (USER_ID, BALANCE) VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user);
			pstmt.setDouble(2, balance);
			pstmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Acct created! ");
	}

	public void deleteAcct() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username id you want to delete: ");
		String user = sc.next();
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM ACCOUNT_TABLE WHERE USER_ID = ?";
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
			case 1: viewAcct(); System.out.println(); System.out.println();break;
			case 2: createAcct(); System.out.println();break;
			case 3: deleteAcct();System.out.println(); System.out.println();break;
			case 4: deposit(); System.out.println("deposit/withdraw"); System.out.println();break;
			case 5: 
			}
		}
	}

	public void tryAgain() {
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
			if(!rs.next()) {
			} else {
				System.out.println("Welcome " + name);
				System.out.println();
				giveUserOp(); // move on to next step and give user options
			}
		} catch (SQLException e) {
		} catch (IOException e) {
			e.printStackTrace();	

		}
	}

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
					tryAgain(); i--;
				} 
			} else {
				System.out.println("Welcome " + name);
				System.out.println();
				giveUserOp(); // move on to next step and give user options
			}
		} catch (SQLException e) {
		} catch (IOException e) {
			e.printStackTrace();	
		}

	}
	
	public void deposit() {
		System.out.println("Enter your userid: ");
		Scanner s = new Scanner(System.in);
		int id = 0;
		id = s.nextInt();
		
		System.out.println("Enter amount for deposit: ");
		double amt;
		amt = s.nextDouble();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE ACCOUNT_TABLE SET DEPOSIT = ? WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, amt);
			pstmt.setInt(2,id);
			pstmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("User has deposited " + amt);
		System.out.println();
	}

}
