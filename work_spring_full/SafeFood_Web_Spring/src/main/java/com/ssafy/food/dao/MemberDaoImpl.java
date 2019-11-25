package com.ssafy.food.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.MemVO;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		MemVO m = new MemVO(id, pw, name, addr, email, tel, alinfo);
		int n = session.insert("member.insertMem", m);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean isLogin(String id, String pw) {
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		int n = session.selectOne("member.isLogin", map);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		MemVO m = new MemVO(id, pw, name, addr, email, tel, alinfo);
		int n = session.update("member.updateMem", m);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delMem(String id) {
		int n = session.delete("member.deleteMem", id);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public MemVO getMemInfo(String id) {
		return session.selectOne("member.selectMem", id);
	}

	@Override
	public String searchpw(String id, String name) {
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		String res = session.selectOne("member.searchPw", map);
		return res;
	}

}
