package com.ssafy.food.dto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoadJsonData {
	@Autowired
	ServletContext context;

	@Autowired
	SqlSession ss;
	
	//여기 truncate 작성
	public void truncate() {
		ss.delete("food.deleteAllMembers");
	}

	public void loadData() throws SQLException {
		String url = context.getRealPath("/WEB-INF/res/foodInfo.xml");
		String url2 = context.getRealPath("/WEB-INF/res/FoodNutritionInfo.xml");
		List<FoodVO> productList = new ArrayList<>();
		List<FoodVO> productListdetail = new ArrayList<>();
		url = "file:///" + url;
		productList = productparsing1(url);
		url2 = "file:///" + url2;
		productListdetail = productparsing2(url2);

		for (int i = 0; i < productList.size(); i++) {
			FoodVO f = new FoodVO();
			f.setCode(productList.get(i).getCode());
			f.setName(productList.get(i).getName());
			f.setMaker(productList.get(i).getMaker());
			f.setImage(productList.get(i).getImage());
			f.setMaterial(productList.get(i).getMaterial());
			f.setSupportpereat(productListdetail.get(i).getSupportpereat());
			f.setCalory(productListdetail.get(i).getCalory());
			f.setCarbo(productListdetail.get(i).getCarbo());
			f.setProtein(productListdetail.get(i).getProtein());
			f.setFat(productListdetail.get(i).getFat());
			f.setSugar(productListdetail.get(i).getSugar());
			f.setNatrium(productListdetail.get(i).getNatrium());
			f.setChole(productListdetail.get(i).getChole());
			f.setFattyacid(productListdetail.get(i).getFattyacid());
			f.setTransfat(productListdetail.get(i).getTransfat());
			
			ss.insert("food.insertFood", f);
		}
		//ss.insert("food.insert", food);
	}
	public String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if(nValue == null) 
			return null;
		return nValue.getNodeValue();
	}

	public List<FoodVO> productparsing1(String url) {

		int page = 1;	
		List<FoodVO> foodlist = new ArrayList<>();
		try{
			while(true){
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("food");
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						Element eElement = (Element) nNode;
						FoodVO vo = new FoodVO();
						vo.setCode(Integer.parseInt(getTagValue("code", eElement)));
						vo.setName(getTagValue("name", eElement));
						vo.setMaker(getTagValue("maker", eElement));
						vo.setMaterial(getTagValue("material", eElement));
						vo.setImage(getTagValue("image", eElement));
						foodlist.add(vo);
					}	
				}	
				page += 1;
				if(page > 1){	
					break;
				}
			}	// while end
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		return foodlist;
	}

	public List<FoodVO> productparsing2(String url) {
		int page = 1;
		List<FoodVO> foodlist = new ArrayList<>();
		try {
			while (true) {
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("item");
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						FoodVO vo1 = new FoodVO();
						vo1.setSupportpereat(getTagValue("SERVING_WT", eElement));
						vo1.setCalory(getTagValue("NUTR_CONT1", eElement));
						vo1.setCarbo(getTagValue("NUTR_CONT2", eElement));
						vo1.setProtein(getTagValue("NUTR_CONT3", eElement));
						vo1.setFat(getTagValue("NUTR_CONT4", eElement));
						vo1.setSugar(getTagValue("NUTR_CONT5", eElement));
						vo1.setNatrium(getTagValue("NUTR_CONT6", eElement));
						vo1.setChole(getTagValue("NUTR_CONT7", eElement));
						vo1.setFattyacid(getTagValue("NUTR_CONT8", eElement));
						vo1.setTransfat(getTagValue("NUTR_CONT9", eElement));
						foodlist.add(vo1);
					}
				}
				page += 1;
				if (page > 1) {
					break;
				}
			} // while end
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		return foodlist;
	}
}