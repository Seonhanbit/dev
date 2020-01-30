package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.IQnaDao;
import com.ssafy.food.dto.QnaVO;

@Service
public class QnaServiceImpl implements IQnaService{
	
	@Autowired
	private IQnaDao man;

	@Override
	public boolean addQna(String title, String content, String id) {
		return man.addQna(title, content, id);
	}

	@Override
	public QnaVO getQna(int num) {
		return man.getQna(num);
	}

	@Override
	public List<QnaVO> getQnaList() {
		return man.getQnaList();
	}

	@Override
	public boolean updateQna(int num, String title, String content, String id) {
		return man.updateQna(num, title, content, id);
	}

	@Override
	public boolean delQna(int num) {
		return man.delQna(num);
	}

}
