package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.ICandiDao;
import com.ssafy.vote.dto.CandidateVO;
@Transactional
@Service(value="CandiServiceImpl")
public class CandiServiceImpl implements ICandiService{
	
	@Autowired
	ICandiDao man;
	
	@Autowired
	IStatisticsService s_ser;
	
	@Autowired
	IVotetfService vtf_ser;

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
		if(man.updateCandiSu(code, pick)) {
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
	public void updateCandiList(int votercode, String code) {
		String[] str = code.split(",");
		for(int i=0; i<str.length; i++) {
			int ncode = Integer.parseInt(str[i]);
			
			CandidateVO candi = man.getCandiCode(ncode);
			int npick = candi.getPick() + 1;
			
			this.updateCandiSu(ncode, npick);
			vtf_ser.insertVotetf(votercode, candi.getVotecode());
		}
	}

}
