package edu.ssafy.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.exception.MyException;
import edu.ssafy.service.BoardService;
import edu.ssafy.util.BoardDto;

@Controller
@RequestMapping("api")
public class RestBoardController {

	@Autowired
	private BoardService ser;

	@RequestMapping("boardviewpage")
	public @ResponseBody BoardDto viewPage(@RequestBody BoardDto dto) {
		BoardDto board = ser.selectOne(dto.getNo());
		return board;
	}

	@RequestMapping("boardreg")
	public @ResponseBody ResponseEntity<HashMap<String, Object>> insert(@RequestBody BoardDto dto) {
		// 응답하는 개체를 만들고 객체를 항상 던지기
		HashMap<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res;
		try {
			ser.insert(dto.getNo(), dto.getTitle(), dto.getContent());
			map.put("resmsg", "입력성공");
			map.put("resdata", dto);
			res = new ResponseEntity<HashMap<String,Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg", "입력실패");
			map.put("resdata", dto);
			res = new ResponseEntity<HashMap<String,Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping("boardlist")
	public @ResponseBody ResponseEntity<HashMap<String, Object>> selectList() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res;
		try {
			List<BoardDto> list = ser.selectList();
			map.put("resmsg", "리스트 조회 성공");
			map.put("resdata", list);
			res = new ResponseEntity<HashMap<String,Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg", "리스트 조회 실패");
			res = new ResponseEntity<HashMap<String,Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping("boardupdate")
	public ResponseEntity<HashMap<String, Object>> boardUpdate(@RequestBody BoardDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> res;
		
		try {
			int update = ser.update(dto.getNo(), dto.getTitle(), dto.getContent());
			map.put("resmsg", "업데이트 성공");
			res = new ResponseEntity<HashMap<String,Object>>(map,HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("resmsg", "업데이트 실패");
			res = new ResponseEntity<HashMap<String,Object>>(map,HttpStatus.OK);
		}
		return res;
	}

	@RequestMapping("boarddelete")
	public void boardDelete(@RequestBody BoardDto dto) {
		try {
			int delete = ser.delete(dto.getNo());
		} catch (RuntimeException e) {

		}
	}

	@RequestMapping("boardselectone")
	public @ResponseBody BoardDto boardSelectOne(@RequestBody BoardDto dto) {
		try {
			BoardDto res = ser.selectOne(dto.getNo());
			return res;
		} catch (RuntimeException e) {
		}
		return null;
	}
}
