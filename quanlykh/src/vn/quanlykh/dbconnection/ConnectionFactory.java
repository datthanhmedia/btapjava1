package vn.quanlykh.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/khachhang?characterEncoding=UTF8";
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