package com.ssafy.vote.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.CandidateVO;

@Repository
public class CandiDaoImpl implements ICandiDao{
	
	@Autowired
	SqlSession session;

	@Override
	public List<CandidateVO> getCandiAllList() {
		return session.selectList("candi.getCandiAllList");
	}

	@Override
	public boolean insertCandi(String name, String num, String party, int votecode, int pick) {
		CandidateVO c = new CandidateVO(name, num, party, votecode, pick);
		int n = session.insert("candi.insertCandi", c);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delCandi(int code) {
		int n = session.delete("candi.delCandi", code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCandi(int code, String name, String num, String party, int votecode, int pick) {
		CandidateVO c = new CandidateVO(code, name, num, party, votecode, pick);
		int n = session.update("candi.updateCandi", c);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCandiSu(int code, int pick) {
		System.out.println(pick);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("code", code);
		map.put("pick", pick);
		int n = session.update("candi.updateCandiSu", map);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public CandidateVO getCandiCode(int code) {
		return session.selectOne("candi.getCandiCode",code);
	}

}
