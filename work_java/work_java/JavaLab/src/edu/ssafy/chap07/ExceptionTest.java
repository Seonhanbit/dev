package edu.ssafy.chap07;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt();
		int b = s.nextInt();
		int res = 0;
		try {
		res = a/b;
//		}catch(ArithmeticException e) {
//			System.out.println("00000을 입력하시면 안돼요");
//		}catch(Exception e ) {
//			e.printStackTrace();
//			System.out.println("0을 입력하시면 안돼요");
		}finally {
			System.out.println("finally");
		}
		System.out.println("res : " +res);
		
		System.out.println("Program end");
	}

}
