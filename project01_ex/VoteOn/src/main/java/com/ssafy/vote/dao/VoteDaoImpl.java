package com.ssafy.vote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.VoteVO;

@Repository
public class VoteDaoImpl implements IVoteDao{

	@Autowired
	SqlSession session;
	
	@Override
	public List<VoteVO> getVoteAllList() {
		return session.selectList("vote.getVoteAllList");
	}
	
	@Override
	public List<VoteVO> getVoteActiveList() {
		return session.selectList("vote.getVoteActiveList");
	}

	@Override
	public boolean insertVote(String name, String middlepart, String start, String end) {
		VoteVO v = new VoteVO(name, middlepart, start, end);
		int n = session.insert("vote.insertVote", v);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delVote(int code) {
		int n = session.delete("vote.delVote", code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateVote(int code, String name, String middlepart, String start, String end) {
		VoteVO v = new VoteVO(code, name, middlepart, start, end);
		int n = session.update("vote.updateVote", v);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<VoteVO> getVoteList(String votercode) {
		return session.selectList("vote.getVoteList", votercode);
	}
}
