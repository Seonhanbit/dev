package com.ssafy.vote.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.IStatisticsDao;
import com.ssafy.vote.dto.CandidateVO;
import com.ssafy.vote.dto.StatisticsResultVO;
import com.ssafy.vote.dto.StatisticsVO;
@Transactional
@Service(value = "StatisticsServiceImpl")
public class StatisticsServiceImpl implements IStatisticsService {

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
		List<StatisticsResultVO> list = man.getHourCnt(candi_code, date);
		if (list.size() == 0) {
			for (int i = 0; i < 24; i++) {
				if(i>=10) {
					String str = i+"";
					list.add(new StatisticsResultVO(str, "0"));
				}else {
					String str = "0"+i;
					list.add(new StatisticsResultVO(str, "0"));
				}
			}
		} else {
			for (int j = 0; j < 24; j++) {
				boolean flag = true;
				for (int i = 0; i < list.size(); i++) {
					String str = "0" + list.get(i).getHour();
					String nj = "0" + j;
					if (str.equals(nj)) {
						flag = false;
						list.set(i, new StatisticsResultVO(str, list.get(i).getCnt()));
						break;
					}
				}
				if (flag) {
					if(j>=10) {
						String str = j+"";
						list.add(new StatisticsResultVO(str, "0"));
					}else {
						String str = "0"+j;
						list.add(new StatisticsResultVO(str, "0"));
					}
				}
			}
			Collections.sort(list);
		}
		return list;
	}

}
