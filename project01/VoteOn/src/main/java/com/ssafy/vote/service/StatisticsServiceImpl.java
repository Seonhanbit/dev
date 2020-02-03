package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IStatisticsDao;
import com.ssafy.vote.dto.CandidateVO;
import com.ssafy.vote.dto.StatisticsResultVO;
import com.ssafy.vote.dto.StatisticsVO;

@Service(value="StatisticsServiceImpl")
public class StatisticsServiceImpl implements IStatisticsService{
	
	@Autowired
	IStatisticsDao man;

	@Override
	public List<StatisticsVO> getStatisticsAllList() {
		return man.getStatisticsAllList();
	}

	@Override
	public boolean insertStatistics(int candi_code) {
		return man.insertStatistics(candi_code);
	}

	@Override
	public boolean delStatistics(int s_code) {
		return man.delStatistics(s_code);
	}

	@Override
	public boolean updateStatistics(int s_code, int candi_code, String s_date) {
		return man.updateStatistics(s_code, candi_code, s_date);
	}

	@Override
	public List<CandidateVO> getCandiPick(String votecode, String date, String hour) {
		return man.getCandiPick(votecode, date, hour);
	}

	@Override
	public List<StatisticsResultVO> getHourCnt(String candi_code, String date) {
		return man.getHourCnt(candi_code, date);
	}

}
