package com.ssafy.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.food.dto.FoodVO;
import com.ssafy.food.service.IFoodService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class RestFoodController {
	@Autowired
	private IFoodService ser;
	
	@ApiOperation(value="음식을 code로 조회합니다.")
	@GetMapping("/pdetail/{code}")
	public ResponseEntity<FoodVO> pdetail(@PathVariable String code) {
		ResponseEntity<FoodVO> re = null;
		try {
			FoodVO food = new FoodVO();
			food = ser.getFood(code);
			re = new ResponseEntity<FoodVO>(food, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="음식 전체를 조회합니다.")
	@GetMapping(value = "/productInfo")
	public ResponseEntity<List<FoodVO>> productInfo() {
		ResponseEntity<List<FoodVO>> re = null;
		try {
			List<FoodVO> list = ser.getFoodList();
			re = new ResponseEntity<List<FoodVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="음식을 상세조회합니다.")
	@GetMapping(value = "/searchProduct/{searchType}/{search}")
	public ResponseEntity<List<FoodVO>> searchProduct(@PathVariable String searchType, @PathVariable String search) {
		ResponseEntity<List<FoodVO>> re = null;
		List<FoodVO> FoodList = null;
		try {
			if (search.equals(""))
				FoodList = ser.getFoodList();

			else if (searchType.equals("상품명")) {
				FoodList = (List<FoodVO>) ser.getFoodnamelist(search);
			} else {
				String pcom = search;
				FoodList = (List<FoodVO>) ser.getFoodmaker(pcom);
			}
			re = new ResponseEntity<List<FoodVO>>(FoodList, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	//date,calo

}
