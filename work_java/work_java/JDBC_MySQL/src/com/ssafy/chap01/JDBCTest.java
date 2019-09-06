package com.ssafy.chap01;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) throws Exception {
		//driver loading 필요
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		Statement st = con.createStatement();
		
		//ResultSet은 2차원 행렬구조, "select * from emp where sal = ?"
		ResultSet rs = st.executeQuery("select * from emp");
//		boolean execute = st.execute("insert");
		//next가 있으면 true
		while(rs.next()) {
			String ename = rs.getString("ename");
			int sal = rs.getInt("sal");
			int deptno = rs.getInt("deptno");
			
			System.out.printf("%s, %d, %d\n", ename, sal, deptno);
		}
		rs.close();
		st.close();
		con.close();
	}

}
