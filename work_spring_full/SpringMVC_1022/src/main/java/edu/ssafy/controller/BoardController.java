package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.exception.MyException;
import edu.ssafy.service.BoardService;
import edu.ssafy.util.BoardDto;

@Controller
public class BoardController {
	
	@ExceptionHandler(MyException.class)
	public String myException(MyException e) {
		return "errorpage";
	}
	
	@Autowired
	private BoardService ser;
	@RequestMapping(value= {"/","index"})
	public String index() {
		
		return "index";
	}
	@RequestMapping("boardregpage")
	public String insertPage() {
		return "board/boardreg";
	}
	@RequestMapping("boardviewpage")
	public String viewPage(@RequestParam("no") String no, Model m) {
		BoardDto board = ser.selectOne(no);
		m.addAttribute("board", board);
		return "board/boardview";
	}
	
	@RequestMapping("boardreg")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		try {
			ser.insert(no, title, content);
			mv.setViewName("redirect:boardlist");
		}catch(RuntimeException e ) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("error");
		}
		return mv;
	}
	@RequestMapping("boardlist")
	public ModelAndView selectList(ModelAndView mv) {
		try {
			List<BoardDto> list = ser.selectList();
			mv.setViewName("board/boardlist");
			mv.addObject("list",list);
		}catch(RuntimeException e ) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("error");
		}
		return mv;
	}
	@RequestMapping("boardupdate")
	public ModelAndView boardUpdate(
			@RequestParam("no") String no,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			ModelAndView mv)
	{
		try {
			int update = ser.update(no, title, content);
			mv.setViewName("redirect:boardlist");
		}catch(RuntimeException e) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("error");
		}
		return mv;
	}
	@RequestMapping("boarddelete")
	public ModelAndView boardDelete(
			@RequestParam("no") String no,
			ModelAndView mv){
		try {
			int delete = ser.delete(no);
			mv.setViewName("redirect:boardlist");
		}catch(RuntimeException e) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("error");
		}
		return mv;
	}
	@RequestMapping("boardselectone")
	public ModelAndView boardSelectOne(
			@RequestParam("no") String no,
			ModelAndView mv){
		try {
			BoardDto dto = ser.selectOne(no);
			mv.addObject("board", dto);
			mv.setViewName("board/boardview");
		}catch(RuntimeException e) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("error");
		}
		return mv;
	}
}
