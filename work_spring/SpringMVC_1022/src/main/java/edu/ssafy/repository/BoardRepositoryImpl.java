package edu.ssafy.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.util.BoardDto;

@Repository("BoardRepositoryImpl")
public class BoardRepositoryImpl implements BoardRepository {

	@Override
	public void insert(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDto selectOne(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

}
