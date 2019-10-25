package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.ssafy.controller.HomeController;
import edu.ssafy.dto.Member;

@Repository("MemberRepositoryImplDataSource")
public class MemberRepositoryImplDataSource implements MemberRepository{
	private static final Logger logger = LoggerFactory.getLogger(MemberRepositoryImplDataSource.class);
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate dbtem;
	
	private Connection conn = null;
	private PreparedStatement stmt= null;
	private ResultSet rs = null;
	
	private final String MEMBER_INSERT = "insert into member(id, pw, name, addr) "
			+ " values(?,?,?,?)";
	
	private final String MEMBER_INSERT1 = "insert into member(id, pw, name, addr) "
			+ " values(?,?,?,?)";
	
	private final String MEMBER_UPDATE = "update member set pw=?, name=?, addr=? where id=?";
	private final String MEMBER_DELETE = "delete from member where id=?";
	private final String MEMBER_ONE = "select * from member where id=?";
	private final String MEMBER_LIST = "select * from member ORDER BY id DESC";
	
	@Override
	public void insert(Member m) {
		logger.info("MemberRepositoryImpl {}","insert");
		
		int update = dbtem.update(MEMBER_INSERT, new Object[]{m.getId(),m.getPw(),m.getName(),m.getAddr()});
		
		
//		try {
//			conn = JDBCUtil.getConnection();
//			conn = ds.getConnection();
//			stmt = conn.prepareStatement(MEMBER_INSERT);
//			
//			stmt.setString(1, m.getId());
//			stmt.setString(2, m.getPw());
//			stmt.setString(3, m.getName());
//			stmt.setString(4, m.getAddr());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//		
//			System.out.println(stmt.toString());
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(stmt, conn);
//		}
	}

	@Override
	public void update(Member m) {
		logger.info("MemberRepositoryImpl {}","update");
		try {
			//conn = JDBCUtil.getConnection();
			conn = ds.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, m.getPw());
			stmt.setString(2, m.getName());
			stmt.setString(3, m.getAddr());
			stmt.setString(4, m.getId());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void delete(String id) {
		logger.info("MemberRepositoryImpl {}","delete");
		try {
			//conn = JDBCUtil.getConnection();
			conn = ds.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setString(1, id);
			stmt.executeUpdate();
			System.out.println(stmt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public List<Member> list() {
		logger.info("MemberRepositoryImpl {}","list");
		return dbtem.query(MEMBER_LIST, new MemberMapper());
		
//		Member m=null;
//		ArrayList<Member> list = new ArrayList<Member>();
//		try {
//			//conn = JDBCUtil.getConnection();
//			conn = ds.getConnection();
//			stmt = conn.prepareStatement(MEMBER_LIST);
//			rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				m = new Member();
//				m.setId(rs.getString("id"));
//				m.setPw(rs.getString("pw"));
//				m.setName(rs.getString("name"));
//				m.setAddr(rs.getString("addr"));
//				list.add(m);
//			}
//		} catch (Exception e) {
//
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return list;
	}
	
	class MemberMapper implements RowMapper<Member>{
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setAddr(rs.getString("addr"));
			return m;
		}
	}
	
	@Override
	public Member get(String id) {
		logger.info("MemberRepositoryImpl {}","get");
		return dbtem.queryForObject(MEMBER_ONE, new Object[] {id}, new MemberMapper());
		
//		Member m=null;
//		try {
//			//conn = JDBCUtil.getConnection();
//			conn = ds.getConnection();
//			stmt = conn.prepareStatement(MEMBER_ONE);
//			stmt.setString(1, id);
//			//System.out.println(stmt);
//			rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				m = new Member();
//				m.setId(rs.getString("id"));
//				m.setPw(rs.getString("pw"));
//				m.setName(rs.getString("name"));
//				m.setAddr(rs.getString("addr"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
	}



}
