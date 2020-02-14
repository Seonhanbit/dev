package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.IVoteDao;
import com.ssafy.vote.dto.VoteVO;

@Transactional
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
	public List<VoteVO> getVoteActiveList() {
		return man.getVoteActiveList();
	}

	@Override
	public boolean insertVote(String name, String middlepart, String start, String end) {
		//VoteVO v = new VoteVO(name, middlepart, start, end);
		//v = null;
		//return man.insertVote(v.getName(), v.getMiddlepart(), v.getStart(), v.getEnd());
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
