package com.ssafy.vote.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssafy.vote.dao.IMemberAdminDao;
import com.ssafy.vote.dto.MemberAdminVO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	IMemberAdminDao memberAdminDaoImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberAdminVO memberAdminVO = memberAdminDaoImpl.selectOne(username);
		if (memberAdminVO != null) {
			return new User(memberAdminVO.getMa_id(), memberAdminVO.getMa_pw(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	
}
