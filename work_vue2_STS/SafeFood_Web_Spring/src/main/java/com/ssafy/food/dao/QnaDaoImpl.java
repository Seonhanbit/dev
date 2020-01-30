package com.ssafy.food.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.QnaVO;

@Repository
public class QnaDaoImpl implements IQnaDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean addQna(String title, String content, String id) {
		HashMap<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		map.put("id", id);
		int n = session.insert("qna.insertQna", map);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public QnaVO getQna(int num) {
		return session.selectOne("qna.selectOne", num);
	}

	@Override
	public List<QnaVO> getQnaList() {
		return session.selectList("qna.selectList");
	}

	@Override
	public boolean updateQna(int num, String title, String content, String id) {
		QnaVO q = new QnaVO(num, title, content, id);
		int n = session.update("qna.updateQna", q);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delQna(int num) {
		int n = session.delete("qna.deleteQna", num);
		if (n != 0)
			return true;
		else
			return false;
	}

}
