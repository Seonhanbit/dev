package edu.ssafy.hong.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.hong.rest.dao.UserDao;
import edu.ssafy.hong.rest.dto.UserInfo;

@Service
public class UserService {
@Autowired
private UserDao dao;

public List<UserInfo> getUserInfos(){
	return dao.selectAll();
}
public void addUserInfo(UserInfo user) {
	dao.insert(user);
}
}
