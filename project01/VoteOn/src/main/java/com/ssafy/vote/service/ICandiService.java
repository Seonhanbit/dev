package com.ssafy.vote.service;

import java.util.List;

import com.ssafy.vote.dto.CandidateVO;


public interface ICandiService {
	/**
	 * @author : 선한빛
	 * 기능 : 모든 후보자 리스트 조회
	 * @Date : 2020. 1. 28.
	 */
	public List<CandidateVO> getCandiAllList();
	/**
	 * @author : 선한빛
	 * 기능 : code로 특정 후보자 조회
	 * @Date : 2020. 1. 28.
	 */
	public CandidateVO getCandiCode(int code);
	/**
	 * @author : 선한빛
	 * 기능 : 후보자 등록
	 * @Date : 2020. 1. 28.
	 */
	public boolean insertCandi(String name, String num, String party, int votecode, int pick);
	/**
	 * @author : 선한빛
	 * 기능 : 후보자 삭제
	 * @Date : 2020. 1. 28.
	 */
	public boolean delCandi(int code);
	/**
	 * @author : 선한빛
	 * 기능 : 후보자 업데이트
	 * @Date : 2020. 1. 28.
	 */
	public boolean updateCandi(int code, String name, String num, String party, int votecode, int pick);
	/**
	 * @author : 선한빛
	 * 기능 : 후보자 득표수 업데이트
	 * @Date : 2020. 1. 28.
	 */
	public boolean updateCandiSu(int code, int pick);
}
