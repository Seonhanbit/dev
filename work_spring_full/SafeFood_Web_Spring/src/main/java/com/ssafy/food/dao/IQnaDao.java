package com.ssafy.food.dao;

import java.util.List;

import com.ssafy.food.dto.QnaVO;

public interface IQnaDao {
	public boolean addQna(String title, String content, String id);
	public QnaVO getQna(int num);
	public List<QnaVO> getQnaList();
	public boolean updateQna(int num, String title, String content, String id);
	public boolean delQna(int num);
}
