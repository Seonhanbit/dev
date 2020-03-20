package com.ssafy.vote.controller;

import java.util.HashMap;
import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;
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

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/voter")
public class RestVoterController {

	@Autowired
	private IVoterService ser;
	
	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	{
		//단방향 해시 알고리즘
		//String nid_num = BCrypt.hashpw(id_num, BCrypt.gensalt());
		
		encryptor.setPassword("somePassword");
		encryptor.setAlgorithm("PBEWithMD5AndDES");
		//StringFixedSaltGenerator를 사용해 고정된 salt값을 지정하면 암호화된 결과 값이 고정돼서 반환
		encryptor.setSaltGenerator(new StringFixedSaltGenerator("someFixedSalt"));
	}
	
	@ApiOperation(value = "모든 투표자를 조회합니다.")
	@GetMapping("/getVoterAllList")
	public ResponseEntity<List<VoterVO>> getVoterAllList() {
		ResponseEntity<List<VoterVO>> re = null;
		try {
			List<VoterVO> list = ser.getVoterAllList();
			for(int i=0; i<list.size(); i++) {
				VoterVO test = list.get(i);
				String decStr = encryptor.decrypt(test.getId_num());
				test.setId_num(decStr);
				list.set(i, test);
			}
			re = new ResponseEntity<List<VoterVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자 code와 name 입력 시 투표자 이름이 맞는지 TF로 나타냅니다.")
	@GetMapping("/getVoterNameTF/{votercode}/{name}")
	public ResponseEntity<String> getVoterNameTF(@PathVariable String votercode, @PathVariable String name) {
		ResponseEntity<String> re = null;
		try {			
			String TF = "";
			int ncode = Integer.parseInt(votercode);
			VoterVO test_voter = ser.getVotercode(ncode);
			
			if (name.equals(test_voter.getName()))
				TF = "true";
			else
				TF = "false";
			re = new ResponseEntity<String>(TF, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자 이름/주민번호 입력시 투표자 고유키를 넘겨주는 기능")
	@GetMapping("/getOnlyVotercode/{name}/{id_num}")
	public ResponseEntity<String> getOnlyVotercode(@PathVariable String name, @PathVariable String id_num) {
		ResponseEntity<String> re = null;
		try {
			//주민번호 암호화
			String encStr = encryptor.encrypt(id_num); 
			//복호화 메소드
			//String decStr = encryptor.decrypt(encStr);
			
			String str = ser.getOnlyVotercode(name, encStr)+"";
			re = new ResponseEntity<String>(str, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자를 등록합니다.")
	@PostMapping("/insertVoter")
	public ResponseEntity<String> insertVoter(@RequestBody VoterVO voter) {
		ResponseEntity<String> re = null;
		try {
			//주민 번호 암호화 시켜서 등록
			String encStr = encryptor.encrypt(voter.getId_num()); 
			ser.insertVoter(voter.getCode(), encStr, voter.getName(), voter.getAreaCode());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
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
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "투표자를 수정합니다.")
	@PutMapping(value = "/updateVoter")
	public ResponseEntity<String> updateVoter(@RequestBody VoterVO voter) {
		ResponseEntity<String> re = null;
		try {
			ser.updateVoter(voter.getCode(), voter.getName(), voter.getAreaCode());
			re = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("failure", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "해당 투표의 투표자 통계용 데이터를 반환합니다.")
	@GetMapping(value = "/voteProgressData/{voteCode}")
	public ResponseEntity<HashMap<String,Object>> voteProgressData(@PathVariable String voteCode){
		ResponseEntity<HashMap<String,Object>> entity = null;
		HashMap<String, Object> data = new HashMap<String, Object>();
		try {
			HashMap<String, Object> map = ser.getVoteProgressData(voteCode);
			data.put("result", map);
			data.put("resmsg", "success");
		} catch (Exception e) {
			data.put("resmsg", "failure");
		}finally {
			entity = new ResponseEntity<HashMap<String,Object>>(data, HttpStatus.OK);
		}
		
		return entity;
	}
}
