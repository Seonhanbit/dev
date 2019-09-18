package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemManager {
	private Connection conn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	private static ArrayList<MemVO> list = new ArrayList<>();
	private static MemManager man = new MemManager();

	private MemManager() {
	}

	public static MemManager getInstance() {
		return man;
	}

	public boolean addMem(String id, String name, String pw, String addr, int age, String tel) {
		String str = "insert into memberweb(id, name, pw, addr, age, tel) values(?, ?, ?, ?, ?, ?)";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, pw);
			st.setString(4, addr);
			st.setInt(5, age);
			st.setString(6, tel);
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
//		list.add(new MemVO(id, name, pw, addr, age, tel));
//		return true;
	}

	public boolean delMem(String id) {
		String str = "delete from memberweb where id=?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
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
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getId().equals(id)) {
//				list.remove(i);
//			}
//		}
//		return true;
	}

	public boolean updateMem(String id, String name, String pw, String addr, int age, String tel) {
		String str = "update memberweb set name=?, pw=?, addr=?, age=?, tel=? where id=?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, name);
			st.setString(2, pw);
			st.setString(3, addr);
			st.setInt(4, age);
			st.setString(5, tel);
			st.setString(6, id);
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
//		for (int i = 0; i < list.size(); i++)
//			if (list.get(i).getId().equals(id)) {
//				list.set(i, new MemVO(id, name, pw, addr, age, tel));
//				break;
//			}
//		return true;
	}

	public ArrayList<MemVO> getList() {
		String sql = "select * from memberweb";
		ArrayList<MemVO> list = new ArrayList<>();
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				MemVO vo = new MemVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setAddr(rs.getString("addr"));
				vo.setAge(rs.getInt("age"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
//		return list;
	}

	public MemVO memInfo(String id) {
		String sql = "select * from memberweb where id=?";
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
				vo.setAge(rs.getInt("age"));
				vo.setTel(rs.getString("tel"));
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
//		for (MemVO memVO : list) {
//			if (memVO.getId().equals(id)) {
//				return memVO;
//			}
//		}
//		return null;
	}

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

	public boolean loginInfo(String id, String pw) {
		String sql_pw = null;
		String sql = "select pw from memberweb where id=?";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next())
				sql_pw = rs.getString("pw");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		if (pw.equals(sql_pw))
			return true;
		else
			return false;
	}
}
