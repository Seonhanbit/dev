package com.ssafy.service;

import java.util.List;

import com.ssafy.pms.Phone;

public interface IPhoneService {
	public void insert(Phone p);
	public List<Phone> selectList();
	public Phone selectOne(String id);
	public void delete(String id);
}
