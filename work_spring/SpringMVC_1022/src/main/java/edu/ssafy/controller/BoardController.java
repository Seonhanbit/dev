package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.service.BoardService;
import edu.ssafy.util.BoardDto;

@Controller
public class BoardController {
	
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
	
	@RequestMapping("boardregpage")
	public String viewPage(@RequestParam("no") String no, Model m) {
		BoardDto board = ser.selectOne(no);
		m.addAttribute("board", board);
		return "board/boardview";
	}
	
	@RequestMapping("boardlist")
	public ModelAndView selectList(ModelAndView mv) {
		List<BoardDto> list = ser.selectList();
		mv.setViewName("redirect:boardlist");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("boardupdate")
	public ModelAndView boardUpdate(@RequestParam("no") String no,
			@RequestParam("title") String title, @RequestParam("content") String content,
			ModelAndView mv) {
		int update = ser.update(no, title, content);
		mv.setViewName("redirect:boardlist");
		return mv;
	}
	
	@RequestMapping("boarddelete")
	public ModelAndView boarddelete(@RequestParam("no") String no,
			ModelAndView mv) {
		int delete = ser.delete(no);
		mv.setViewName("redirect:boardlist");
		return mv;
	}
	
	@RequestMapping("boardreg")
	public String insert(HttpServletRequest req) {
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		String r = new String();
		try {
			ser.insert(no, title, content);
			r = "redirect:boardlist";
		}catch(RuntimeException e) {
			r= "error";
		}
		return r;
	}
}
