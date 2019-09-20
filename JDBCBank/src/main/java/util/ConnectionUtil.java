package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

/*	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@demo-sept3.c6wbp4fdcm7i.us-east-2.rds.amazonaws.com:1521:orcl", "admin", "23274579");
	}
*/
	public static Connection getConnection() throws SQLException, IOException {
		// read in contents of a properties file - NEVER want to hardcode credentials
		Properties prop = new Properties();
		//InputStream in = new FileInputStream("connection.properties");
		prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties"));
		// need to provide: url to the database, username, password
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

}