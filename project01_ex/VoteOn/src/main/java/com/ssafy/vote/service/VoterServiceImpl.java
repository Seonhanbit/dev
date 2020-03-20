package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.IVoterDao;
import com.ssafy.vote.dto.VoterVO;
@Transactional
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
	public boolean insertVoter(int code, String id_num, String name, String areaCode) {
		return man.insertVoter(code, id_num, name, areaCode);
	}

	@Override
	public boolean delVoter(int code) {
		return man.delVoter(code);
	}

	@Override
	public boolean updateVoter(int code, String name, String areaCode) {
		return man.updateVoter(code, name, areaCode);
	}

	@Override
	public VoterVO getVotercode(int code) {
		return man.getVotercode(code);
	}

	@Override
	public int getOnlyVotercode(String name, String id_num) {
		return man.getOnlyVotercode(name, id_num);
	}

}
