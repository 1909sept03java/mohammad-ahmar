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
import oracle.sql.SQLName;
import util.ConnectionUtil;

public class UserTableDAOImpl implements UserTableDAO {

	public List<UserTable> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserTable> c1 = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USER_TABLE";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("USER_ID");
				String userName = rs.getString("USER_USERNAME");
				String userPass = rs.getString("USER_USERPASS");
				String userFirst = rs.getString("USER_FIRSTNAME");
				String userLast = rs.getString("USER_LASTNAME");
				String userEmail = rs.getString("USER_EMAIL");
				c1.add(new UserTable(id,userName,userPass,userFirst,userLast,userEmail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c1;
	}



	public void createUser( ) {
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
			//set this values using PreparedStatement
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
			String sql = "SELECT * FROM USER_TABLE WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userid = rs.getInt("USER_ID");
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

}
