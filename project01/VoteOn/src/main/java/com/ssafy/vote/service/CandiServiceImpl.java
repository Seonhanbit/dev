package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.ICandiDao;
import com.ssafy.vote.dto.CandidateVO;

@Service(value="CandiServiceImpl")
public class CandiServiceImpl implements ICandiService{
	
	@Autowired
	ICandiDao man;

	public CandiServiceImpl() {}
	
	@Override
	public List<CandidateVO> getCandiAllList() {
		return man.getCandiAllList();
	}

	@Override
	public boolean insertCandi(String name, String num, String party, int votecode, int pick) {
		return man.insertCandi(name, num, party, votecode, pick);
	}

	@Override
	public boolean delCandi(int code) {
		return man.delCandi(code);
	}

	@Override
	public boolean updateCandi(int code, String name, String num, String party, int votecode, int pick) {
		return man.updateCandi(code, name, num, party, votecode, pick);
	}

	@Override
	public boolean updateCandiSu(int code, int pick) {
		return man.updateCandiSu(code, pick);
	}

	@Override
	public CandidateVO getCandiCode(int code) {
		return man.getCandiCode(code);
	}

}
