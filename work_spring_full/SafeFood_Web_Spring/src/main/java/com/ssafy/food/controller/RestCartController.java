package com.ssafy.food.controller;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.ssafy.food.dto.FoodVO;
import com.ssafy.food.dto.MypickVO;
import com.ssafy.food.service.ICartService;
import com.ssafy.food.service.IFoodService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class RestCartController {

	@Autowired
	private ICartService ser;

	@Autowired
	private IFoodService foodser;

	@ApiOperation(value = "cart를 등록합니다.")
	@PostMapping(value = "/insertCart/{userid}/{foodcode}/{amount}")
	public ResponseEntity<String> insertCart(@PathVariable String userid, @PathVariable String foodcode,
			@PathVariable String amount) {
		ResponseEntity<String> re = null;
		try {
			int Foodcode = Integer.parseInt(foodcode);
			int Amount = Integer.parseInt(amount);
			boolean flag = true;

			// 카트담긴 리스트 뽑아와라
			List<CartVO> list = ser.getCartAllList();
			// System.out.println(list.toString());
			for (int i = 0; i < list.size(); i++) {
				if (userid.equals(list.get(i).getUserid())) {
					if (Foodcode == list.get(i).getFoodcode()) {
						flag = false;
						int nm = list.get(i).getAmount() + Amount;
						ser.update(userid, Foodcode, nm);
						// System.out.println("000000");
					}
				}
			}
			if (flag) {
				ser.addCart(userid, Foodcode, Amount);
			}

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

	@ApiOperation(value = "food를 userid기준으로 조회합니다.")
	@GetMapping(value = "/cartList/{userid}")
	public ResponseEntity<List<MypickVO>> cartList(@PathVariable String userid) {
		ResponseEntity<List<MypickVO>> re = null;
		try {
			List<MypickVO> list = new ArrayList<MypickVO>();

			List<Integer> cartlist = ser.getCartList(userid);
			System.out.println(cartlist.size());
			List<FoodVO> foodlist = foodser.getFoodList();
			System.out.println(foodlist.size());
			for (int i = 0; i < cartlist.size(); i++) {
				for (int j = 0; j < foodlist.size(); j++) {
					if (foodlist.get(j).getCode() == cartlist.get(i)) {
						list.add(new MypickVO(foodlist.get(j).getCode(), foodlist.get(j).getImage(),foodlist.get(j).getName()));
					}
				}
			}
			List<Integer> amountlist = ser.getAmountList(userid);
			for(int i=0; i<amountlist.size(); i++) {
				list.set(i,new MypickVO(list.get(i).getCode(),list.get(i).getImage(),list.get(i).getName(), amountlist.get(i)));
			}
			//System.out.println(list.toString());
			re = new ResponseEntity<List<MypickVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

	@ApiOperation(value = "cart를 전체 조회합니다.")
	@GetMapping(value = "/cartList")
	public ResponseEntity<List<CartVO>> cartAllList() {
		ResponseEntity<List<CartVO>> re = null;
		try {
			List<CartVO> list = ser.getCartAllList();
			re = new ResponseEntity<List<CartVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			re = new ResponseEntity("조회 실패 문제가 생겼다!", HttpStatus.OK);
		}
		return re;
	}

}
