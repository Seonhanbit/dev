package com.ssafy.chap01;

import java.sql.*;

public class JDBCTest4 {
	//테이블에 데이터 넣기
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "ssafy");
		String str = "insert into customer(name, address)values(?,?)";
		PreparedStatement pst = con.prepareStatement(str);
		pst.setString(1, "홍길동");
		pst.setString(2, "광산구");
		boolean execute = pst.execute();
		
		
		String str2 = "select * from customer";
		Statement st2 = con.createStatement();
		ResultSet rs = st2.executeQuery(str2);
		while (rs.next()) {
			int num = rs.getInt("num");
			String name = rs.getString("name");
			String address = rs.getString("address");
			System.out.println(num+","+name+","+address);
		}
		pst.close();
		con.close();
	}

}
