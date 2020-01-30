package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IVoteDao;
import com.ssafy.vote.dto.VoteVO;

@Service(value="VoteServiceImpl")
public class VoteServiceImpl implements IVoteService {

	@Autowired
	IVoteDao man;
	
	public VoteServiceImpl() {}
	
	@Override
	public List<VoteVO> getVoteAllList() {
		return man.getVoteAllList();
	}

	@Override
	public boolean insertVote(String name, String middlepart, String start, String end) {
		return man.insertVote(name, middlepart, start, end);
	}

	@Override
	public boolean delVote(int code) {
		return man.delVote(code);
	}

	@Override
	public boolean updateVote(int code, String name, String middlepart, String start, String end) {
		return man.updateVote(code, name, middlepart, start, end);
	}

	@Override
	public List<VoteVO> getVoteList(String votercode) {
		return man.getVoteList(votercode);
	}


}
