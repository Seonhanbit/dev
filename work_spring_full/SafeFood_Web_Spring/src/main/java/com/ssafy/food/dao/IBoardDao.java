package com.ssafy.food.dao;

import java.util.List;

import com.ssafy.food.dto.BoardVO;

public interface IBoardDao {
	public boolean addBoard(String id, String title, String content);
	public BoardVO getBoard(int num);
	public List<BoardVO> getBoardList();
	public boolean updateBoard(int num, String title, String content);
	public boolean delBoard(int num);
}
