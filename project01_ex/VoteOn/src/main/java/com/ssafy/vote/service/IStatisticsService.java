package com.ssafy.vote.service;

import java.util.List;

import com.ssafy.vote.dto.CandidateVO;
import com.ssafy.vote.dto.StatisticsResultVO;
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
	/**
	 * @author : 선한빛
	 * 기능 : 투표 고유키, 날짜, 시간 입력 시 후보자명/득표수 리스트 조회
	 * @Date : 2020. 2. 3.
	 */
	public List<CandidateVO> getCandiPick(String votecode, String date, String hour);
	/**
	 * @author : 선한빛
	 * 기능 : 투표 고유키, 날짜, 시간 입력 시 후보자명/득표수 리스트 조회
	 * @Date : 2020. 2. 3.
	 */
	public List<StatisticsResultVO> getHourCnt(String candi_code, String date);
}
