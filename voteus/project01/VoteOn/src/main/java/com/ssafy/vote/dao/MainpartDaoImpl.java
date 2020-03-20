package com.ssafy.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.MainpartVO;

@Repository
public class MainpartDaoImpl implements IMainpartDao{
	
	@Autowired
	SqlSession session;

	@Override
	public List<MainpartVO> getMainpartAllList() {
		return session.selectList("main.getMainpartAllList");
	}

	@Override
	public boolean insertMainpart(String code, String name) {
		MainpartVO m = new MainpartVO(code, name);
		int n = session.insert("main.insertMainpart",m);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delMainpart(String code) {
		int n = session.delete("main.delMainpart", code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMainpart(String code, String name) {
		MainpartVO m = new MainpartVO(code, name);
		int n = session.update("main.updateMainpart", m);
		if (n != 0)
			return true;
		else
			return false;
	}

}
