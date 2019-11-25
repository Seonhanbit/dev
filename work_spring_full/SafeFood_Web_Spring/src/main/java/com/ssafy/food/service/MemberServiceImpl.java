package com.ssafy.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.IMemberDao;
import com.ssafy.food.dto.MemVO;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao man;
	
	public MemberServiceImpl() {}
	@Override
	public boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		return man.addMem(id, pw, name, addr, email, tel, alinfo);
	}
	@Override
	public boolean isLogin(String id, String pw) {
		return man.isLogin(id, pw);
	}
	@Override
	public MemVO memInfo(String id) {
		return man.getMemInfo(id);
	}
	@Override
	public String searchpw(String id, String name) {
		return man.searchpw(id, name);
	}
	@Override
	public boolean delMem(String id) {
		return man.delMem(id);
	}
	@Override
	public boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		return man.updateMem(id, pw, name, addr, email, tel, alinfo);
	}
	
}
