package com.ssafy.vote.service;

import java.util.List;

import com.ssafy.vote.dto.VoterVO;

public interface IVoterService {

	/**
	 * @author : 선한빛
	 * 기능 : 모든 투표자를 조회하는 메소드
	 * @Date : 2020. 1. 23.
	 */
	public List<VoterVO> getVoterAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 투표자 코드 입력 시 투표자 정보를 조회하는 기능
	 * @Date : 2020. 1. 30.
	 */	
	public VoterVO getVotercode(String code);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자를 등록하는 함수
	 * @Date : 2020. 1. 23.
	 */
	public boolean insertVoter(String code, String name, String areaCode);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자를 삭제하는 함수
	 * @Date : 2020. 1. 23.
	 */
	public boolean delVoter(String code);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자를 수정하는 함수
	 * @Date : 2020. 1. 23.
	 */
	public boolean updateVoter(String code, String name, String areaCode);

	
}
