package edu.ssafy.service;

import java.util.List;

import edu.ssafy.util.BoardDto;

public interface BoardService {
	public int insert(String no, String title, String content);
	public int update(String no, String title, String content);
	public int delete(String no);
	public BoardDto selectOne(String no);
	public List<BoardDto> selectList();
}
