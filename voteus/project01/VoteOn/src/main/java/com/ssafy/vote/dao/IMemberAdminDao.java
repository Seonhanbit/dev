package com.ssafy.vote.dao;

import com.ssafy.vote.dto.MemberAdminVO;

public interface IMemberAdminDao {
	public MemberAdminVO selectOne(String id);
}
