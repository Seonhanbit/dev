package edu.ssafy.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ssafy.model.ConnectionProxy;

public class MemManagerImpl implements IMemManager{
	private static ArrayList<MemVO> list = new ArrayList<>();

	public MemManagerImpl() {
	}

	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	
	@Override
	public boolean addMem(String id, String pw, String name, String addr, String tel, String allergy) {
		String str = "insert into members(id,pw,name,addr,tel,allergy)values(?,?,?,?,?,?)";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, pw);
			st.setString(3, name);
			st.setString(4, addr);
			st.setString(5, tel);
			st.setString(6, allergy);
			res = st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}
		return res;
	}

	@Override
	public boolean delMem(String id) {
		String str = "delete from members where id = ?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}
		return res;
	}

	@Override
	public boolean updateMem(String id, String pw, String name, String addr, String tel) {
		String str = "update members set pw = ?, name =?, addr = ?,tel = ? where id = ?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, pw);
			st.setString(2, name);
			st.setString(3, addr);
			st.setString(4, tel);
			st.setString(5, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}
		return res;
	}

	@Override
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MemVO memInfo(String id) {
		String sql = "select * from members where id = ?";
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				vo = new MemVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setAddr(rs.getString("addr"));
				vo.setTel(rs.getString("tel"));
				vo.setAllergy("allergy");
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public boolean loginInfo(String id, String pw) {
		String sql_pw=null;
		String sql = "select pw from members where id = ?";
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				sql_pw = rs.getString("pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		if(pw.equals(sql_pw))
			return true;
		else
			return false;
	}

	@Override
	public String searchpw(String id, String name) {
		String sql = "select pw from members where id = ? and name = ?";
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
