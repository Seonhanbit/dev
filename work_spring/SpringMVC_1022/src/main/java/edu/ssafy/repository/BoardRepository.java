package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.util.BoardDto;

public interface BoardRepository {
	public void insert(BoardDto dto);
	public void update(BoardDto dto);
	public void delete(String no);
	public BoardDto selectOne(String no);
	public List<BoardDto> selectList();
}
