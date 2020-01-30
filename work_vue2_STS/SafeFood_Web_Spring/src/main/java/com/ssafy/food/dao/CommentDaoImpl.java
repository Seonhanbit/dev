package com.ssafy.food.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.CommentVO;

@Repository
public class CommentDaoImpl implements ICommentDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean addComment(String qnanum, String content, String id) {
		HashMap<String, String> map = new HashMap<>();
		map.put("qnanum", qnanum);
		map.put("content", content);
		map.put("id", id);
		int n = session.insert("comment.insertComment", map);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delComment(int num) {
		int n = session.delete("comment.deleteComment", num);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<CommentVO> getCommentList(String qnanum) {
		return session.selectList("comment.selectList", qnanum);
	}

	@Override
	public boolean updateComment(int num, String content, String id) {
		CommentVO q = new CommentVO(num, content, id);
		int n = session.update("comment.updateComment", q);
		if (n != 0)
			return true;
		else
			return false;
	}


}
