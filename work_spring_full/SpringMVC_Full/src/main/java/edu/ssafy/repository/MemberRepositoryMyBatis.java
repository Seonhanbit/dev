package edu.ssafy.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Qualifier;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BoardMember;
import edu.ssafy.dto.Member;

@Repository("MemberRepositoryMyBatis")
public class MemberRepositoryMyBatis implements MemberRepository {
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		System.out.println(m.toString());
		session.insert("mem.insert",m);	
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		
		session.update("mem.update",m);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		session.delete("mem.delete",id);
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		
		return session.selectList("mem.selectList");
		
	}

	@Override
	public Member get(String name) {
		return session.selectOne("mem.selectOne",name);
		
	}
	
	public List<BoardMember> joinTest() {
		// TODO Auto-generated method stub
		return session.selectList("mem.selectjoin"); 
	}
	

}
