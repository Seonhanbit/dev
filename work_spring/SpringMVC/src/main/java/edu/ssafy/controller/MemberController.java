package edu.ssafy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	//초기 화면 설정
	/*
	 * @RequestMapping(value= {"/","index"}) 
	 * public String index(){ 
	 * 		return "index";
	 * }
	 */

	
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

	//값을 넘겨줄때는 ModelAndView로, 필요없으면 String 가능
	/*
	 * @RequestMapping("/memregpage") 
	 * public String insertPage() { 
	 * 	return "redirect:member/memreg"; 
	 * }
	 */
	
	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}

	@RequestMapping(value="meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv, HttpSession ss) {
		//HttpSession ss session으로 받아오기
		
		// 입력처리
		String id = req.getParameter("id");
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
		
		//redirect하고 싶으면 : 액션값주기(대부분이것), update, delete, insert 할때
		//forward:memselectlist
		//뒤에 jsp 넣어주려면 webapp밑에 jsp파일 넣기(full name 넣기)
		mv.setViewName("redirect:memselectlist");
		//mv.setViewName("redirect:member/memlist");
		return mv;
	}
	
	@RequestMapping(value="/memdelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");

		// 로직처리 (서비스 부르기)
		ser.delete(id);
		// 결과처리
        
        mv.setViewName("redirect:memselectlist");
        
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
		
		mv.setViewName("redirect:memselectlist");
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
