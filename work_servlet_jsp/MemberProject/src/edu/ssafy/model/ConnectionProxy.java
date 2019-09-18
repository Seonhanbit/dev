package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*create database ssafyweb;
use ssafyweb;
create table memberweb(
	id varchar(20) primary key,
    pw varchar(20),
	name varchar(20),
    age int,
    addr varchar(200),
    tel varchar(15)
);

select * from memberweb;
drop table memberweb;*/

public class ConnectionProxy {
	static Connection con = null;
	public static Connection getConnection() throws SQLException {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
					"ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
