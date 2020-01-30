package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IVotetfDao;

@Service(value="VotetfServiceImpl")
public class VotetfServiceImpl implements IVotetfService{
	
	@Autowired
	IVotetfDao man;
	
	@Override
	public boolean insertVotetf(String votercode, int votecode) {
		return man.insertVotetf(votercode, votecode);
	}

	@Override
	public boolean delVotetf(String votercode, int votecode) {
		return man.delVotetf(votercode, votecode);
	}

	@Override
	public List<Integer> getvotecode(String votercode) {
		return man.getvotecode(votercode);
	}

}
