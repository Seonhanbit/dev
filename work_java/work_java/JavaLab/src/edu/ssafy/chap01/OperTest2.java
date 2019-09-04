package edu.ssafy.chap01;

import java.util.Random;

public class OperTest2 {

	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		if((2>5) &(x++>y)) {
			y++;
		}
		//비트 연산자 앞이 거짓일 때, 무조건 뒤 실행
		System.out.println("x = "+x +", y = "+y);
		
		x = 0;
		y = 0;
		if((2>5) &&(x++>y)) {
			y++;
		}
		//논리연산자 앞이 거짓일 때, 뒤 실행 안함 
		System.out.println("x = "+x+",y = "+y);
		
	
		
	}
}