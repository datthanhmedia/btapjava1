package vn.datthanhmedia.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/jspseverlet";
	public static final String USER = "root";
	public static final String PASS = "Thanh2018";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		}catch (Exception e) {
			throw new RuntimeException("Error establishing a database connection", e);
		}
		
	}
}
