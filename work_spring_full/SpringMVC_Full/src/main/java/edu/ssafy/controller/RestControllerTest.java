package edu.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.RestReply;
import edu.ssafy.service.MemberService;

@CrossOrigin(origins= {"*"},maxAge=6000)
@RestController
@RequestMapping("/rest")
public class RestControllerTest {
	@Autowired
	MemberService ser;
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public @ResponseBody Board getBoard() {
		System.out.println("get ");
		Board b = new Board();
		b.setContent("content");
		b.setCount(1);
		b.setRegDate(new java.sql.Date(System.currentTimeMillis()));
		b.setSeq(1);
		b.setTitle("get");
		b.setWriter("writer");
		return b;
	}
	
	@RequestMapping(value="/board/{id}", method=RequestMethod.POST)
	public @ResponseBody Board postBoard(@PathVariable String id) {
		System.out.println("post id : "+id);
		Board b = new Board();
		b.setContent("content");
		b.setCount(1);
		b.setRegDate(new java.sql.Date(System.currentTimeMillis()));
		b.setSeq(1);
		b.setTitle("post");
		b.setWriter(id);
		return b;
	}
	
	@RequestMapping(value="/board/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Board deleteBoard(@PathVariable String id) {
		System.out.println("post id : "+id);
		Board b = new Board();
		b.setContent("content");
		b.setCount(1);
		b.setRegDate(new java.sql.Date(System.currentTimeMillis()));
		b.setSeq(1);
		b.setTitle("delete");
		b.setWriter(id);
		return b;
	}
	
	@RequestMapping(value="/board/{id}", method=RequestMethod.PUT)
	public @ResponseBody Board putBoard(@PathVariable String id) {
		System.out.println("post id : "+id);
		Board b = new Board();
		b.setContent("content");
		b.setCount(1);
		b.setRegDate(new java.sql.Date(System.currentTimeMillis()));
		b.setSeq(1);
		b.setTitle("put");
		b.setWriter(id);
		return b;
	}
}




