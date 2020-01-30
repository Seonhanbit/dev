package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IMiddlepartDao;
import com.ssafy.vote.dto.MiddlepartVO;

@Service(value="MiddlepartServiceImpl")
public class MiddlepartServiceImpl implements IMiddlepartService{
	
	@Autowired
	IMiddlepartDao man;

	@Override
	public List<MiddlepartVO> getMiddlepartAllList() {
		return man.getMiddlepartAllList();
	}

	@Override
	public boolean insertMiddlepart(String code, String name, String mainpart, String areaCode) {
		return man.insertMiddlepart(code, name, mainpart, areaCode);
	}

	@Override
	public boolean delMiddlepart(String code) {
		return man.delMiddlepart(code);
	}

	@Override
	public boolean updateMiddlepart(String code, String name, String mainpart, String areaCode) {
		return man.updateMiddlepart(code, name, mainpart, areaCode);
	}

	@Override
	public List<MiddlepartVO> getMaincodeAllList(String maincode) {
		return man.getMaincodeAllList(maincode);
	}

}
