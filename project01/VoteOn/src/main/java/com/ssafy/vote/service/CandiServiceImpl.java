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
	
	@Autowired
	IStatisticsService s_ser;	

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
		CandidateVO candi = man.getCandiCode(code);
		int npick = candi.getPick() + pick;
		
		if(man.updateCandiSu(code, npick)) {
			s_ser.insertStatistics(code);
			return true;
		}else
			return false;
		
	}

	@Override
	public CandidateVO getCandiCode(int code) {
		return man.getCandiCode(code);
	}

	@Override
	public List<CandidateVO> getCandiVotecode(int votecode) {
		return man.getCandiVotecode(votecode);
	}

	@Override
	public void updateCandiList(String code) {
		String[] str = code.split(",");
		for(int i=0; i<str.length; i++) {
			int ncode = Integer.parseInt(str[i]);
			this.updateCandiSu(ncode, 1);
		}
	}

}
