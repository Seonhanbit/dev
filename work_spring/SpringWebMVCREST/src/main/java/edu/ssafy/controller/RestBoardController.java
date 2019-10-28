package edu.ssafy.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.service.BoardService;
import io.swagger.annotations.ApiOperation;

//@RestController 이용할떄는 @RequestBody, @ResponseBody 안 써도 됨
//@Controller 이용할 때는 다 써주기 -> 다른 기능 이용 가능
@RestController
@RequestMapping("/api")
public class RestBoardController {
	
	@Autowired
	BoardService ser;
	
	@Autowired
	BoardDto dd;

	//똑같은 URI인데, 메소드 방식이 다름
	//json으로 날라온 애를 받아서 void로 함(넘겨줄 값 없음) ->jacksonbind가 해줌
	@ApiOperation(value="게시판에 보드를 입력합니다.")
	@RequestMapping(value="/restboard", method=RequestMethod.POST)
	public void boardInsert(@RequestBody BoardDto dto) throws Exception {
		ser.insert(dto.getNum(), dto.getTitle(), dto.getContent());
	}
	
	//jacksonbind가 자동으로 json으로 바꿔줌
	@ApiOperation(value="게시판을 모두 조회합니다.", response=List.class)
	@RequestMapping(value="/restboard", method=RequestMethod.GET)
	public @ResponseBody List<BoardResult> boardList() throws Exception{
		List<BoardResult> selectList = ser.selectList();
		return selectList;
	}
	
	@ApiOperation(value="게시판을 하나만 조회합니다.")
	@RequestMapping(value="/restboard/{num}", method=RequestMethod.GET)
	public @ResponseBody BoardDto boardOne(@PathVariable String num) throws Exception{
		System.out.println("num : "+num);
		BoardDto boarddto = ser.selectOne(num);
		return boarddto;
	}
	
	@ApiOperation(value="게시판을 수정합니다.")
	@RequestMapping(value="/restboard", method=RequestMethod.PUT)
	public void boardUpdate(@RequestBody BoardDto dto) throws Exception{
		ser.update(dto.getNum(), dto.getTitle(), dto.getContent());
		System.out.println("수정이다");
	}
	
	@ApiOperation(value="게시판을  삭제합니다.")
	@RequestMapping(value="/restboard/{num}", method=RequestMethod.DELETE)
	public void boardDelete(@PathVariable String num) throws Exception{
		ser.delete(num);
		System.out.println("num : "+num);
		
		System.out.println(dd.toString());
	}
	
	//메소드 방식이 delete일때, restboard/{num} 이런식으로 인자값 줄 수 있음
	///restboard/{num}/{title}/{content} 여러개 인자값을 주고 받을 수 있음
	//@ApiOperation(value="게시판을  삭제합니다.")
	//@RequestMapping(value="/restboard/{num}/{title}/{content}", method=RequestMethod.DELETE)
	//public void boardDelete(@PathVariable String num
	//						,@PathVariable String title
	//						,@PathVariable String content) throws Exception{
		//ser.delete(num);
	//	System.out.println("num : "+num);
	//	System.out.println("title : "+title);
		
	//	System.out.println(dd.toString());
	//}
}
