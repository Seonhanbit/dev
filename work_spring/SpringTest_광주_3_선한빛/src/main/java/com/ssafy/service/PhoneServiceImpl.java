package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.pms.Phone;
import com.ssafy.repository.IPhoneDAO;

@Service("PhoneServiceImpl")
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	@Qualifier("PhoneDAOImpl")
	IPhoneDAO repo;
	
	@Override
	public void insert(Phone p) {
		repo.insert(p);
	}

	@Override
	public List<Phone> selectList() {
		return repo.selectList();
	}

	@Override
	public Phone selectOne(String num) {
		return repo.selectOne(num);
	}

	@Override
	public void delete(String num) {
		repo.delete(num);
	}

}
