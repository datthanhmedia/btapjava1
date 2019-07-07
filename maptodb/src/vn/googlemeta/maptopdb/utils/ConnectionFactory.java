package vn.googlemeta.maptopdb.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/baitap1";
	public static final String USER = "root";
	public static final String PASS = "Thanh2018";
	
	public static Connection getConnection() {
		try {
			//DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		}catch (Exception e) {
			throw new RuntimeException("Error establishing a database connection", e);
		}
		
	}

public static void main(String[] agrs) {
	ConnectionFactory.getConnection();
}
}