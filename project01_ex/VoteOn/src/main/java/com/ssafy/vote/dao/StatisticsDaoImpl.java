package com.ssafy.vote.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vote.dto.CandidateVO;
import com.ssafy.vote.dto.StatisticsResultVO;
import com.ssafy.vote.dto.StatisticsVO;
@Repository
public class StatisticsDaoImpl implements IStatisticsDao{
	
	@Autowired
	SqlSession session;

	@Override
	public List<StatisticsVO> getStatisticsAllList() {
		return session.selectList("stati.getStatisticsAllList");
	}

	@Override
	public boolean insertStatistics(int candi_code) {
		int n = session.insert("stati.insertStatistics", candi_code);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean delStatistics(int s_code) {
		int n = session.delete("stati.delStatistics", s_code);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateStatistics(int s_code, int candi_code, String s_date) {
		StatisticsVO s = new StatisticsVO(s_code, candi_code, s_date);
		int n = session.update("stati.updateStatistics", s);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<CandidateVO> getCandiPick(String votecode, String date, String hour) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("votecode", votecode);
		map.put("date", date);
		map.put("hour", hour);
		return session.selectList("stati.getCandiPick",map);
	}

	@Override
	public List<StatisticsResultVO> getHourCnt(String candi_code, String date) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("candi_code", candi_code);
		map.put("date", date);
		return session.selectList("stati.getHourCnt",map);
	}

}
