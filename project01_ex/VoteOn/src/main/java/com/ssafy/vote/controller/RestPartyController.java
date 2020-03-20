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

import com.ssafy.vote.dto.PartyVO;
import com.ssafy.vote.service.IPartyService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/party")
public class RestPartyController {
	
	@Autowired
	IPartyService ser;
	
	@ApiOperation(value="모든 정당을 조회합니다.")
	@GetMapping("/getPartyAllList")
	public ResponseEntity<List<PartyVO>> getPartyAllList(){
		ResponseEntity<List<PartyVO>> re = null;
		try {
			List<PartyVO> list = ser.getPartyAllList();
			re = new ResponseEntity<List<PartyVO>>(list, HttpStatus.OK);
		}catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}
	@ApiOperation(value = "정당을 등록합니다.")
	@PostMapping("/insertParty")
	public ResponseEntity<String> insertParty(@RequestBody PartyVO party) {
		ResponseEntity<String> re = null;
		try {
			ser.insertParty(party.getp_code(), party.getP_name());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "정당을 삭제합니다.")
	@DeleteMapping(value = "/delParty/{p_code}")
	public ResponseEntity<String> delParty(@PathVariable String p_code) {
		ResponseEntity<String> re = null;
		try {
			ser.delParty(p_code);
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "정당을 수정합니다.")
	@PutMapping(value = "/updateParty")
	public ResponseEntity<String> updateParty(@RequestBody  PartyVO party) {
		ResponseEntity<String> re = null;
		try {
			ser.updateParty(party.getp_code(), party.getP_name());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

}
