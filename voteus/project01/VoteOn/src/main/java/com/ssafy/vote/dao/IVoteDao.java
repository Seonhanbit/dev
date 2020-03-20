package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.VoteVO;

public interface IVoteDao {

	public List<VoteVO> getVoteAllList();
	/**
	 * @author : 정준호
	 * @Date : 2020. 2. 10.
	 * @return 현재 기준으로 진행되고 있는 투표 리스트 반환(중분류 이름과 같이 반환 중분류 접근 *.middlepart)
	 */
	public List<VoteVO> getVoteActiveList();
	public boolean insertVote(String name, String middlepart, String start, String end);
	public boolean delVote(int code);
	public boolean updateVote(int code, String name, String middlepart, String start, String end);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자 코드를 입력 받은 뒤 해당 투표 리스트를 조회하는 기능
	 * @Date : 2020. 1. 29.
	 */
	public List<VoteVO> getVoteList(String votercode);
	public VoteVO getVoteOne(String code);
}
