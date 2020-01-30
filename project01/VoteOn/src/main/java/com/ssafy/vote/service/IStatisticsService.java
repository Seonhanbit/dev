package com.ssafy.vote.service;

import java.util.List;

import com.ssafy.vote.dto.StatisticsVO;

public interface IStatisticsService {
	/**
	 * @author : 선한빛
	 * 기능 : 모든 통계 데이터를 조회하는 기능
	 * @Date : 2020. 1. 30.
	 */
	public List<StatisticsVO> getStatisticsAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 통계 등록
	 * @Date : 2020. 1. 30.
	 */
	public boolean insertStatistics(int candi_code);
	/**
	 * @author : 선한빛
	 * 기능 : 통계 삭제
	 * @Date : 2020. 1. 30.
	 */
	public boolean delStatistics(int s_code);
	/**
	 * @author : 선한빛
	 * 기능 : 통계 수정
	 * @Date : 2020. 1. 30.
	 */
	public boolean updateStatistics(int s_code, int candi_code, String s_date);
}
