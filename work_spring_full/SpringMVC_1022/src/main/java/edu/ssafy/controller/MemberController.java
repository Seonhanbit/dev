package edu.ssafy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("id") String id
							,@RequestParam("pw") String pw
							,ModelAndView mv) {
		
		
		return mv;
	}
}
