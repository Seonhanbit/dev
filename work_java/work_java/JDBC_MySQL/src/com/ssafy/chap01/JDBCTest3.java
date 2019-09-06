package com.ssafy.chap01;

import java.sql.*;

public class JDBCTest3 {
	//테이블 생성하기
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "ssafy");
		Statement st = con.createStatement();
		//auto_increment 값을 안주면 하나씩 자동증가
		String str = "create table customer(num int primary key auto_increment, name varchar(20), address varchar(1000))";
		boolean execute = st.execute(str);
		System.out.println("테이블 생성");
		st.close();
		con.close();
	}

}
