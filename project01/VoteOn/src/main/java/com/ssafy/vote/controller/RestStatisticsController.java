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
import com.ssafy.vote.dto.StatisticsResultVO;
import com.ssafy.vote.dto.StatisticsVO;
import com.ssafy.vote.service.IStatisticsService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/statistics")
public class RestStatisticsController {
	
	@Autowired
	IStatisticsService ser;
	
	@ApiOperation(value = "모든 통계를 조회합니다.")
	@GetMapping("/getStatisticsAllList")
	public ResponseEntity<List<StatisticsVO>> getStatisticsAllList() {
		ResponseEntity<List<StatisticsVO>> re = null;
		try {
			List<StatisticsVO> list = ser.getStatisticsAllList();
			re = new ResponseEntity<List<StatisticsVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "후보자고유키로 통계를 등록합니다.")
	@PostMapping("/insertStatistics/{candi_code}")
	public ResponseEntity<String> insertStatistics(@PathVariable String candi_code) {
		ResponseEntity<String> re = null;
		try {
			int ncode = Integer.parseInt(candi_code);
			ser.insertStatistics(ncode);
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "통계를 삭제합니다.")
	@DeleteMapping(value = "/delStatistics/{s_code}")
	public ResponseEntity<String> delStatistics(@PathVariable String s_code) {
		ResponseEntity<String> re = null;
		try {
			int ncode = Integer.parseInt(s_code);
			ser.delStatistics(ncode);
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "통계를 수정합니다.")
	@PutMapping(value = "/updateStatistics")
	public ResponseEntity<String> updateStatistics(@RequestBody  StatisticsVO stati) {
		ResponseEntity<String> re = null;
		try {
			ser.updateStatistics(stati.getS_code(), stati.getCandi_code(), stati.getS_date());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "투표 고유키,날짜,시간을 받고 후보자명/득표수를 조회합니다.")
	@GetMapping("/getCandiPick/{votecode}/{date}/{hour}")
	public ResponseEntity<List<CandidateVO>> getCandiPick(@PathVariable String votecode, @PathVariable String date, @PathVariable String hour) {
		ResponseEntity<List<CandidateVO>> re = null;
		try {
			List<CandidateVO> list = ser.getCandiPick(votecode, date, hour);
			re = new ResponseEntity<List<CandidateVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "후보자 고유키를 받고 시간대별 득표수를 조회합니다.(24시간 정제)")
	@GetMapping("/getHourCnt/{candi_code}/{date}")
	public ResponseEntity<List<StatisticsResultVO>> getHourCnt(@PathVariable String candi_code, @PathVariable String date) {
		ResponseEntity<List<StatisticsResultVO>> re = null;
		try {
			List<StatisticsResultVO> list = ser.getHourCnt(candi_code, date);
			re = new ResponseEntity<List<StatisticsResultVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}
}
