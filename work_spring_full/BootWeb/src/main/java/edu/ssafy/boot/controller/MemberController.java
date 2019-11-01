package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;

@Controller
public class MemberController {

	// 주소에서 치고온 거니까 get 방식
	// @RequestMapping(value= {"/","index"},method=RequestMethod.GET)
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@Autowired
	@Qualifier("MemServiceImpl")
	private MemService ser;

	// 값을 넘겨줄때는 ModelAndView로, 필요없으면 String 가능
	/*
	 * @RequestMapping("/memregpage") public String insertPage() { return
	 * "redirect:member/memreg"; }
	 */

	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}

	@RequestMapping(value = "meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv, HttpSession ss, String id) {
		// HttpSession ss session으로 받아오기

		// 입력처리
		// String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리 (서비스 부르기)
		ser.insert(id, pw, name, email);
		// 결과처리
//		List<Member> list = ser.selectList();
//		mv.addObject("list", list);
//		디폴트가 포워드, 그러니까 req에 값이 담겨있어서 새로고침 시 에러뜸
//		mv.setViewName("member/memlist");

		// redirect하고 싶으면 : 액션값주기(대부분이것), update, delete, insert 할때
		// forward:memselectlist
		// 뒤에 jsp 넣어주려면 webapp밑에 jsp파일 넣기(full name 넣기)
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");
		ser.delete(id);
		mv.setViewName("redirect:memselectlist");

		return mv;
	}

	@RequestMapping(value = "/memupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String email = req.getParameter("email");

			ser.update(id, pw, name, email);
			mv.setViewName("redirect:memselectlist");
		} catch (Exception e) {
			mv.setViewName("error");
		}
		return mv;
	}

	@RequestMapping(value = "memselectone")
	public ModelAndView selectOne(HttpServletRequest req, ModelAndView mv) {
		String id = req.getParameter("id");

		Member selectOne = ser.selectOne(id);

		mv.addObject("mem", selectOne);
		mv.setViewName("member/memview");
		return mv;
	}

	@RequestMapping(value = "/memselectlist")
	public ModelAndView selectList(HttpServletRequest req, ModelAndView mv) {
		List<Member> list = ser.selectList();

		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest req, ModelAndView mv, HttpSession ss) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Member m = ser.selectOne(id);
		if(id.equals(m.getId())&&pw.equals(m.getPw())) {
			ss.setAttribute("memid", id);
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest req, ModelAndView mv, HttpSession ss) {
		if(ss!=null) {
			ss.invalidate();
		}
		mv.setViewName("index");
		return mv;
	}

	
}
