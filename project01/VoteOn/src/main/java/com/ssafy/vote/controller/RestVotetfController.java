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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vote.dto.VotetfVO;
import com.ssafy.vote.service.IVotetfService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/votetf")
public class RestVotetfController {
	
	@Autowired
	IVotetfService ser;
	
	@ApiOperation(value = "투표자코드로 모든 투표 고유키를 조회합니다.")
	@GetMapping("/getvotecode/{votercode}")
	public ResponseEntity<List<Integer>> getvotecode(String votercode) {
		ResponseEntity<List<Integer>> re = null;
		try {
			List<Integer> list = ser.getvotecode(votercode);
			re = new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표 유무를 등록합니다.")
	@PostMapping("/insertVotetf")
	public ResponseEntity<String> insertVotetf(@RequestBody VotetfVO votetf) {
		ResponseEntity<String> re = null;
		try {
			ser.insertVotetf(votetf.getVotercode(), votetf.getVotecode());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표 유무를 삭제합니다.")
	@DeleteMapping(value = "/delVotetf")
	public ResponseEntity<String> delVotetf(@RequestBody VotetfVO votetf) {
		ResponseEntity<String> re = null;
		try {
			ser.delVotetf(votetf.getVotercode(), votetf.getVotecode());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

}
