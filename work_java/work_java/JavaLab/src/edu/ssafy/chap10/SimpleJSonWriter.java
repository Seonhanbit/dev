package edu.ssafy.chap10;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SimpleJSonWriter {

	public static void main(String[] args) {
		// 최종 완성될 JSONObject 선언(전체)
		JSONObject jsonData = new JSONObject();
		// person의 JSON정보를 담을 Array 선언
		JSONArray Arrayperson = new JSONArray();
		// person의 한명 정보가 들어갈 JSONObject 선언
		JSONObject personData = new JSONObject();
		
		// 정보 입력
		personData.put("name", "송강호");
		personData.put("age", "25");
		personData.put("gender", "남자");
		personData.put("nickname", "남궁민수");
		// Array에 입력
		Arrayperson.add(personData);

		personData = new JSONObject();
		personData.put("name", "전지현");
		personData.put("age", "21");
		personData.put("gender", "여자");
		personData.put("nickname", "예니콜");
		
		Arrayperson.add(personData);
		// 전체의 JSONObject에 사람이란 name으로 JSON의 정보로 구성된 Array의 value를 입력
		jsonData.put("persons", Arrayperson);

		
		JSONArray bookArray = new JSONArray();

		JSONObject bookData = new JSONObject();
		bookData.put("name", "사람은 무엇으로 사는가?");
		bookData.put("writer", "톨스토이");
		bookData.put("price", "100");
		bookData.put("genre", "소설");
		bookData.put("publisher", "톨스토이 출판사");
		bookArray.add(bookData);

		bookData = new JSONObject();
		bookData.put("name", "홍길동전");
		bookData.put("writer", "허균");
		bookData.put("price", "300");
		bookData.put("genre", "소설");
		bookData.put("publisher", "허균 출판사");
		bookArray.add(bookData);

		bookData = new JSONObject();
		bookData.put("name", "레미제라블");
		bookData.put("writer", "빅토르 위고");
		bookData.put("price", "900");
		bookData.put("genre", "소설");
		bookData.put("publisher", "빅토르 위고 출판사");
		bookArray.add(bookData);

		jsonData.put("books", bookArray);

		// JSONObject를 String 객체에 할당
		String jsonInfo = jsonData.toJSONString();
		
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("object.json")));
			bw.write(jsonInfo);
			bw.close();
			System.out.println("jSon 파일이 만들어 졌습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
