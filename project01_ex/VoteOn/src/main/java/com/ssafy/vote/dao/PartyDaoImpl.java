package com.ssafy.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.PartyVO;

@Repository
public class PartyDaoImpl implements IPartyDao {

	@Autowired
	SqlSession session;

	@Override
	public List<PartyVO> getPartyAllList() {
		return session.selectList("party.getPartyAllList");
	}

	@Override
	public boolean insertParty(String p_code, String p_name) {
		PartyVO p = new PartyVO(p_code, p_name);
		int n = session.insert("party.insertParty", p);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delParty(String p_code) {
		int n = session.delete("party.delParty", p_code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateParty(String p_code, String p_name) {
		PartyVO p = new PartyVO(p_code, p_name);
		int n = session.update("party.updateParty", p);
		if (n != 0)
			return true;
		else
			return false;
	}

}
