package main.java.com.GDA.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.ResourceBundle;


public class ConnectionDB {

	public static void main(String[] args) {
		
		Connection connect = null;
		
		try {
			System.out.println("Connection in progress...");
			connect = ConnectionDB.getConnection();
			System.out.println("Connection successful");
			
		} catch (Exception e) {
		
		} finally {
			try {
				
				connect.close();
				System.out.println("Connection closed");
			} catch (Exception e2) {
			}
		}
	}
	
	public static Connection getConnection () throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		
		String driverName = rb.getString("db.driver.name");
		String url = rb.getString("db.url");
		String userName = rb.getString("db.user.name");
		String userPassword = rb.getString("db.user.password");

		// DriverManager.setLogWriter(new PrintWriter(System.out));
		Class.forName(driverName);

		return DriverManager.getConnection(url, userName, userPassword);
	}
}
