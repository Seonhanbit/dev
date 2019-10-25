package edu.ssafy.controller;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import edu.ssafy.dto.Board;
import edu.ssafy.dto.RestReply;

@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController
@RequestMapping("/rest")
public class RestBoardController {
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public ResponseEntity<RestReply> insert(@RequestBody RestReply rr) {
		RestReply vo = new RestReply(rr.getReQMsg(), "insert",rr.getCode());
		if(vo.getCode() == null) {
			return new ResponseEntity<RestReply>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RestReply>(vo, HttpStatus.OK);
	}
	@RequestMapping(value="/test",method=RequestMethod.PUT)
	public ResponseEntity<RestReply> update(@RequestBody RestReply rr) {
		RestReply vo = new RestReply("update", rr.getCode());
		if(vo.getCode() == null) {
			return new ResponseEntity<RestReply>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RestReply>(vo, HttpStatus.OK);
	}
	@RequestMapping(value="/test/{seq}",method=RequestMethod.DELETE)
	public ResponseEntity<RestReply> delete(@PathVariable("seq")String seq) {
		RestReply vo = new RestReply("delete",seq);
		if(vo.getCode() == null) {
			return new ResponseEntity<RestReply>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RestReply>(vo, HttpStatus.OK);
	}
	@RequestMapping(value="/test/{seq}",method=RequestMethod.GET)
	public ResponseEntity<RestReply> select(@PathVariable("seq")String seq) {
		RestReply vo = new RestReply("select",seq);
		if(vo.getCode() == null) {
			return new ResponseEntity<RestReply>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RestReply>(vo, HttpStatus.OK);
	}
}
