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

import com.ssafy.vote.dto.VoteVO;
import com.ssafy.vote.service.IVoteService;

import io.swagger.annotations.ApiOperation;

/*
create database voteon;
use voteon;

create table vote(
	code int auto_increment primary key,
    name varchar(200),
    middlepart varchar(200) not null,
    start datetime,
    end datetime
);

create table candidate(
	code int auto_increment primary key,
    name varchar(200),
    num varchar(100),
    party varchar(100),
    votecode int,
    pick int
);

create table voter(
	code int primary key,
    name varchar(200),
    areaCode varchar(100)
);

create table area(
	areaCode varchar(100) primary key,
    name varchar(200)
);

create table middlepart(
	code varchar(100) primary key,
    name varchar(100),
    mainpart varchar(100),
    areaCode varchar(100)
);

create table mainpart(
	code varchar(100) primary key,
    name varchar(100)
);

drop table voter;*/

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api/vote")
public class RestVoteController {
	@Autowired
	private IVoteService ser;

	@ApiOperation(value = "모든 투표 데이터를 조회합니다.")
	@GetMapping("/getVoteAllList")
	public ResponseEntity<List<VoteVO>> getVoteAllList() {
		ResponseEntity<List<VoteVO>> re = null;
		try {
			List<VoteVO> list = ser.getVoteAllList();
			re = new ResponseEntity<List<VoteVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표를 등록합니다.")
	@PostMapping("/insertVote")
	public ResponseEntity<String> insertVote(@RequestBody VoteVO vote) {
		ResponseEntity<String> re = null;
		try {
			ser.insertVote(vote.getName(), vote.getMiddlepart(), vote.getStart(), vote.getEnd());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			// HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표를 삭제합니다.")
	@DeleteMapping(value = "/delVote/{code}")
	public ResponseEntity<String> delVote(@PathVariable String code) {
		ResponseEntity<String> re = null;
		try {
			int ncode = Integer.parseInt(code);
			ser.delVote(ncode);
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표를 수정합니다.")
	@PutMapping(value = "/updateVote")
	public ResponseEntity<String> updateVote(@RequestBody VoteVO vote) {
		ResponseEntity<String> re = null;
		try {
			ser.updateVote(vote.getCode(), vote.getName(), vote.getMiddlepart(), vote.getStart(), vote.getEnd());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "투표자 코드를 입력받은 뒤, 해당되는 투표 리스트를 조회합니다.")
	@GetMapping("/getVoteList/{votercode}")
	public ResponseEntity<List<VoteVO>> getVoteList(String votercode) {
		ResponseEntity<List<VoteVO>> re = null;
		try {
			List<VoteVO> list = ser.getVoteList(votercode);
			re = new ResponseEntity<List<VoteVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

}
