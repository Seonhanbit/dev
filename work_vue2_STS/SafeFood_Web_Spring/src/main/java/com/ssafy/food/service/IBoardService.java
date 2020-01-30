package com.ssafy.food.service;

import java.util.List;

import com.ssafy.food.dto.BoardVO;

public interface IBoardService {
	public boolean addBoard(String id, String title, String content);
	public BoardVO getBoard(int num);
	public List<BoardVO> getBoardList();
	public boolean updateBoard(int num, String title, String content);
	public boolean delBoard(int num);
}
