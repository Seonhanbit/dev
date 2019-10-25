package com.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.Phone;

@Repository("PhoneDAOImpl")
public class PhoneDAOImpl implements IPhoneDAO {
	@Autowired
	SqlSession session;
	
	@Override
	public void insert(Phone p) {
		System.out.println("insert");
		session.insert("sql.pms.insert", p);
	}

	@Override
	public List<Phone> selectList() {
		System.out.println("selectList");
		List<Phone> list = session.selectList("sql.pms.selectlist");
		return list;
	}

	@Override
	public Phone selectOne(String num) {
		System.out.println("selectOne");	
		Phone p = session.selectOne("sql.pms.selectone", num);
		return p;
	}

	@Override
	public void delete(String num) {
		System.out.println("delete");
		session.delete("sql.pms.delete", num);
	}

}
