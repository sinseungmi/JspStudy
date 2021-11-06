package chap02.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
	
	private static String url;
	private static String user; 
	private static String password;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = 
				DriverManager.getConnection(url, user, password);
		return null;
		
	}

}











