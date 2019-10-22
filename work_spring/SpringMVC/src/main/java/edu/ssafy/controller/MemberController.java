package edu.ssafy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;
import edu.ssafy.exception.MyException;
import edu.ssafy.service.MemService;

@Controller
public class MemberController {
	
	@ExceptionHandler(MyException.class)
    public String myExceptionMethod(MyException e) {
        e.trace();
        return "myerror";
    }
    @ExceptionHandler(Exception.class)
    public String exceptionMethod(Exception e, Model m ) {
        e.printStackTrace();
        m.addAttribute("exception",e);
        return "myerror";
    }
	
	@Autowired
	@Qualifier("MemServiceImpl")
	private MemService ser;

	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}

	@RequestMapping(value="meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리 (서비스 부르기)
		ser.insert(id, pw, name, email);
		// 결과처리
		List<Member> list = ser.selectList();

		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	
	@RequestMapping(value="/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");

		// 로직처리 (서비스 부르기)
		ser.delete(id);
		// 결과처리
		List<Member> list = ser.selectList();
        mv.addObject("list", list);
        mv.setViewName("member/memlist");
        
		return mv;
	}
	
	@RequestMapping(value="/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리 (서비스 부르기)
		ser.update(id, pw, name, email);
		
		// 화면처리
		List<Member> list = ser.selectList();

		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	
	@RequestMapping(value="memselectone")
	public ModelAndView selectOne(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");

		// 로직처리 (서비스 부르기)
		Member selectOne = ser.selectOne(id);
		
		// 결과처리
		mv.addObject("mem", selectOne);
		mv.setViewName("member/memview");
		return mv;
	}
	
	@RequestMapping(value="/memselectlist")
	public ModelAndView selectList(HttpServletRequest req, ModelAndView mv) {
		// 로직처리 (서비스 부르기)
		List<Member> list = ser.selectList();
		// 결과처리

		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
}
