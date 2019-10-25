package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Board;

@Repository("BoardRepositoryImplMyBatis")
public class BoardRepositoryImplMyBatis implements BoardRepository {
	private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryImplMyBatis.class);
	
	//@Autowired
	//private DataSource ds;
	
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession session;
	
	
	@Override
	public void insert(Board b) {
		logger.info("BoardRepositoryImplMyBatis {}","insert");
		session.insert("bo.insert", b);
	}

	@Override
	public void update(Board b) {
		logger.info("BoardRepositoryImplMyBatis {}","update");
		session.update("bo.update", b);
	}

	@Override
	public void delete(int seq) {
		logger.info("BoardRepositoryImplMyBatis {}","delete");
		session.delete("bo.delete", seq);
	}

	@Override
	public List<Board> list() {
		logger.info("BoardRepositoryImplMyBatis {}","list");
		return session.selectList("bo.selectList");
	}

	@Override
	public Board get(int seq) {
		logger.info("BoardRepositoryImplMyBatis {}","get");
		return session.selectOne("bo.selectOne", seq);
	}

	@Override
	public void countUp(int seq) {
		logger.info("BoardRepositoryImplMyBatis {}","countUp");
		session.update("bo.updateCount", seq);
		
	}

}
