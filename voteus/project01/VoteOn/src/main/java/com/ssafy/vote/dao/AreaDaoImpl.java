package com.ssafy.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.AreaVO;

@Repository
public class AreaDaoImpl implements IAreaDao{

	@Autowired
	SqlSession session;
	
	@Override
	public List<AreaVO> getAreaAllList() {
		return session.selectList("area.getAreaAllList");
	}

	@Override
	public boolean insertArea(String areaCode, String name) {
		AreaVO a = new AreaVO(areaCode, name);
		int n = session.insert("area.insertArea", a);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delArea(String areaCode) {
		int n = session.delete("area.delArea", areaCode);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateArea(String areaCode, String name) {
		AreaVO a = new AreaVO(areaCode, name);
		int n = session.insert("area.updateArea", a);
		if (n != 0)
			return true;
		else
			return false;
	}

}
