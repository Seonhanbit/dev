package edu.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;
import edu.ssafy.service.MemberService;
import edu.ssafy.exception.MyException;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	@ExceptionHandler(MyException.class)
	public String exceptionMethod(Exception e) {
		System.out.println("MyException.....................");
		return "error";
	}
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService ser;
	
	@RequestMapping("")
	public ModelAndView home(ModelAndView m) {
		m.addObject("msg", "member 화이팅");
		m.setViewName("result");
		return m;
	}
	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView m ) {
		logger.info("MemberController", "insert");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");;
		String name = req.getParameter("name");;
		String addr = req.getParameter("addr");;
		
		ser.insert(id, pw, name, addr);
		m.addObject("msg", "쉬었다가 해요");
		m.setViewName("result");
		return m;
	}
	
	@RequestMapping("/loginpage")
	public ModelAndView loginpage(ModelAndView m) {
		m.setViewName("login");
		return m;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView m, HttpServletRequest req, HttpSession session) throws Exception {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(ser.userCheck(id, pw)) {
			m.addObject("msg","로그인 되었습니다");
			session.setAttribute("isLogin", id);
			m.setViewName("redirect:/member/list");
		}else {
			m.addObject("msg","등록되지 안은 회원입니다");
			m.setViewName("result");
			//throw new MyException();
		}
		return m;
	}
	
	@RequestMapping("/registpage")
	public ModelAndView registpage(ModelAndView m) {
		m.setViewName("regist");
		
		return m;
	}
	
	@RequestMapping("/regist")
	public ModelAndView regist(
			@RequestParam(value="id",required=true,defaultValue="id")String id,
			@RequestParam(value="pw")String pw,
			@RequestParam(value="name")String name,
			@RequestParam(value="addr")String addr,
			ModelAndView m) {
		
		ser.insert(id, pw, name, addr);
		m.addObject("msg","회원으로 등록되었습니다");
		m.setViewName("result");
		return m;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView m, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		m.addObject("msg","로그 아웃 되었습니다");
		m.setViewName("result");
		return m;
	}
	
	
	@RequestMapping("/update")
	public ModelAndView update(Member mem, ModelAndView m, HttpServletRequest req) {

		if(ser.userCheck(mem.getId(), mem.getPw())) {
			ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getAddr());
			m.addObject("msg","회원정보가 수정되었습니다.");
		}else {
			m.addObject("msg","회원정보 수정이 실패 하였습니다.");
		}
		m.setViewName("result");
		return m;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(ModelAndView m, HttpServletRequest req) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println(id+","+pw);
		if(ser.userCheck(id, pw)) {
			ser.delete(id);
			m.addObject("msg","회원이 삭제되었습니다.");
			
			HttpSession session = req.getSession();
			String isLogin =(String) session.getAttribute("isLogin");
			if(isLogin != null && isLogin.equals(id)) {
				session.invalidate();
			}
		}else {
			m.addObject("msg","회원정보 삭제가 실패하였습니다");
		}
		m.setViewName("result");
		return m;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView m, HttpServletRequest req) {
		req.setAttribute("list", ser.list());
		m.setViewName("memberList");
		return m;
	}
	
	@RequestMapping("/info")
	public ModelAndView info(ModelAndView m, HttpServletRequest req) {
		
		req.setAttribute("member",  ser.get((String) req.getParameter("id")));
		m.setViewName("memberInfo");
		return m;
	}
}
