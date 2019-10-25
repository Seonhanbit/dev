package edu.ssafy.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.ssafy.controller.HomeController;
import edu.ssafy.dto.Member;

@Repository("MemberRepositoryImplList")
public class MemberRepositoryImplList implements MemberRepository{
	private static final Logger logger = LoggerFactory.getLogger(MemberRepositoryImplList.class);
	
	ArrayList<Member> list = new ArrayList<Member>();
	
	@Override
	public void insert(Member m) {
		logger.info("MemberRepositoryImpl {}","insert");
		list.add(m);
	}

	@Override
	public void update(Member m) {
		logger.info("MemberRepositoryImpl {}","update");
		for(Member member : list) {
			if(member.getId().equals(m.getId())) {
				member.setPw(m.getPw());
				member.setName(m.getName());
				member.setAddr(m.getAddr());
				break;
			}
		}
	}

	@Override
	public void delete(String id) {
		logger.info("MemberRepositoryImpl {}","delete");
		for(Member m : list) {
			if(m.getId().equals(id)) {
				list.remove(m);
				break;
			}
		}
	}

	@Override
	public List<Member> list() {
		logger.info("MemberRepositoryImpl {}","list");
		return list;
	}

	@Override
	public Member get(String id) {
		logger.info("MemberRepositoryImpl {}","get");
		for(Member m : list) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}



}
