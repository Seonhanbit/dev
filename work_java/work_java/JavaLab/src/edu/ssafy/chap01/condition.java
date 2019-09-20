package edu.ssafy.chap01;

import java.util.Random;

public class condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = false;
		int a = new Random().nextInt(101);
		
		//if가 참일때, 그 이후 코드는 실행되지 않음 
//		if(a>90) {
//			System.out.println("A");
//		}else if(a>80){
//			System.out.println("B");
//		}else if(a>70){
//			System.out.println("C");
//		}else if(a>60){
//			System.out.println("D");
//		}else{
//			System.out.println("F");
//		}
//		
		System.out.println((int)'A'); //아스키코드
		String str = "str";
		
		switch(str){
		//동등비교만 가능
//		case 99:
//		case 98:
//		case 97:
//		case 96:
//		case 95:
//		case 94:
//		case 93:
		case "str":
			System.out.println("A");
			break;
//		case 80:
//			System.out.println("B");
//			break;
//		case 70:
//			System.out.println("C");
//			break;				
		default:
			System.out.println("모름");	
		}
		
		System.out.println(a);
		switch(a/10){
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;				
		default:
			System.out.println("F");			
		}
		

	}

}
