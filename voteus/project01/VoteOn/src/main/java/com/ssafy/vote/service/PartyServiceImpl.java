package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.IPartyDao;
import com.ssafy.vote.dto.PartyVO;
@Transactional
@Service(value="PartyServiceImpl")
public class PartyServiceImpl implements IPartyService{
	
	@Autowired
	IPartyDao man;

	@Override
	public List<PartyVO> getPartyAllList() {
		return man.getPartyAllList();
	}

	@Override
	public boolean insertParty(String p_code, String p_name) {
		return man.insertParty(p_code, p_name);
	}

	@Override
	public boolean delParty(String p_code) {
		return man.delParty(p_code);
	}

	@Override
	public boolean updateParty(String p_code, String p_name) {
		return man.updateParty(p_code, p_name);
	}

}
