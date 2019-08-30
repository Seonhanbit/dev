package edu.ssafy.chap11.sax;

import java.util.ArrayList;

public class MySaxMain {
	public static void main(String[] args){
		
		//MySAXParser라는 getContent라는 메소드 호출 
        ArrayList<Check> list=new MySAXParser().getContent("http://127.0.0.1:8080/result.xml");
        for(  Check c: list){
        	System.out.println(c.toString());
        }
    }
}