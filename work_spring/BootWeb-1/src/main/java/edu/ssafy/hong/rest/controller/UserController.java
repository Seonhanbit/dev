package edu.ssafy.hong.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.hong.rest.dto.UserInfo;
import edu.ssafy.hong.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService ser;
	
	@RequestMapping(value="userList.do",method=RequestMethod.GET)
	public List<UserInfo> userList() {
		return ser.getUserInfos();
	}
	@RequestMapping(value="addUser.do",method=RequestMethod.POST)
	public String addUser(UserInfo user) {
		ser.addUserInfo(user);
		return "{\"result\":true}"; //수동으로 json만든 것!
	}
}
