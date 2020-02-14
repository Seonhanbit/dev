package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.IMainpartDao;
import com.ssafy.vote.dto.MainpartVO;
@Transactional
@Service(value="MainpartServiceImpl")
public class MainpartServiceImpl implements IMainpartService{
	
	@Autowired
	IMainpartDao man;

	@Override
	public List<MainpartVO> getMainpartAllList() {
		return man.getMainpartAllList();
	}

	@Override
	public boolean insertMainpart(String code, String name) {
		return man.insertMainpart(code, name);
	}

	@Override
	public boolean delMainpart(String code) {
		return man.delMainpart(code);
	}

	@Override
	public boolean updateMainpart(String code, String name) {
		return man.updateMainpart(code, name);
	}

}
