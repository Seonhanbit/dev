package com.ssafy.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.food.dto.MemVO;
import com.ssafy.food.service.IMemberService;

@Controller
public class MemberController {

	@Autowired
	private IMemberService ser;

	@RequestMapping("/Login")
	public ModelAndView Login(HttpServletRequest req, ModelAndView mv, HttpSession se) {
		String id = req.getParameter("mid");
		String pw = req.getParameter("mpw");
		boolean isLogin = ser.isLogin(id, pw);
		if (isLogin) {
			// 세션에 로그인 저장
			se.setAttribute("islogin", "isLogin");
			se.setAttribute("id", id);
			/*
			 * req.getSession().setAttribute("islogin", "isLogin");
			 * req.getSession().setAttribute("id", id);
			 */
		}
		mv.setViewName("redirect:main");
		return mv;
	}

	@RequestMapping("/Delete")
	public ModelAndView Delete(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("pid");
		System.out.println(id);
		boolean del = ser.delMem(id);
		if (del) {
			String msg = "success";
			mv.addObject("msg", msg);
			req.getSession().invalidate();
		} else {
			String msg = "fail";
			mv.addObject("msg", msg);
		}
		mv.setViewName("mypage");
		return mv;
	}

	@RequestMapping("/Update")
	public ModelAndView Update(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("pid");
		String pw = req.getParameter("ppw");
		String name = req.getParameter("pname");
		String addr = req.getParameter("paddr");
		String email = req.getParameter("pemail");
		String tel = req.getParameter("ptel");
		String alinfo = req.getParameter("palinfo");
		boolean update = ser.updateMem(id, pw, name, addr, email, tel, alinfo);
		if (update) {
			mv.setViewName("redirect:memInfo");
		} else {
			mv.addObject("result", id + "의 수정이 실패하였습니다");
			mv.setViewName("mypage");
		}
		return mv;
	}

	@RequestMapping("/Logout")
	public ModelAndView Logout(HttpServletRequest req, ModelAndView mv, HttpSession ss) {
		ss.invalidate();
		mv.setViewName("redirect:main");
		return mv;
	}

	@RequestMapping("/memInfo")
	public ModelAndView memInfo(HttpServletRequest req, ModelAndView mv) {
		String id = (String) req.getSession().getAttribute("id");
		MemVO mem = ser.memInfo(id);
		mv.addObject("info", mem);
		mv.setViewName("mypage");
		return mv;
	}

	@RequestMapping("/searchpw")
	public ModelAndView searchpw(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("pid");
		String name = req.getParameter("pname");
		String pw = ser.searchpw(id, name);
		System.out.println(pw);
		if (pw != "")
			mv.addObject("pw", pw);
		else
			mv.addObject("fail", "fail");
		mv.setViewName("findpw");
		return mv;
	}

	@RequestMapping("/SignUp")
	public ModelAndView SignUp(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("pid");
		String pw1 = req.getParameter("ppw1");
		String pw2 = req.getParameter("ppw2");
		String name = req.getParameter("pname");
		String addr = req.getParameter("paddr");
		String email1 = req.getParameter("pemail1");
		String email2 = req.getParameter("pemail2");
		System.out.println(id);
		String email = email1 + "@" + email2;

		String tel1 = req.getParameter("ptel1");
		String tel2 = req.getParameter("ptel2");
		String tel3 = req.getParameter("ptel3");

		String tel = tel1 + "-" + tel2 + "-" + tel3;

		String[] alinfo = req.getParameterValues("hobby");
		String all = "";
		for (int i = 0; i < alinfo.length - 1; i++) {
			all += alinfo[i] + ", ";
		}
		all += alinfo[alinfo.length - 1];

		boolean res = ser.addMem(id, pw1, name, addr, email, tel, all);
		if (res) {
			String msg = "success";
			mv.addObject("msg", msg);
			mv.setViewName("main");
		} else {
			String msg = "fail";
			mv.addObject("msg", msg);
			mv.setViewName("main");
		}
		return mv;
	}
	@RequestMapping("/findpw")
	public String findPw() {
		return "findpw";
	}
	
	@RequestMapping("/announce")
	public String announce() {
		return "announce";
	}
	
	@RequestMapping("/pick")
	public ModelAndView pick(HttpServletRequest req, ModelAndView mv) {
		String id = (String) req.getSession().getAttribute("id");
		String code = req.getParameter("code");
		mv.addObject("code", code);
		mv.setViewName("redirect:pdetail");
		return mv;
	}
}
