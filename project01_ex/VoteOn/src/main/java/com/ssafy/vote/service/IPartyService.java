package com.ssafy.vote.service;

import java.util.List;

import com.ssafy.vote.dto.PartyVO;

public interface IPartyService {
	/**
	 * @author : 선한빛
	 * 기능 : 모든 정당 데이터를 조회하는 기능
	 * @Date : 2020. 1. 30.
	 */
	public List<PartyVO> getPartyAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 정당 등록
	 * @Date : 2020. 1. 30.
	 */
	public boolean insertParty(String p_code, String p_name);
	/**
	 * @author : 선한빛
	 * 기능 : 정당 삭제
	 * @Date : 2020. 1. 30.
	 */
	public boolean delParty(String p_code);
	/**
	 * @author : 선한빛
	 * 기능 : 정당 수정
	 * @Date : 2020. 1. 30.
	 */
	public boolean updateParty(String p_code, String p_name);
}
