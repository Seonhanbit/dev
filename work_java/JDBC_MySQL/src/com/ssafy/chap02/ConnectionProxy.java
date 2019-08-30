package com.ssafy.chap02;

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
					"jdbc:mysql://192.168.24.125:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
					"ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
