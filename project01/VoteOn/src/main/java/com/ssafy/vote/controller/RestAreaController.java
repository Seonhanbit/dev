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

import com.ssafy.vote.dto.AreaVO;
import com.ssafy.vote.service.IAreaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/area")
public class RestAreaController {

	@Autowired
	IAreaService ser;
	
	@ApiOperation(value = "모든 지역을 조회합니다.")
	@GetMapping("/getAreaAllList")
	public ResponseEntity<List<AreaVO>> getAreaAllList() {
		ResponseEntity<List<AreaVO>> re = null;
		try {
			List<AreaVO> list = ser.getAreaAllList();
			re = new ResponseEntity<List<AreaVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("모든 지역 데이터 조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "지역을 등록합니다.")
	@PostMapping("/insertArea")
	public ResponseEntity<String> insertArea(@RequestBody AreaVO area) {
		ResponseEntity<String> re = null;
		try {
			ser.insertArea(area.getAreaCode(), area.getName());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "지역을 삭제합니다.")
	@DeleteMapping(value = "/delArea/{areaCode}")
	public ResponseEntity<String> delArea(@PathVariable String areaCode) {
		ResponseEntity<String> re = null;
		try {
			ser.delArea(areaCode);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "지역을 수정합니다.")
	@PutMapping(value = "/updateArea")
	public ResponseEntity<String> updateArea(@RequestBody  AreaVO area) {
		ResponseEntity<String> re = null;
		try {
			ser.updateArea(area.getAreaCode(), area.getName());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}

	
	
}
