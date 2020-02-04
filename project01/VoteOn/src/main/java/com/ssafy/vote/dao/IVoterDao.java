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
	public VoterVO getVotercode(int code);
	public boolean insertVoter(int code, String id_num, String name, String areaCode);
	public boolean delVoter(int code);
	public boolean updateVoter(int code, String name, String areaCode);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자 이름/주민번호 입력시 투표자 고유키를 넘겨주는 기능
	 * @Date : 2020. 2. 4.
	 */
	public int getOnlyVotercode(String name, String id_num);
}
