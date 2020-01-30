package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.VoteVO;

public interface IVoteDao {

	public List<VoteVO> getVoteAllList();
	public boolean insertVote(String name, String middlepart, String start, String end);
	public boolean delVote(int code);
	public boolean updateVote(int code, String name, String middlepart, String start, String end);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자 코드를 입력 받은 뒤 해당 투표 리스트를 조회하는 기능
	 * @Date : 2020. 1. 29.
	 */
	public List<VoteVO> getVoteList(String votercode);

}
