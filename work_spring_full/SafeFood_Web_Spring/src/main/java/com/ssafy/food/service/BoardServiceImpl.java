package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.IBoardDao;
import com.ssafy.food.dto.BoardVO;

@Service
public class BoardServiceImpl implements IBoardService{
	
	@Autowired
	private IBoardDao man;

	@Override
	public boolean addBoard(String id, String title, String content) {
		return man.addBoard(id, title, content);
	}

	@Override
	public BoardVO getBoard(int num) {
		return man.getBoard(num);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return man.getBoardList();
	}

	@Override
	public boolean updateBoard(int num, String title, String content) {
		return man.updateBoard(num, title, content);
	}

	@Override
	public boolean delBoard(int num) {
		return man.delBoard(num);
	}
}
