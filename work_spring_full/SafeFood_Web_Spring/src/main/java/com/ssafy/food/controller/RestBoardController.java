package com.ssafy.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.food.dto.BoardVO;
import com.ssafy.food.service.IBoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestBoardController {
	
	@Autowired
	private IBoardService ser;
	
	@ApiOperation(value="Board를 num로 조회합니다.")
	@GetMapping("/boarddetail/{num}")
	public ResponseEntity<BoardVO> boarddetail(@PathVariable String num) {
		ResponseEntity<BoardVO> re = null;
		try {
			int num1 = Integer.parseInt(num);
			BoardVO qna = new BoardVO();
			qna = ser.getBoard(num1);
			re = new ResponseEntity<BoardVO>(qna, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="Board 전체를 조회합니다.")
	@GetMapping(value = "/boardList")
	public ResponseEntity<List<BoardVO>> boardList() {
		ResponseEntity<List<BoardVO>> re = null;
		try {
			List<BoardVO> list = ser.getBoardList();
			re = new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="Board를 등록합니다.")
	@PostMapping(value = "/insertBoard")
	public ResponseEntity<String> insertBoard(@RequestBody BoardVO board) {
		//System.out.println(qna.getTitle());
		ResponseEntity<String> re = null;
		try {
			ser.addBoard(board.getId(), board.getTitle(), board.getContent());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			//HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="Board를 삭제합니다.")
	@DeleteMapping(value = "/deleteBoard/{num}")
	public ResponseEntity<String> deleteBoard(@PathVariable String num) {
		//System.out.println(num);
		ResponseEntity<String> re = null;
		try {
			int num1 = Integer.parseInt(num);
			ser.delBoard(num1);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="Board를 수정합니다.")
	@PostMapping(value = "/updateBoard")
	public ResponseEntity<String> updateBoard(@RequestBody BoardVO board) {
		//System.out.println(qna.getTitle());
		ResponseEntity<String> re = null;
		try {
			ser.updateBoard(board.getNum(), board.getTitle(), board.getContent());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}
	
}
