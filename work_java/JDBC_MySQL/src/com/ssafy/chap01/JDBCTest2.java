package com.ssafy.chap01;

import java.sql.*;

public class JDBCTest2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs  = null;
		try {
			// 1. 클래스 드라이버 로딩
			// 2. connection 연결
			// 3. query 작성
			// 4. query 실행
			// 5. 결과값 가져오기
			// 6. close

			// 1. 클래스 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. connection 연결 > 서버주소, 아이디, 비밀번호
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "ssafy");
			// 3. query 작성 (조회)
			String sql = "select * from emp where sal > ? and deptno = ? and ename = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, 2000);
			pst.setInt(2, 10);
			pst.setString(3, "king");
			// 4. query 실행
			rs = pst.executeQuery();
			// 5. 결과값 가져오기
			while (rs.next()) {
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				int deptno = rs.getInt("deptno");
				System.out.printf("%s, %d, %d\n", ename, sal, deptno);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. close
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
