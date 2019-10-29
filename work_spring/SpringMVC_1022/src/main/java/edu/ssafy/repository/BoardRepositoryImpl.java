package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.util.BoardDto;

@Repository("BoardRepositoryImpl")
public class BoardRepositoryImpl implements BoardRepository {
	@Autowired
	SqlSession session;

	@Override
	public BoardDto selectOne(String no) {
		return session.selectOne("board.selectOne", no);
	}

	@Override
	public List<BoardDto> selectList() {
		return session.selectList("board.selectlist");
	}

	@Override
	public int insert(BoardDto dto) {
		return session.insert("board.insert", dto);
	}

	@Override
	public int update(BoardDto dto) {
		return session.update("board.update", dto);
	}

	@Override
	public int delete(String no) {
		return session.delete("board.delete",no);
	}

}
