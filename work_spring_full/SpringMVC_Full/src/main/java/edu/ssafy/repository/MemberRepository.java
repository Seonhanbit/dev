package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.BoardMember;
import edu.ssafy.dto.Member;

public interface MemberRepository {
	
	public void insert(Member m);
	public void update(Member m);
	public void delete(String id);
	public List<Member> list();
	public Member get(String name);
	
}
