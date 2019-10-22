package edu.ssafy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.dto.Member;
import edu.ssafy.repository.MemRepo;

@Service(value = "MemServiceImpl")
public class MemServiceImpl implements MemService {
	@Autowired
	@Qualifier("MemMybatisRepoImpl")
	private MemRepo repo;
	// 객체 생성할 필요 없음, spring이 만들어줌
	// 상속받은 애가 많으면 Qualifier("이름")

	public MemServiceImpl() {
	}

	//트랜잭션 할 곳에 어노테이션 걸어주기@Transactional
	//조회할때는 롤백 안해도 되니깐 안걸어줘
	@Override
	@Transactional()
	public void insert(String id, String pw, String name, String email) {
		repo.insert(new Member(id, pw, name, email));
		//repo.insert(new Member("a200", pw, name, email));
		//repo.insert(new Member("a100", pw, name, email));
		//member는 new해줬기때문에 서블릿컨테이너가 가지고 있지 않음
	}

	@Override
	@Transactional()
	public void update(String id, String pw, String name, String email) {
		repo.update(new Member(id, pw, name, email));
	}

	@Override
	@Transactional()
	public void delete(String id) {
		repo.delete(id);
	}

	@Override
	public Member selectOne(String id) {
		return repo.selectOne(id);
	}

	@Override
	public List<Member> selectList() {
		return repo.selectList();
	}

}
