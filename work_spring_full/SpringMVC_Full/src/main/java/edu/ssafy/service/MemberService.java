package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.Member;

public interface MemberService {
	public void insert(String id, String pw, String name, String addr);
	public void update(String id, String pw, String name, String addr);
	public void delete(String id);
	public List<Member> list();
	public Member get(String id);
	public boolean userCheck(String id, String pw);
}
