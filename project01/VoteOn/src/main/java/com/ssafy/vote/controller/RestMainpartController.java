package com.ssafy.vote.controller;

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

import com.ssafy.vote.dto.MainpartVO;
import com.ssafy.vote.service.IMainpartService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/mainpart")
public class RestMainpartController {

	@Autowired
	IMainpartService ser;

	@ApiOperation(value="모든 대분류를 조회합니다.")
	@GetMapping("/getMainpartAllList")
	public ResponseEntity<List<MainpartVO>> getMainpartAllList(){
		ResponseEntity<List<MainpartVO>> re = null;
		try {
			List<MainpartVO> list = ser.getMainpartAllList();
			re = new ResponseEntity<List<MainpartVO>>(list, HttpStatus.OK);
		}catch(Exception e){
			re = new ResponseEntity("모든  대분류 데이터 조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "대분류를 등록합니다.")
	@PostMapping("/insertMainpart")
	public ResponseEntity<String> insertMainpart(@RequestBody MainpartVO main) {
		ResponseEntity<String> re = null;
		try {
			ser.insertMainpart(main.getCode(), main.getName());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "대분류를 삭제합니다.")
	@DeleteMapping(value = "/delMainpart/{code}")
	public ResponseEntity<String> delMainpart(@PathVariable String code) {
		ResponseEntity<String> re = null;
		try {
			ser.delMainpart(code);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "대분류를 수정합니다.")
	@PutMapping(value = "/updateMainpart")
	public ResponseEntity<String> updateMainpart(@RequestBody MainpartVO main) {
		ResponseEntity<String> re = null;
		try {
			ser.updateMainpart(main.getCode(), main.getName());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}

}
