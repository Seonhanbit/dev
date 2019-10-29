package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.util.BoardDto;

public interface BoardRepository {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(String no);
	public BoardDto selectOne(String no);
	public List<BoardDto> selectList();
}
