package com.ssafy.food.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.food.dto.CartVO;
import com.ssafy.food.service.ICartService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestCartController {
	
	@Autowired
	private ICartService ser;

	@ApiOperation(value = "cart를 등록합니다.")
	@PostMapping(value = "/insertCart")
	public ResponseEntity<String> insertCart(CartVO cart) {
		ResponseEntity<String> re = null;
		try {
			ser.addCart(cart.getUserid(), cart.getFoodcode(), cart.getAmount());
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			// HttpStatus 통신은 제대로 된거니까 OK
			re = new ResponseEntity<String>("입력 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "cart를 삭제합니다.")
	@DeleteMapping(value = "/deleteCart/{cartid}")
	public ResponseEntity<String> deleteCart(@PathVariable String cartid) {
		ResponseEntity<String> re = null;
		try {
			int cid = Integer.parseInt(cartid);
			ser.delCart(cid);
			re = new ResponseEntity<String>("잘 들어 갔어용~", HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("삭제 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value = "cart를 전체 조회합니다.")
	@GetMapping(value="/cartList/{userid}")
	public ResponseEntity<List<Integer>> cartList(@PathVariable String userid){
		 ResponseEntity<List<Integer>> re = null;
		 try {
				List<Integer> list = ser.getCartList(userid);
				re = new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
			} catch (Exception e) {
				re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
			}
			return re;
	}
}
