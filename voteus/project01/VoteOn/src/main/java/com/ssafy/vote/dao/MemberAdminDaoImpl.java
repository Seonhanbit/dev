package com.ssafy.vote.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dto.MemberAdminVO;

@Service
public class MemberAdminDaoImpl implements IMemberAdminDao {
	@Autowired
	SqlSession session;

	@Override
	public MemberAdminVO selectOne(String id) {
		return session.selectOne("memberadmin.selectOne", id);
	}

}
