package com.ssafy.food.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.food.delivery;
import com.ssafy.food.controller.FoodController.cnt_keyword;
import com.ssafy.food.dto.FoodVO;
import com.ssafy.food.service.IFoodService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestFoodController {
	@Autowired
	private IFoodService ser;
	
	@ApiOperation(value="음식을 code로 조회합니다.")
	@GetMapping("/pdetail/{code}")
	public ResponseEntity<FoodVO> pdetail(@PathVariable String code) {
		//System.out.println(code);
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
	
	class cnt_keyword {
		String keyword;
		int cnt;

		public cnt_keyword(String keyword, int cnt) {
			this.keyword = keyword;
			this.cnt = cnt;
		};
	}

	List<cnt_keyword> cntlist = new ArrayList<>();
	
	@ApiOperation(value="음식 전체를 조회합니다.")
	@GetMapping(value = "/productInfo")
	public ResponseEntity<List<FoodVO>> productInfo() {
		//System.out.println("-----");
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
		int cnt = 0;
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
			cnt = FoodList.size();
			// 제품명 순으로 정렬
			Collections.sort(FoodList);
			String keyword = search;
			cntlist.add(new cnt_keyword(keyword, 0));
			for (int i = 0; i < cntlist.size(); i++) {
				if(cntlist.get(i).keyword.equals(keyword)) {
					cntlist.get(i).cnt++;
					break;
				}
			}
			//System.out.println(keyword);
			re = new ResponseEntity<List<FoodVO>>(FoodList, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	@ApiOperation(value="검색한 단어가 포함된 제품 수를 조회합니다.")
	@GetMapping(value="/searchCnt/{searchType}/{search}")
	public ResponseEntity<Integer> searchCnt(@PathVariable String searchType, @PathVariable String search){
		ResponseEntity<Integer> re = null;
		List<FoodVO> FoodList = null;
		int cnt = 0;
		try {
			if (search.equals(""))
				FoodList = ser.getFoodList();

			else if (searchType.equals("상품명")) {
				FoodList = (List<FoodVO>) ser.getFoodnamelist(search);
			} else {
				String pcom = search;
				FoodList = (List<FoodVO>) ser.getFoodmaker(pcom);
			}
			cnt = FoodList.size();
			re = new ResponseEntity<Integer>(cnt, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	
	@ApiOperation(value="가장 많이 검색한 키워드를 보여줍니다.")
	@GetMapping(value="/searchKey")
	public ResponseEntity<String> searchKey(){
		ResponseEntity<String> re = null;
		try {
			int max_cnt = Integer.MIN_VALUE;
			String str = "";
			for (int i = 0; i < cntlist.size(); i++) {
				if (max_cnt < cntlist.get(i).cnt) {
					max_cnt = cntlist.get(i).cnt;
					str = cntlist.get(i).keyword;
				}
			}
			re = new ResponseEntity<String>(str, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	
	//date 구현하자
	@ApiOperation(value="예상 배송 일을 보여줍니다.")
	@GetMapping(value="/date/{posx}/{posy}")
	public ResponseEntity<String> date(@PathVariable String posx, @PathVariable String posy){
		ResponseEntity<String> re = null;
		try {
			int x = Integer.parseInt(posx);
			int y = Integer.parseInt(posy);
			String day = Integer.toString(new delivery().execute(x, y));
			re = new ResponseEntity<String>(day, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity<String>("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}
	
	//calo

}
