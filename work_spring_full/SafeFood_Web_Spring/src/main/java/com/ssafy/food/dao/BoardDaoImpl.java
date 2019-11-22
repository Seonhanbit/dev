package com.ssafy.food.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.BoardVO;

@Repository
public class BoardDaoImpl implements IBoardDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean addBoard(String id, String title, String content) {
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("title", title);
		map.put("content", content);
		
		int n = session.insert("board.insertBoard", map);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public BoardVO getBoard(int num) {
		return session.selectOne("board.selectOne", num);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return session.selectList("board.selectList");
	}

	@Override
	public boolean updateBoard(int num, String title, String content) {
		BoardVO q = new BoardVO(num, title, content);
		int n = session.update("board.updateBoard", q);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delBoard(int num) {
		int n = session.delete("board.deleteBoard", num);
		if (n != 0)
			return true;
		else
			return false;
	}

}
