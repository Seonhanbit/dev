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

import com.ssafy.vote.dto.VoterVO;
import com.ssafy.vote.service.IVoterService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api/voter")
public class RestVoterController {
	
	@Autowired
	private IVoterService ser;
	
	@ApiOperation(value = "모든 투표자를 조회합니다.")
	@GetMapping("/getVoterAllList")
	public ResponseEntity<List<VoterVO>> getVoterAllList() {
		ResponseEntity<List<VoterVO>> re = null;
		try {
			List<VoterVO> list = ser.getVoterAllList();
			re = new ResponseEntity<List<VoterVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("모든 투표자 데이터 조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자를 등록합니다.")
	@PostMapping("/insertVoter")
	public ResponseEntity<String> insertVoter(@RequestBody VoterVO voter) {
		ResponseEntity<String> re = null;
		try {
			ser.insertVoter(voter.getCode(),voter.getName(), voter.getAreaCode());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자를 삭제합니다.")
	@DeleteMapping(value = "/delVoter/{code}")
	public ResponseEntity<String> delVoter(@PathVariable String code) {
		ResponseEntity<String> re = null;
		try {
			int ncode = Integer.parseInt(code);
			ser.delVoter(ncode);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자를 수정합니다.")
	@PutMapping(value = "/updateVoter")
	public ResponseEntity<String> updateVoter(@RequestBody VoterVO voter) {
		ResponseEntity<String> re = null;
		try {
			ser.updateVoter(voter.getCode(), voter.getName(), voter.getAreaCode());
			re = new ResponseEntity<String>("업데이트 성공 ", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("업데이트 실패", HttpStatus.OK);
		}
		return re;
	}

}
