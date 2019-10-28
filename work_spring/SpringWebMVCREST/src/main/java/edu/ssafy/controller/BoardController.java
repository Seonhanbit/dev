package edu.ssafy.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.service.BoardService;

@Controller
public class BoardController {
	
	@ExceptionHandler(Exception.class)
	public void exceptionMethod(Exception e) {
		
	}

	@Autowired
	BoardService ser;

	// void로 하면 value값을 쫓아감
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model m) {
		m.addAttribute("message", "메인 페이지입니다.");
		return "index";
	}

	@RequestMapping(value = "/boardinsertpage")
	public String boardinsertpage(Model m) {
		return "boardinsert";
	}

	@RequestMapping(value="/boardinsert")
	public String boardInsert(HttpServletRequest req, HttpServletRequest res, 
								HttpSession session, Locale local,
								ModelAndView mv, Model m, 
								//@RequestParam(name="num")String num,
								//@RequestParam(name="title")String title,
								//@RequestParam(name="content")String content
								BoardDto dto) throws Exception {
		
		//getParameter로 파라미터 불러오는 방법
		//String num = req.getParameter("num");
		//String title = req.getParameter("title");
		//String content = req.getParameter("content");
		
		//@RequestParam으로 부르는 방법
		//ser.insert(num, title, content);
		
		//파라미터로 바로 dto에 넣어줌
		ser.insert(dto.getNum(), dto.getTitle(), dto.getContent());
		return "redirect:boardlist";
	}
	
	@RequestMapping(value="/boardlist")
	public ModelAndView boardList(ModelAndView mv) throws Exception{
		List<BoardResult> selectList = ser.selectList();
		mv.addObject("list", selectList);
		mv.setViewName("boardlist");
		return mv;
	}
}
