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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.food.dto.QnaVO;
import com.ssafy.food.service.IQnaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestQnaController {
	@Autowired
	private IQnaService ser;
	
	@ApiOperation(value="QnA을 num로 조회합니다.")
	@GetMapping("/qnadetail/{num}")
	public ResponseEntity<QnaVO> qnadetail(@PathVariable String num) {
		ResponseEntity<QnaVO> re = null;
		try {
			int num1 = Integer.parseInt(num);
			QnaVO qna = new QnaVO();
			qna = ser.getQna(num1);
			re = new ResponseEntity<QnaVO>(qna, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="QnA 전체를 조회합니다.")
	@GetMapping(value = "/qnaList")
	public ResponseEntity<List<QnaVO>> qnaList() {
		System.out.println("--------------");
		ResponseEntity<List<QnaVO>> re = null;
		try {
			List<QnaVO> list = ser.getQnaList();
			re = new ResponseEntity<List<QnaVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="qna를 등록합니다.")
	@PostMapping(value = "/insertQna")
	public ResponseEntity<String> insertQna(@RequestBody QnaVO qna) {
		//System.out.println(qna.getTitle());
		ResponseEntity<String> re = null;
		try {
			ser.addQna(qna.getTitle(), qna.getContent(), qna.getId());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			//HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="qna를 삭제합니다.")
	@DeleteMapping(value = "/deleteQna/{num}")
	public ResponseEntity<String> deleteQna(@PathVariable String num) {
		//System.out.println(num);
		ResponseEntity<String> re = null;
		try {
			int num1 = Integer.parseInt(num);
			ser.delQna(num1);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="qna를 수정합니다.")
	@PostMapping(value = "/updateQna")
	public ResponseEntity<String> updateQna(@RequestBody QnaVO qna) {
		//System.out.println(qna.getTitle());
		ResponseEntity<String> re = null;
		try {
			ser.updateQna(qna.getNum(), qna.getTitle(), qna.getContent(), qna.getId());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}
	
}
