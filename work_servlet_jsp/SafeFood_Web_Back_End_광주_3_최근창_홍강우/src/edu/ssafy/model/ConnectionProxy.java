package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProxy {

	public static Connection getConnection() throws SQLException {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafy0924?serverTimezone="
					+ "UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy", "ssafy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Loading Failed...");
		}
		
		return con;
	}
}
