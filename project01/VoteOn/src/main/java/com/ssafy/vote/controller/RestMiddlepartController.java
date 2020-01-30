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

import com.ssafy.vote.dto.MiddlepartVO;
import com.ssafy.vote.service.IMiddlepartService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/middlepart")
public class RestMiddlepartController {

	@Autowired
	IMiddlepartService ser;
	
	@ApiOperation(value="모든 중분류를 조회합니다.")
	@GetMapping("/getMiddlepartAllList")
	public ResponseEntity<List<MiddlepartVO>> getMiddlepartAllList(){
		ResponseEntity<List<MiddlepartVO>> re = null;
		try {
			List<MiddlepartVO> list = ser.getMiddlepartAllList();
			re = new ResponseEntity<List<MiddlepartVO>>(list, HttpStatus.OK);
		}catch(Exception e){
			re = new ResponseEntity("모든  대분류 데이터 조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "중분류를 등록합니다.")
	@PostMapping("/insertMiddlepart")
	public ResponseEntity<String> insertMiddlepart(@RequestBody MiddlepartVO main) {
		ResponseEntity<String> re = null;
		try {
			ser.insertMiddlepart(main.getCode(), main.getName(), main.getMainpart(), main.getAreaCode());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "중분류를 삭제합니다.")
	@DeleteMapping(value = "/delMiddlepart/{code}")
	public ResponseEntity<String> delMiddlepart(@PathVariable String code) {
		ResponseEntity<String> re = null;
		try {
			ser.delMiddlepart(code);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "중분류를 수정합니다.")
	@PutMapping(value = "/updateMiddlepart")
	public ResponseEntity<String> updateMiddlepart(@RequestBody MiddlepartVO main) {
		ResponseEntity<String> re = null;
		try {
			ser.updateMiddlepart(main.getCode(), main.getName(), main.getMainpart(), main.getAreaCode());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="대분류code에 해당하는 중분류 리스트 뽑기")
	@GetMapping("/getMaincodeAllList/{maincode}")
	public ResponseEntity<List<MiddlepartVO>> getMaincodeAllList(@PathVariable String maincode){
		ResponseEntity<List<MiddlepartVO>> re = null;
		try {
			List<MiddlepartVO> list = ser.getMaincodeAllList(maincode);
			re = new ResponseEntity<List<MiddlepartVO>>(list, HttpStatus.OK);
		}catch(Exception e){
			re = new ResponseEntity("모든  대분류 데이터 조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	
}
