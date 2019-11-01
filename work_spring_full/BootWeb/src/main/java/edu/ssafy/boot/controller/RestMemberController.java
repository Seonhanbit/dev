package edu.ssafy.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.boot.dto.BoolResult;
import edu.ssafy.boot.dto.Member;
import edu.ssafy.boot.service.MemService;

@RestController
@RequestMapping("/api")
public class RestMemberController {

	@Autowired
	@Qualifier("MemServiceImpl")
	private MemService ser;

	@PostMapping(value = "/meminsert")
	public ResponseEntity<String> insert(Member mem) {
		ResponseEntity<String> re = null;
		try {
			ser.insert(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@DeleteMapping(value = "/memdelete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		ResponseEntity<String> re = null;
		try {
			ser.delete(id);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@PutMapping(value = "/memupdate")
	public ResponseEntity<BoolResult> update(Member mem) {
		ResponseEntity<BoolResult> re = null;
		try {
			ser.update(mem.getId(), mem.getPw(), mem.getName(), mem.getEmail());
			re = new ResponseEntity<BoolResult>(new BoolResult("업데이트", true, "success"), HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<BoolResult>(new BoolResult("업데이트", false, "fail"), HttpStatus.NOT_MODIFIED);
		}
		return re;
	}

	@GetMapping(value = "/memselectone/{id}")
	public ResponseEntity<Member> selectOne(@PathVariable String id) {
		ResponseEntity<Member> re = null;
		try {
			Member selectOne = ser.selectOne(id);
			re = new ResponseEntity<Member>(selectOne, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.NO_CONTENT);
		}
		return re;
	}

	@GetMapping(value = "/memselectlist")
	public ResponseEntity<List<Member>> selectList() {
		ResponseEntity<List<Member>> re = null;
		try {
			List<Member> list = ser.selectList();
			re = new ResponseEntity<List<Member>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.NO_CONTENT);
		}
		return re;
	}

}
