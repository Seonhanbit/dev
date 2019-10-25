package edu.ssafy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.Member;
import edu.ssafy.repository.MemberRepository;
import edu.ssafy.repository.MemberRepositoryImplList;
import edu.ssafy.repository.MemberRepositoryMyBatis;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	@Qualifier(value="MemberRepositoryMyBatis")
	private MemberRepository repo;
	//MemberRepositoryImplDataSource
	//MemberRepositoryMyBatis
	
	@Override
	@Transactional()
	public void insert(String id, String pw, String name, String addr) {
		logger.info("MemberServiceImpl {}","insert");
		Member m =  new Member();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		m.setAddr(addr);
		repo.insert(m);
	//	repo.insert(m);
		
	}

	@Override
	@Transactional
	public void update(String id, String pw, String name, String addr) {
		logger.info("MemberServiceImpl {}","update");
		Member m = new Member();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		m.setAddr(addr);
		repo.update(m);
	}

	@Override
	@Transactional
	public void delete(String id) {
		logger.info("MemberServiceImpl {}","delete");
		repo.delete(id);
	}

	@Override
	public List<Member> list() {
		logger.info("MemberServiceImpl {}","list");
		return repo.list();
	}

	@Override
	public Member get(String id) {
		logger.info("MemberServiceImpl {}","get");
		return repo.get(id);
	}

	@Override
	public boolean userCheck(String id, String pw) {
		Member member = repo.get(id);
		
		if(member != null && member.getPw().equals(pw)) {
			return true;
		}
		return false;
	}
}
