package com.ssafy.vote.dao;

import java.util.HashMap;
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
	public boolean insertVoter(int code, String id_num, String name, String areaCode) {
		VoterVO v = new VoterVO(code, id_num, name, areaCode);
		int n = session.insert("voter.insertVoter", v);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delVoter(int code) {
		int n = session.delete("voter.delVoter", code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateVoter(int code, String name, String areaCode) {
		VoterVO v = new VoterVO(code, name, areaCode);
		int n = session.update("voter.updateVoter", v);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public VoterVO getVotercode(int code) {
		return session.selectOne("voter.getVotercode", code);
	}

	@Override
	public int getOnlyVotercode(String name, String id_num) {
		VoterVO voter = new VoterVO(name, id_num);
		return session.selectOne("voter.getOnlyVotercode", voter);
	}

	@Override
	public HashMap<String, Object> getDaeseonVoteProgressData(String voteCode) {
		return session.selectOne("voter.getDaeseonVoteProgressData", voteCode);
	}

	@Override
	public HashMap<String, Object> getNotDaeseonVoteProgressData(String voteCode) {
		return session.selectOne("voter.getNotDaeseonVoteProgressData", voteCode);
	}

}
