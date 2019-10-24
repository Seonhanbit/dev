package edu.ssafy.service;

import java.util.List;

import edu.ssafy.util.BoardDto;

public interface BoardService {
	public void insert(String no, String title, String content);
	public void update(String no, String title, String content);
	public void delete(String no);
	public BoardDto selectOne(String no);
	public List<BoardDto> selectList();
}
