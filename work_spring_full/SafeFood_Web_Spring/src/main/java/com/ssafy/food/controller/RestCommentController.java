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

import com.ssafy.food.dto.CommentVO;
import com.ssafy.food.service.ICommentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestCommentController {
	@Autowired
	private ICommentService ser;
	
	@ApiOperation(value="comment을 qnanum로 조회합니다.")
	@GetMapping("/commentList/{qnanum}")
	public ResponseEntity<List<CommentVO>> commentList(@PathVariable String qnanum){
		//System.out.println(qnanum);
		ResponseEntity<List<CommentVO>> re = null;
		try {
			List<CommentVO> list = ser.getCommentList(qnanum);
			re = new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
		}catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="comment를 삭제합니다.")
	@DeleteMapping(value = "/deleteComment/{num}")
	public ResponseEntity<String> deleteComment(@PathVariable String num) {
		//System.out.println(num);
		ResponseEntity<String> re = null;
		try {
			int num1 = Integer.parseInt(num);
			ser.delComment(num1);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="comment를 등록합니다.")
	@PostMapping(value = "/insertComment")
	public ResponseEntity<String> insertQna(@RequestBody CommentVO comment) {
		System.out.println(comment.getContent());
		ResponseEntity<String> re = null;
		try {
			ser.addComment(comment.getQnanum(), comment.getContent(), comment.getId());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			//HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="comment를 수정합니다.")
	@PostMapping(value = "/updateComment")
	public ResponseEntity<String> updateQna(@RequestBody CommentVO comment) {
		//System.out.println(qna.getTitle());
		ResponseEntity<String> re = null;
		try {
			ser.updateComment(comment.getNum(), comment.getContent(), comment.getId());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}
}
