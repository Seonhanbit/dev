package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.VoterVO;

public interface IVoterDao {
	
	public List<VoterVO> getVoterAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 투표자 코드 입력 시 투표자 정보를 조회하는 기능
	 * @Date : 2020. 1. 30.
	 */	
	public VoterVO getVotercode(String code);
	public boolean insertVoter(String code, String name, String areaCode);
	public boolean delVoter(String code);
	public boolean updateVoter(String code, String name, String areaCode);
}
