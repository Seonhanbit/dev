package com.ssafy.repository;

import java.util.List;

import com.ssafy.pms.Phone;

public interface IPhoneDAO {
	public void insert(Phone p);
	public List<Phone> selectList();
	public Phone selectOne(String id);
	public void delete(String id);
}
