package edu.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ssafy.vo.Member;

public class MemDaoImpl implements MemDao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;

	private void close() {
		try {
			if (conn != null)conn.close();
			if (pst != null)pst.close();
			if (rs != null)rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db close error");
		}
	}

	@Override
	public boolean memReg(String id, String pw, String name, String addr) {
		try {
			conn = ConnectionProxy.getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into mem values(?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, name);
			pst.setString(4, addr);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql Exception 발생");
		} finally {
			close();
		}

		return false;
	}

	@Override
	public boolean memUpdate(String id, String pw, String name, String addr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean memDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Member> memList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
