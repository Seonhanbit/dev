package com.ssafy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vote.dao.IVotetfDao;
@Transactional
@Service(value="VotetfServiceImpl")
public class VotetfServiceImpl implements IVotetfService{
	
	@Autowired
	IVotetfDao man;
	
	@Override
	public boolean insertVotetf(int votercode, int votecode) {
		return man.insertVotetf(votercode, votecode);
	}

	@Override
	public boolean delVotetf(int votercode, int votecode) {
		return man.delVotetf(votercode, votecode);
	}

	@Override
	public List<Integer> getvotecode(int votercode) {
		return man.getvotecode(votercode);
	}

}
