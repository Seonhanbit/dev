package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Member;

@Repository("MemMybatisRepoImpl")
public class MemMybatisRepoImpl implements MemRepo {
	
	@Autowired
	private SqlSession session;

	@Override
	public void insert(Member m) {
		//member_sql.xml 파일의 namespace.id 적어주기
		//autowired 마지막에 마이바티스 에러 찾기
		session.insert("sql.member.insertMember", m);
	}

	@Override
	public void update(Member m) {
		session.update("sql.member.updateMember", m);
	}

	@Override
	public void delete(String id) {
		session.delete("sql.member.deleteMember", id);
	}

	@Override
	public Member selectOne(String id) {
		Member m = session.selectOne("sql.member.selectMember", id);
		return m;
	}

	@Override
	public List<Member> selectList() {
		List<Member> selectList = session.selectList("sql.member.selectMembers");
		return selectList;
	}

}
