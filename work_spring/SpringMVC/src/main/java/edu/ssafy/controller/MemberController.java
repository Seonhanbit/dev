package edu.ssafy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;

@Controller
@RequestMapping(value = "/member") // action 값에 member주면 이것 띄우기
public class MemberController {

	@RequestMapping("/memregpage")
	public ModelAndView insertPage(ModelAndView mv) {
		mv.setViewName("member/memreg");
		return mv;
	}

	@RequestMapping(value="/meminsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		// 로직처리 (서비스 부르기)
		ArrayList<Member> list = new ArrayList();
		// 결과처리
		list.add(new Member(id, null, name, email));

		mv.addObject("list", list);
		mv.setViewName("member/memlist");
		return mv;
	}
	
	//업데이트, 삭제 셀렉1, 셀렉리스트(아이디)
	
}
