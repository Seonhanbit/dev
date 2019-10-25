package edu.ssafy.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.service.BoardService;
import edu.ssafy.exception.MyException;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	@Qualifier("BoardServiceImpl")
	private BoardService ser;
	
	@ExceptionHandler(MyException.class)
	public String myExceptionMethod(MyException e) {
		e.trace();
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionMethod(Exception e) {
		e.printStackTrace();
		return "error";
	}
	
	
	@RequestMapping("")
	public String home(Model m) {
		return "redirect:/board/list";
	}
	
	@RequestMapping("/result")
	public String result(Model m) {
		return "board/result";
	}
	
	@RequestMapping("/createPage")
	public String createPage(Model m) {
		return "board/boardCreate";
	}
	
	@RequestMapping("/create")
	public ModelAndView create(ModelAndView m, HttpServletRequest req) {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String context = req.getParameter("context");
		ser.insert(title, writer, context);
		m.setViewName("redirect:/board/list");
		return m;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView m, HttpServletRequest req) {
		logger.info("BoardController {}","update");
		String seq = req.getParameter("seq");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String context = req.getParameter("context");
		System.out.println(seq);
		ser.update(title, writer, context, seq);
		m.setViewName("redirect:/board/list");
		return m;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(ModelAndView m, HttpServletRequest req) {
		logger.info("BoardController {}","delete");
		String seq = req.getParameter("seq");
		ser.delete(seq);
		m.addObject("msg","글이 삭제되었습니다.");
		m.setViewName("redirect:/board/list");
		return m;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView m, HttpServletRequest req) {
		req.setAttribute("list", ser.list());
		m.setViewName("board/boardList");
		return m;
	}
	
	@RequestMapping("/info")
	public ModelAndView info(ModelAndView m, HttpServletRequest req) {
		String seq = req.getParameter("seq");
		req.setAttribute("board", ser.get(seq));
		System.out.println(ser.get(seq).toString());
		m.setViewName("board/boardInfo");
		return m;
	}
}
