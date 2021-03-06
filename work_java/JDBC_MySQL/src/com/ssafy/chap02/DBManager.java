package com.ssafy.chap02;

import java.sql.*;
import java.util.ArrayList;

//MySQl에 데이터가 있고, manager는 연결만 해주고 있음 > 싱글턴 적용 필요x
public class DBManager {
	// 맴버변수라서 디폴트 초기화라 초기화 필요 없음
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	// 객체 생성될때 1번만 생성됨 >>static, 매니저 생성될때마다 로딩되면 안되니까
	static {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DBManager() throws SQLException {
		// 2. connection 연결, 던져야하는이유 > 메인에서 매니저 호출 시 다음 문장 실행되면 안돼
		con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
				"ssafy");
	}
	//static이랑 생성자를 메소드로 합치기
//	public Connection getConnection() throws SQLException {
//		try {
//			// 1. 드라이버 로딩
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
//					"ssafy");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//	}
	

	// 필요할 메소드 구현하기
	public boolean insertCustomer(String name, int age, String addr) {
		String str = "insert into customer(name, age, addr)values(?,?,?)";
		boolean res = false;
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, addr);
			res = pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public boolean updateCustomer(int num, String name, int age, String addr) {
		String str = "update customer set name =?, age = ?, addr = ? where num = ?";
		boolean res = false;
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, addr);
			pst.setInt(4, num);
			res = pst.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public boolean deleteCustomer(int num) {
		String str = "delete from customer where num = ?";
		boolean res = false;
		try {
			pst = con.prepareStatement(str);
			pst.setInt(1, num);
			res = pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// 전체 조회
	public ArrayList<CustomerVO> queryCustomer() {
		String sql = "select * from Customer";
		ArrayList<CustomerVO> list = null;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				CustomerVO vo = new CustomerVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddr(rs.getString("addr"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 조건부 검색
	public CustomerVO queryCustomerByNum(int num) {
		String sql = "select * from Customer where num = ?";
		CustomerVO vo = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			if (rs.next()) {
				vo = new CustomerVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddr(rs.getString("addr"));
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
