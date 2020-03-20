package com.ssafy.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.MiddlepartVO;

@Repository
public class MiddlepartDaoImpl implements IMiddlepartDao{
	
	@Autowired
	SqlSession session;

	@Override
	public List<MiddlepartVO> getMiddlepartAllList() {
		return session.selectList("middle.getMiddlepartAllList");
	}

	@Override
	public boolean insertMiddlepart(String code, String name, String mainpart, String areaCode) {
		MiddlepartVO m = new MiddlepartVO(code, name, mainpart, areaCode);
		int n = session.update("middle.insertMiddlepart", m);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delMiddlepart(String code) {
		int n = session.delete("middle.delMiddlepart",code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMiddlepart(String code, String name, String mainpart, String areaCode) {
		MiddlepartVO m = new MiddlepartVO(code, name, mainpart, areaCode);
		int n = session.update("middle.updateMiddlepart", m);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<MiddlepartVO> getMaincodeAllList(String maincode) {
		return session.selectList("middle.getMaincodeAllList", maincode);
	}

}
