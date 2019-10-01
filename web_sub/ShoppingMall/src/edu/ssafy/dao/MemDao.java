package edu.ssafy.dao;

import java.util.ArrayList;

import edu.ssafy.vo.Member;

public interface MemDao {
	boolean memReg(String id, String pw, String name, String addr);
	boolean memUpdate(String id, String pw, String name, String addr);
	boolean memDelete(String id);
	ArrayList<Member> memList();
	Member getMem(String id);
}
