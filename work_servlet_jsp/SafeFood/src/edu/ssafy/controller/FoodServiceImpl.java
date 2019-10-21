package edu.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.Food.Food;
import edu.ssafy.Food.FoodManagerImpl;
import edu.ssafy.Food.IFoodManager;

public class FoodServiceImpl implements IFoodService {

	private IFoodManager food = new FoodManagerImpl();
	
	public void searchlist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String key = req.getParameter("key");
		String value = req.getParameter("value");

		List<Food> list = food.ConditionSearch(value, key);
		req.setAttribute("foodlist", list);
		req.getRequestDispatcher("searchlist.jsp").forward(req, resp);
	}

	public void searchbutton(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        if (key.equals("calory")) {
            List<Food> list = food.CalorySearch(value);
            List<String[]> powersetlist = food.powersetSearch(value);
            List<Food> total_list = new ArrayList<>();
            for (int i = 0; i < powersetlist.size(); i++) {
                // 이것은 한줄...........
                String line = "";
                int calo = 0;
                for (int j = 0; j < powersetlist.get(i).length; j++) {
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k).getName().equals(powersetlist.get(i)[j])) {
                            line += list.get(k).getName() + ",";
                            calo += list.get(k).getCalory();
                        }
                    }
                }
                Food ff = new Food();
                ff.setMaterial(line);
                ff.setCalory(calo);
                total_list.add(ff);
            }
            Collections.sort(total_list, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    return (int) (o2.getCalory() - o1.getCalory());
                }
            });
            for (int i = 0; i < total_list.size(); i++) {
                System.out.println(total_list.get(i).getMaterial() + "_" + total_list.get(i).getCalory());
            }
            
            
            req.setAttribute("total_list", total_list);
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            List<Food> list = food.ConditionSearch(value, key);
            req.setAttribute("foodlist", list);
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }

	public void mainpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Food> list = food.SearchAll();
		req.setAttribute("foodlist", list);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	@Override
	public void allergyprod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = (String) req.getSession().getAttribute("id");
		String allergy = food.AllergySearch(id);
//		System.out.println(allergy);

		String[] str = allergy.split(", ");
		
		for(int i=0; i<str.length; i++)
			System.out.println(str[i]);
		
		List<Food> allergyFoods = new ArrayList<>();
		List<Food> list = food.SearchAll();
		for (int i = 0; i < list.size(); i++) {
			
			for (int j = 0; j < str.length; j++) {
				if (list.get(i).getMaterial().contains(str[j])) {
					allergyFoods.add(list.get(i));
					break;
				}
			}
		}
		// 처리
		req.setAttribute("myallergy", allergyFoods);
		req.getRequestDispatcher("myallergy.jsp").forward(req, resp);
		// 보내기
	}

	@Override
	public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		Food f = food.detail(code);
		
		req.setAttribute("nutrition", f);
		req.getRequestDispatcher("detailpage.jsp").forward(req, resp);
	}
}
