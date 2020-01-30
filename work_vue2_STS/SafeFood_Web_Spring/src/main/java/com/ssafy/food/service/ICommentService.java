package com.ssafy.food.service;

import java.util.List;

import com.ssafy.food.dto.CommentVO;

public interface ICommentService {
	public boolean addComment(String qnanum, String content, String id);
	public List<CommentVO> getCommentList(String qnanum);
	public boolean updateComment(int num, String content, String id);
	public boolean delComment(int num);
}
