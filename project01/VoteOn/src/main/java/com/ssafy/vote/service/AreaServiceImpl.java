package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IAreaDao;
import com.ssafy.vote.dto.AreaVO;

@Service(value="AreaServiceImpl")
public class AreaServiceImpl implements IAreaService{
	
	@Autowired
	IAreaDao man;

	@Override
	public List<AreaVO> getAreaAllList() {
		return man.getAreaAllList();
	}

	@Override
	public boolean insertArea(String areaCode, String name) {
		return man.insertArea(areaCode, name);
	}

	@Override
	public boolean delArea(String areaCode) {
		return man.delArea(areaCode);
	}

	@Override
	public boolean updateArea(String areaCode, String name) {
		return man.updateArea(areaCode, name);
	}

}
