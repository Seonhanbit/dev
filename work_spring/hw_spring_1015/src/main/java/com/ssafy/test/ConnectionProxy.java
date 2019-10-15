package com.ssafy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*use hw;

select * from product;
drop table product;
create table product(
id varchar(4),
name varchar(20),
price int,
description varchar(100));

insert into product(id, name, price, description)
values(1,'삼성핸드폰', 100, '20191007'),
(2,'엘지핸드폰',50,'20191007'),
(3,'모토로라',10,'20191007');*/


public class ConnectionProxy {
	static Connection con = null;
	public static Connection getConnection() throws SQLException {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/hw?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
					"ssafy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
