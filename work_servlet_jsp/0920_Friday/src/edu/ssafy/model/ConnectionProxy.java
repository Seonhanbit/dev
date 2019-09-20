package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProxy {
	static Connection con = null;
	public static Connection getConnection() throws SQLException {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafyfri?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
					"ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
