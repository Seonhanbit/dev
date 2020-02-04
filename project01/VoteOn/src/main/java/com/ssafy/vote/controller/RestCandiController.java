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

import com.ssafy.vote.dto.CandidateVO;
import com.ssafy.vote.service.ICandiService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/candi")
public class RestCandiController {

	@Autowired
	private ICandiService ser;

	@ApiOperation(value = "모든 후보자 데이터를 조회합니다.")
	@GetMapping("/getCandiAllList")
	public ResponseEntity<List<CandidateVO>> getCandiAllList() {
		ResponseEntity<List<CandidateVO>> re = null;
		try {
			List<CandidateVO> list = ser.getCandiAllList();
			re = new ResponseEntity<List<CandidateVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "후보자 code로 특정 후보자 데이터를 조회합니다.")
	@GetMapping("/getCandiCode/{code}")
	public ResponseEntity<CandidateVO> getCandiCode(@PathVariable String code) {
		ResponseEntity<CandidateVO> re = null;
		try {
			CandidateVO candi = new CandidateVO();
			int ncode = Integer.parseInt(code);
			candi = ser.getCandiCode(ncode);
			re = new ResponseEntity<CandidateVO>(candi, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "투표 code로 해당 투표 후보자 리스트를 조회합니다.")
	@GetMapping("/getCandiVotecode/{votecode}")
	public ResponseEntity<List<CandidateVO>> getCandiVotecode(@PathVariable String votecode) {
		ResponseEntity<List<CandidateVO>> re = null;
		try {
			int nvotecode = Integer.parseInt(votecode);
			List<CandidateVO> list = ser.getCandiVotecode(nvotecode);
			re = new ResponseEntity<List<CandidateVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "후보자를 등록합니다.")
	@PostMapping("/insertCandi")
	public ResponseEntity<String> insertCandi(@RequestBody CandidateVO candi) {
		ResponseEntity<String> re = null;
		try {
			ser.insertCandi(candi.getName(), candi.getNum(), candi.getParty(), candi.getVotecode(), candi.getPick());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "후보자를 삭제합니다.")
	@DeleteMapping(value = "/delCandi/{code}")
	public ResponseEntity<String> delCandi(@PathVariable String code) {
		ResponseEntity<String> re = null;
		try {
			int ncode = Integer.parseInt(code);
			ser.delCandi(ncode);
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "후보자를 수정합니다.")
	@PutMapping(value = "/updateCandi")
	public ResponseEntity<String> updateCandi(@RequestBody CandidateVO candi) {
		ResponseEntity<String> re = null;
		try {
			ser.updateCandi(candi.getCode(), candi.getName(), candi.getNum(), candi.getParty(), candi.getVotecode(),
					candi.getPick());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "후보자의 득표수를 업데이트합니다.")
	@PutMapping(value = "/updateCandiList/{code}")
	public ResponseEntity<String> updateCandiList(@PathVariable String code) {
		ResponseEntity<String> re = null;
		try {
			ser.updateCandiList(code);
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

}
