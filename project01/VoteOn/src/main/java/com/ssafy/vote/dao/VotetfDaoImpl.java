package com.ssafy.vote.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.VotetfVO;

@Repository
public class VotetfDaoImpl implements IVotetfDao{
	
	@Autowired
	SqlSession session;

	@Override
	public boolean insertVotetf(String votercode, int votecode) {
		VotetfVO v = new VotetfVO(votercode, votecode);
		int n = session.insert("votetf.insertVotetf", v);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delVotetf(String votercode, int votecode) {
		VotetfVO v = new VotetfVO(votercode, votecode);
		int n = session.delete("votetf.delVotetf", v);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Integer> getvotecode(String votercode) {
		return session.selectList("votetf.getvotecode",votercode);
	}

}
