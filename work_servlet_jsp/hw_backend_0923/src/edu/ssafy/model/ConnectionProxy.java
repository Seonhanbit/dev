package edu.ssafy.model;

import java.sql.*;

/*
create database ssafy0920;
use ssafy0920;

CREATE TABLE products (
	num int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(20),
    price int,
    description VARCHAR(100)
);
 */

public class ConnectionProxy {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 연결
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafy0920?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
