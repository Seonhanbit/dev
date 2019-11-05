package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FoodManagerImpl implements IFoodManager{

	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	@Override
	public List<FoodVO> getFoodList() {
		String str = "select * from food";
        ArrayList<FoodVO> list = null;
        try {
            conn = ConnectionProxy.getConnection();
            pst = conn.prepareStatement(str);
            rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {	
            	FoodVO vo = new FoodVO();
            	vo.setCode(rs.getInt("code"));
                vo.setName(rs.getString("name"));
                vo.setMaker(rs.getString("maker"));
                vo.setMaterial(rs.getString("material"));
                vo.setImage(rs.getString("image"));
                vo.setSupportpereat(rs.getString("supportpereat"));
                vo.setCalory(rs.getString("calory"));
                vo.setCarbo(rs.getString("carbo"));
                vo.setProtein(rs.getString("protein"));
                vo.setFat(rs.getString("fat"));
                vo.setSugar(rs.getString("sugar"));
                vo.setNatrium(rs.getString("natrium"));
                vo.setChole(rs.getString("chole"));
                vo.setFattyacid(rs.getString("fattyacid"));
                vo.setTransfat(rs.getString("transfat"));
                list.add(vo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
        System.out.println(list.size());
        return list;
	}

	@Override
	public FoodVO getFood(int code) {
		// TODO Auto-generated method stub
		String str = "select * from food where code = ?";
		FoodVO vo = null;
		pst = null;
		try {
            conn = ConnectionProxy.getConnection();
            pst = conn.prepareStatement(str);
            pst.setInt(1, code);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                vo = new FoodVO();
                vo.setCode(rs.getInt("code"));
                vo.setName(rs.getString("name"));
                vo.setMaker(rs.getString("maker"));
                vo.setMaterial(rs.getString("material"));
                vo.setImage(rs.getString("image"));
                vo.setSupportpereat(rs.getString("supportpereat"));
                vo.setCalory(rs.getString("calory"));
                vo.setCarbo(rs.getString("carbo"));
                vo.setProtein(rs.getString("protein"));
                vo.setFat(rs.getString("fat"));
                vo.setSugar(rs.getString("sugar"));
                vo.setNatrium(rs.getString("natrium"));
                vo.setChole(rs.getString("chole"));
                vo.setFattyacid(rs.getString("fattyacid"));
                vo.setTransfat(rs.getString("transfat"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
        return vo;
	}
	
	@Override
	public List<FoodVO> getFoodmaker(String maker) {
		// TODO Auto-generated method stub
		String str = "select * from food where maker like '%"+ maker +"%'";
		FoodVO vo = null;
		ArrayList<FoodVO> list = null;
		pst = null;
		try {
            conn = ConnectionProxy.getConnection();
            pst = conn.prepareStatement(str);
            rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
            	vo = new FoodVO();
            	vo.setCode(rs.getInt("code"));
                vo.setName(rs.getString("name"));
                vo.setMaker(rs.getString("maker"));
                vo.setMaterial(rs.getString("material"));
                vo.setImage(rs.getString("image"));
                list.add(vo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
	}
	@Override
	public FoodVO getFoodname(String name) {
		// TODO Auto-generated method stub
		String str = "select * from food where name = ?";
		FoodVO vo = null;
		pst = null;
		try {
            conn = ConnectionProxy.getConnection();
            pst = conn.prepareStatement(str);
            pst.setString(1, name);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                vo = new FoodVO();
                vo.setCode(rs.getInt("code"));
                vo.setName(rs.getString("name"));
                vo.setMaker(rs.getString("maker"));
                vo.setMaterial(rs.getString("material"));
                vo.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
		 return vo;
	}

	@Override
	public List<FoodVO> getFoodnamelist(String name) {
		String str = "select * from food where name like '%" + name + "%'";
		ArrayList<FoodVO> list = null;
		FoodVO vo = null;
		pst = null;
		try {
            conn = ConnectionProxy.getConnection();
            pst = conn.prepareStatement(str);
            rs = pst.executeQuery();
            
            list = new ArrayList<>();
            while (rs.next()) {	
            	vo = new FoodVO();
            	vo.setCode(rs.getInt("code"));
                vo.setName(rs.getString("name"));
                vo.setMaker(rs.getString("maker"));
                vo.setMaterial(rs.getString("material"));
                vo.setImage(rs.getString("image"));
                list.add(vo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
	}

	public void close(){
		try {
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		try{
			while(true){
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("item");
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
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
				if(page > 1){	
					break;
				}
			}	// while end
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		return foodlist;
	}


	
	public void loadData(String url, String url2) throws SQLException {
		String sql = "insert into food(code ,name,maker,material,image ,supportpereat ,calory ,carbo ,protein ,fat ,sugar,natrium ,chole ,fattyacid ,transfat) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		List<FoodVO> productList = new ArrayList<>();
		List<FoodVO> productListdetail = new ArrayList<>();
		url = "file:///" + url;
		productList = productparsing1(url);
		
		url2 = "file:///" + url2;
		productListdetail = productparsing2(url2);
		conn = ConnectionProxy.getConnection();
		
		int cnt = 0;
			try {
				for(FoodVO productList2 : productList) {
					pst = conn.prepareCall(sql);
					pst.setInt(1, productList2.getCode());
					pst.setString(2, productList2.getName());
					pst.setString(3, productList2.getMaker());
					pst.setString(4, productList2.getMaterial());
					pst.setString(5, productList2.getImage());
					
					pst.setString(6, productListdetail.get(cnt).getSupportpereat());
					pst.setString(7, productListdetail.get(cnt).getCalory());
					pst.setString(8, productListdetail.get(cnt).getCarbo());
					pst.setString(9, productListdetail.get(cnt).getProtein());
					pst.setString(10, productListdetail.get(cnt).getFat());
					pst.setString(11, productListdetail.get(cnt).getSugar());
					pst.setString(12, productListdetail.get(cnt).getNatrium());
					pst.setString(13, productListdetail.get(cnt).getChole());
					pst.setString(14, productListdetail.get(cnt).getFattyacid());
					pst.setString(15, productListdetail.get(cnt).getTransfat());
					cnt++;
					pst.execute();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}