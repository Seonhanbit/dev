package com.ssafy.vote.service;

import java.util.List;

import com.ssafy.vote.dto.VoteVO;

public interface IVoteService {
	/**
	 * @author : 선한빛
	 * 기능 : 모든 투표 데이터를 조회하는 메소드
	 * @Date : 2020. 1. 22.
	 */
	public List<VoteVO> getVoteAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 투표를 등록하는 함수
	 * @Date : 2020. 1. 22.
	 */
	public boolean insertVote(String name, String middlepart, String start, String end);
	/**
	 * @author : 선한빛
	 * 기능 : 투표를 삭제하는 함수
	 * @Date : 2020. 1. 23.
	 */
	public boolean delVote(int code);
	/**
	 * @author : 선한빛
	 * 기능 : 투표를 수정하는 함수
	 * @Date : 2020. 1. 23.
	 */
	public boolean updateVote(int code, String name, String middlepart, String start, String end);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자 코드를 입력 받은 뒤 해당 투표 리스트를 조회하는 기능
	 * @Date : 2020. 1. 29.
	 */
	public List<VoteVO> getVoteList(String votercode);



}
