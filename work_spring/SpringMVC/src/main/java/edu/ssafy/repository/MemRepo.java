package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.Member;

public interface MemRepo {
	public void insert(Member m);
	public void update(Member m);
	public void delete(String id);
	public Member selectOne(String id);
	public List<Member> selectList();	
}
