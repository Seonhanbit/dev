package com.ssafy.food.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.food.delivery;
import com.ssafy.food.dto.FoodVO;
import com.ssafy.food.dto.LoadJsonData;
import com.ssafy.food.service.IFoodService;

/*create database fooddb;
use fooddb;
​
create table food (
   code int primary key,
   name varchar(30),
   maker varchar(30),
   material varchar(600),
   image varchar(50),
   supportpereat varchar(30),
   calory varchar(30),
   carbo varchar(30),
   protein varchar(30),
   fat varchar(30),
   sugar varchar(30),
   natrium varchar(30),
   chole varchar(30),
   fattyacid varchar(30),
   transfat varchar(30)
);
select*from food;
drop table food;
​
create table memtb(
id varchar(20) primary key,
pw varchar(20),
name varchar(20),
addr varchar(200),
email varchar(50),
tel varchar(50),
alinfo varchar(500)
);
​
select*from memtb;
delete from memtb where id='ssafy';
drop table memtb;

create table qna(
num int auto_increment primary key,
title varchar(50) not null,
content varchar(2000),
id varchar(20)
);

*/

@Controller
public class FoodController {
	@Autowired
	@Qualifier("FoodServiceImpl")
	IFoodService foodmanager;
	
	@Autowired
	LoadJsonData data;
		
	@RequestMapping(value = { "/", "main" })
	public String main() throws SQLException {
		data.truncate();
		data.loadData();
		return "main";
	}

	@RequestMapping("pdetail")
	public ModelAndView pdetail(ModelAndView mv, HttpServletRequest req) {
		List<FoodVO> foodlist = foodmanager.getFoodList();

		FoodVO food = new FoodVO();
		String c = req.getParameter("code");
		food = foodmanager.getFood(c);

		mv.addObject("food", food);
		mv.setViewName("pdetail");
		return mv;
	}

	@RequestMapping("productInfo")
	public ModelAndView productInfo(ModelAndView mv, HttpServletRequest req) {
		List<FoodVO> foodlist = foodmanager.getFoodList();

		mv.addObject("foodlist", foodlist);
		mv.setViewName("productInfo");
		return mv;
	}

	class cnt_keyword {
		String keyword;
		int cnt;

		public cnt_keyword(String keyword, int cnt) {
			this.keyword = keyword;
			this.cnt = cnt;
		};
	}

	ArrayList<cnt_keyword> list = new ArrayList<>();

	@RequestMapping("searchProduct")
	public ModelAndView searchProduct(ModelAndView mv, HttpServletRequest req) {
		int cnt = 0;

		String st = req.getParameter("searchType");
		List<FoodVO> FoodList = null;
		String name = req.getParameter("search");
		if (name.equals(""))
			FoodList = foodmanager.getFoodList();

		else if (st.equals("상품명")) {
			FoodList = (List<FoodVO>) foodmanager.getFoodnamelist(name);
		} else {
			String pcom = name;
			FoodList = (List<FoodVO>) foodmanager.getFoodmaker(pcom);
		}
		// 해당 단어가 들어가는 제품 수 count
		cnt = FoodList.size();

		// 제품명 순으로 정렬
		Collections.sort(FoodList);

		mv.addObject("cnt", cnt);
		mv.addObject("foodlist", FoodList);
		for (FoodVO foodVO : FoodList) {
			System.out.println(foodVO.toString());
		}

		// =============================================

		String keyword = req.getParameter("search");
		list.add(new cnt_keyword(keyword, 0));
		System.out.println(keyword);
		boolean chk = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).keyword.equals(keyword)) {
				chk = true;
				list.get(i).cnt++;
				break;
			}
		}

		int max_cnt = Integer.MIN_VALUE;
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			if (max_cnt < list.get(i).cnt) {
				max_cnt = list.get(i).cnt;
				str = list.get(i).keyword;
			}
		}
		System.out.println(max_cnt);

		mv.addObject("key", str);
		mv.setViewName("productInfo");
		return mv;
	}

	@RequestMapping("date")
	public ModelAndView date(ModelAndView mv, HttpServletRequest req) {
		int x = Integer.parseInt(req.getParameter("posx"));
		int y = Integer.parseInt(req.getParameter("posy"));
		
		String day = Integer.toString(new delivery().execute(x, y));
		mv.addObject("date", day);
		mv.setViewName("productInfo");
		return mv;
	}

	int[] calorie = new int[20];
	String[] name = new String[20];

	@RequestMapping("calo")
	public ModelAndView calo(ModelAndView mv, HttpServletRequest req) {
		int calo = Integer.parseInt(req.getParameter("calo"));
		for (int i = 1; i <= 20; i++) {
			FoodVO tmp = foodmanager.getFood(Integer.toString(i));
			calorie[i - 1] = (int) Double.parseDouble(tmp.getCalory());
			name[i - 1] = tmp.getName();
		}
		int N = calorie.length;
		int maxCal = 0;
		boolean[] chk = new boolean[N];
		boolean[] finalChk = new boolean[N];
		for (int i = 0; i < (1 << N); i++) {
			int sumCal = 0;
			Arrays.fill(chk, false);
			for (int j = 0; j < N; j++) {
				if (((1 << j) & i) != 0) {
					if (sumCal + calorie[j] <= calo) {
						sumCal += calorie[j];
						chk[j] = true;
					}
				}
			}
			if (maxCal < sumCal) {
				maxCal = sumCal;
				finalChk = chk.clone();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < finalChk.length; i++) {
			if (finalChk[i] == true) {
				sb.append(name[i]).append("<br>");
			}
		}

		mv.addObject("resultCalo", sb);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/mypick")
	public ModelAndView mypick(HttpServletRequest req, ModelAndView mv) {
		String id = (String) req.getSession().getAttribute("id");
		
		List<FoodVO> pickList = foodmanager.getPickList(id);
		mv.addObject("list", pickList);
		mv.setViewName("mypick");
		return mv;
	}
}
