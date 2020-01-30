package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IVoterDao;
import com.ssafy.vote.dto.VoterVO;

@Service(value="VoterServiceImpl")
public class VoterServiceImpl implements IVoterService {
	
	@Autowired
	IVoterDao man;
	
	public VoterServiceImpl() {}

	@Override
	public List<VoterVO> getVoterAllList() {
		return man.getVoterAllList();
	}

	@Override
	public boolean insertVoter(int code, String name, String areaCode) {
		return man.insertVoter(code, name, areaCode);
	}

	@Override
	public boolean delVoter(int code) {
		return man.delVoter(code);
	}

	@Override
	public boolean updateVoter(int code, String name, String areaCode) {
		return man.updateVoter(code, name, areaCode);
	}

}
