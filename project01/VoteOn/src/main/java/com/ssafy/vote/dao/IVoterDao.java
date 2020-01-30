package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.VoterVO;

public interface IVoterDao {
	
	public List<VoterVO> getVoterAllList();
	public boolean insertVoter(int code, String name, String areaCode);
	public boolean delVoter(int code);
	public boolean updateVoter(int code, String name, String areaCode);
}
