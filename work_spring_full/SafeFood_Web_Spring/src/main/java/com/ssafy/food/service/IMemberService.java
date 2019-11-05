package com.ssafy.food.service;

import com.ssafy.food.dto.MemVO;

public interface IMemberService {
	boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	boolean isLogin(String id, String pw);
	//void Logout(HttpSession session);
	MemVO memInfo(String id);
	String searchpw(String id, String name);
	boolean delMem(String id);
	boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	void pick(String id, String code);
}
