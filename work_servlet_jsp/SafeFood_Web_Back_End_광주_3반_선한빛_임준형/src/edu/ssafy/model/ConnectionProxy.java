package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*create database ssafy0924;
use ssafy0924;
create table food (
 code INT UNIQUE NOT NULL PRIMARY KEY,
 name VARCHAR(30),
 supportpereat DOUBLE,
 calory DOUBLE,
 carbo DOUBLE,
 protein DOUBLE,
 fat DOUBLE,
 sugar DOUBLE,
 natrium DOUBLE,
 chole DOUBLE,
 fattyacid DOUBLE,
 transfat DOUBLE,
 maker VARCHAR(30),
 material VARCHAR(1000),
 img VARCHAR(30)
);

create table members(
	id varchar(20) primary key,
	pw varchar(20),
	name varchar(20),
	addr varchar(200),
	tel varchar(15),
	allergy varchar(200),
);

select * from member;
drop table member;

desc food;
select *from food;
DELETE FROM food; */

public class ConnectionProxy {
	static Connection con = null;
	public static Connection getConnection() throws SQLException {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafy0924?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
					"ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
