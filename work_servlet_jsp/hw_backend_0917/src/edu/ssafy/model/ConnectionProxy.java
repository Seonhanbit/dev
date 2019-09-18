package edu.ssafy.model;

import java.sql.*;

/*
create database ssafyweb;
use ssafyweb;

create table memberweb (
	id varchar(20) primary key,
	name varchar(200),
	pw varchar(20),
	addr varchar(200),
    age int,
    tel varchar(15)
);

테스트 코드
drop table memberweb;
select * from memberweb;
 */

public class ConnectionProxy {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 연결
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
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
