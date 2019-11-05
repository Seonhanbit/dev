package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemManagerImpl implements IMemManager{
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	@Override
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		String str = "insert into memtb(id, pw, name, addr, email, tel, alinfo) values(?, ?, ?, ?, ?, ?, ?)";
		boolean res = false;
		try {
			System.out.println("id확 인 : "+id);
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, pw);
			st.setString(3, name);
			st.setString(4, addr);
			st.setString(5, email);
			st.setString(6, tel);
			st.setString(7, alinfo);
			System.out.println("등록들어는왓니?");
			res = st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	@Override
	public boolean isLogin(String id, String pw) {
		// TODO Auto-generated method stub
		String sql = "select * from memtb where id=? and pw=?";
		boolean res = false;
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pw);
			rs = st.executeQuery();
			rs.last();
			int cnt=rs.getRow();
			if(cnt==1) {
				res=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return res;
	}

	@Override
	//id기준으로 나머지 6개 정보 모두 입력해서 바꾸기
	public boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		String str="update memtb set pw=?,name=?,addr=?,email=?,tel=?,alinfo=? where id=?";
		boolean res=true;
		try {
			conn=ConnectionProxy.getConnection();
			st=conn.prepareStatement(str);
			st.setString(1, pw);
			st.setString(2, name);
			st.setString(3, addr);
			st.setString(4, email);
			st.setString(5, tel);
			st.setString(6, alinfo);
			st.setString(7, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=false;
		}finally {
			close();
		}
		return res;
	}

	@Override
	//아이디로 회원 삭제
	public boolean delMem(String id) {
		String str = "delete from memtb where id = ?";
		boolean res = false;
		try {
			conn=ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.execute();
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}


	@Override
	public MemVO getMemInfo(String id) {
		String str = "select * from memtb where id = ?";
		MemVO mem = new MemVO();
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			rs = st.executeQuery();

			if (rs.next()) {

				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setAddr(rs.getString("addr"));
				mem.setAlinfo(rs.getString("alinfo"));
				mem.setEmail(rs.getString("email"));
				mem.setPw(rs.getString("pw"));
				mem.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}


	@Override
	public String searchpw(String id, String name) {
		String sql = "select pw from memtb where id = ? and name = ?";
		String pw ="";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, name);
			rs = st.executeQuery();
			if (rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pw;
	}

}