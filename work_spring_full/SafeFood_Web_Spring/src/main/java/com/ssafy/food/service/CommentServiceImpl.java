package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.ICommentDao;
import com.ssafy.food.dao.IQnaDao;
import com.ssafy.food.dto.CommentVO;
import com.ssafy.food.dto.QnaVO;

@Service
public class CommentServiceImpl implements ICommentService{
	
	@Autowired
	private ICommentDao man;

	@Override
	public boolean addComment(String qnanum, String content, String id) {
		return man.addComment(qnanum, content, id);
	}

	@Override
	public List<CommentVO> getCommentList(String qnanum) {
		return man.getCommentList(qnanum);
	}

	@Override
	public boolean updateComment(int num,String content, String id) {
		return man.updateComment(num, content, id);
	}

	@Override
	public boolean delComment(int num) {
		return man.delComment(num);
	}

	
}
