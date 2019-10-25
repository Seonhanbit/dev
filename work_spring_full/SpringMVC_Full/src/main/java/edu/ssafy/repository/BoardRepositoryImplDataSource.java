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
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Board;

@Repository("BoardRepositoryImplDataSource")
public class BoardRepositoryImplDataSource implements BoardRepository {
	private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryImplDataSource.class);
	
	@Autowired
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private static String BOARD_INSERT = "INSERT INTO board(title, writer, content, regDate) VALUES (?, ?, ?, now())";
	private static String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq=?";
	private static String BOARD_DELETE = "DELETE FROM board WHERE seq=?";
	private static String BOARD_SELECT = "SELECT seq, title, writer, content, regDate, count FROM board WHERE seq=?";
	private static String BOARD_ALL_SELECT = "SELECT seq, title, writer, content, regDate, count FROM board";
	private static String COUNT_UP = "UPDATE board SET count=count+1 WHERE seq=?";
	
	@Override
	public void insert(Board b) {
		logger.info("BoardRepositoryImplDataSource {}","insert");
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getWriter());
			stmt.setString(3, b.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void update(Board b) {
		logger.info("BoardRepositoryImplDataSource {}","update");
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getContent());
			stmt.setInt(3, b.getSeq());
			System.out.println(stmt);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public void delete(int seq) {
		logger.info("BoardRepositoryImplDataSource {}","delete");
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, seq);
			System.out.println(stmt);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	@Override
	public List<Board> list() {
		logger.info("BoardRepositoryImplDataSource {}","list");
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BOARD_ALL_SELECT);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setSeq(rs.getInt("seq"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setContent(rs.getString("content"));
				b.setRegDate(rs.getDate("regDAte"));
				b.setCount(rs.getInt("count"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return list;
	}

	@Override
	public Board get(int seq) {
		logger.info("BoardRepositoryImplDataSource {}","get");
		Board b = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(BOARD_SELECT);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				b = new Board();
				b.setSeq(rs.getInt("seq"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setContent(rs.getString("content"));
				b.setRegDate(rs.getDate("regDAte"));
				b.setCount(rs.getInt("count"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return b;
	}

	@Override
	public void countUp(int seq) {
		logger.info("MemberRepositoryImpl {}","countUp");
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(COUNT_UP);
			stmt.setInt(1, seq);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

}
