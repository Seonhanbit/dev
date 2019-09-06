package edu.ssafy.chap10;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class GSonEx3 {

	public static void main(String[] args) {
		// fromJson, toJson 이용하기
		Gson gson = new Gson(); 
		
		String jsonString = "[{'num':'lee','name':'Min','age':26,'address':'Seoul'},"
							+ "{'num':'park','name':'park','age':27,'address':'Seoul'},"
							+ "{'num':'kim','name':'kim','age':28,'address':'Incheon'}]"; 
		// json object Array => object 
		Member[] array = gson.fromJson(jsonString, Member[].class); 
		List<Member> list = Arrays.asList(array);
		System.out.println(list.toString());
		
		//object Array => json Object Array
		
		String json = gson.toJson(list);
		System.out.println(json);
		
		
		
	}

}
