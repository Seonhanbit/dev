package edu.ssafy.chap10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleJSonParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		try {
			//JSONObject 객체로 던져주기 parse라는 메소드 안에 파일 주기
			JSONObject parse = (JSONObject) parser
					.parse(new BufferedReader(new InputStreamReader(new FileInputStream("object.json"))));
			parse.size();

			//persons 배열(데이터가 배열안에 있음) 나옴 >> 2개의 객체가 뽑힘
			JSONArray objs = (JSONArray) parse.get("persons");
			for (int i = 0; i < objs.size(); i++) {
				JSONObject p = (JSONObject) objs.get(i);
				System.out.println(p.get("gender"));
				System.out.println(p.get("name"));
				System.out.println(p.get("nickname"));
				System.out.println(p.get("age"));
			}
			objs = (JSONArray) parse.get("books");
			for (int i = 0; i < objs.size(); i++) {
				JSONObject p = (JSONObject) objs.get(i);
				System.out.println(p.get("price"));
				System.out.println(p.get("name"));
				System.out.println(p.get("genre"));
				System.out.println(p.get("publisher"));
				System.out.println(p.get("writer"));
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
