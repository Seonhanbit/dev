package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	private static MemberManager man = new MemberManager();
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	
	private MemberManager() {
	}

	public static MemberManager getInstance() {
		return man;
	}

	public boolean addMember(MemberVO memberVO) {
		String sql = "INSERT INTO members(name, userid, pwd, email, phone, admin)values(?,?,?,?,?,?)";
		int result = 0;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, memberVO.getName());
			st.setString(2, memberVO.getUserid());
			st.setString(3, memberVO.getPwd());
			st.setString(4, memberVO.getEmail());
			st.setString(5, memberVO.getPhone());
			st.setInt(6, memberVO.getAdmin());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return result>0? true:false;
	}
	
	public MemberVO getMember(String userid) {
		String sql = "SELECT * FROM members WHERE userid=?";
		MemberVO memberVO = null;
		try {
			conn = ConnectionProxy.getConnection();//sql 통로
			st = conn.prepareStatement(sql); //상자규격에 담아서 sql을 보내자
			st.setString(1, userid);
			rs = st.executeQuery(); 
			// > DQL 결과가 테이블로 나올때  
			//execute > DDL쓸때 테이블수정/삭제
			//executeUpdate > DML
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setName(rs.getString("name"));
				memberVO.setUserid(rs.getString("userid"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberVO;
	}
	
	public List<MemberVO> getMemberList(){
		String sql = "SELECT * FROM members";
		List<MemberVO> memberList = new ArrayList<>();
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql); 
			rs = st.executeQuery(); 
			while(rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setName(rs.getString("name"));
				memberVO.setUserid(rs.getString("userid"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setAdmin(rs.getInt("admin"));
				memberList.add(memberVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return memberList;
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
}
