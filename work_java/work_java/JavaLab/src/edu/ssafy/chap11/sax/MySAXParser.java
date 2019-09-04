package edu.ssafy.chap11.sax;


import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXParser {
	ArrayList<Check> list;

	public ArrayList<Check> getContent(String url){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			//MyHandler의 객체를 인자로 받아서, url을 가져와서 파일을 열어서 파싱하기
			//이벤트 핸들러 필요
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	public class MyHandler extends DefaultHandler{
		private StringBuilder sb;
		Check ch;
		//태그가 호출될 때마다 한번씩 다 호출됨
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}
		@Override
		//end 태그 호출 시 
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			super.endElement(uri, localName, name);
			if (this.ch != null){
				if (name.equalsIgnoreCase("Clean")){
					ch.setClean(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Ready")){
					ch.setReady(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Response")){
					ch.setResponse(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Request")){
					sb.trimToSize();
					if(sb.length()>0)
						ch.setRequest(sb.toString().trim());
				} else if (name.equalsIgnoreCase("Check")){
				     list.add(ch);
				}
				//하나의 엔드 태그가 끝날때마다 sb를 초기화 해주기
				sb.setLength(0);	
			}
		}
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			list = new ArrayList<Check>();
			sb = new StringBuilder();
		}
		@Override
		public void endDocument() throws SAXException {
			//  문서 끝날때 할 거 없으니까 오버라이드 안해도됨
			super.endDocument();
		}
		@Override
		//스타트 태그 호출 시, 속성이 들어감  -> <Check code="1001" date="2010.10.01">
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("Check")){
				ch = new Check();
				ch.setCode(attributes.getValue(0));
				ch.setDate(attributes.getValue(1));
			}
	}
}
}