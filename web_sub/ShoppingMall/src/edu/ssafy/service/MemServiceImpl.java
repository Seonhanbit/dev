package edu.ssafy.service;

import java.util.ArrayList;

import edu.ssafy.dao.MemDao;
import edu.ssafy.dao.MemDaoImpl;
import edu.ssafy.vo.Member;

public class MemServiceImpl implements MemService {
	MemDao dao = new MemDaoImpl();
	
	@Override
	public boolean memReg(String id, String pw, String name, String addr) {
		boolean memReg = dao.memReg(id, pw, name, addr);
		
		return memReg;
	}

	@Override
	public boolean memUpdate(String id, String pw, String name, String addr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean memDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Member> memList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
