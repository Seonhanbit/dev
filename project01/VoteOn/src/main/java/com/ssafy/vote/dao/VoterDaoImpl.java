package com.ssafy.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.VoterVO;

@Repository
public class VoterDaoImpl implements IVoterDao {

	@Autowired
	SqlSession session;

	@Override
	public List<VoterVO> getVoterAllList() {
		return session.selectList("voter.getVoterAllList");
	}

	@Override
	public boolean insertVoter(String code, String name, String areaCode) {
		VoterVO v = new VoterVO(code, name, areaCode);
		int n = session.insert("voter.insertVoter", v);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delVoter(String code) {
		int n = session.delete("voter.delVoter", code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateVoter(String code, String name, String areaCode) {
		VoterVO v = new VoterVO(code, name, areaCode);
		int n = session.update("voter.updateVoter", v);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public VoterVO getVotercode(String code) {
		return session.selectOne("voter.getVotercode", code);
	}

}
