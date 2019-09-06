package edu.ssafy.chap11.dom;


import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyDOMParser {

	public ArrayList<Check> getContent(String url){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		ArrayList<Check> list = new ArrayList<Check>();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			//Element는 checkList
			//check가 여러개 있음 
			NodeList items = root.getElementsByTagName("Check");
			
			for (int i=0;i<items.getLength();i++){
				Check check = new Check();
				Node item = items.item(i);
				check.setCode(item.getAttributes().getNamedItem("code").getNodeValue());
				check.setDate(item.getAttributes().getNamedItem("date").getNodeValue());
				
				NodeList properties = item.getChildNodes();
				for (int j=0;j<properties.getLength();j++){
					Node property = properties.item(j);
					String name = property.getNodeName();
					if (name.equalsIgnoreCase("Clean")){
						check.setClean(property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("Ready")){
						check.setReady(property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("Response")){
						check.setResponse(property.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("Request")){
						if(property.getFirstChild()!= null)
							check.setRequest(property.getFirstChild().getNodeValue());
					}					
					
				}
				list.add(check);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return list;
}
}
	