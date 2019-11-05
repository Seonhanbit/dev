package com.ssafy.food.dao;

import com.ssafy.food.dto.MemVO;

public interface IMemberDao {
	boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	boolean isLogin(String id, String pw);
	boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	boolean delMem(String id);
	MemVO getMemInfo(String id);
	String searchpw(String id, String name);
	void pick(String id, String code);
}
