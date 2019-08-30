package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = 0, weight = 0;
		
		scan = new Scanner(System.in);
		height= scan.nextInt();
		weight= scan.nextInt();
		
		int num1 = weight+100-height;
				
		System.out.println("비만수치는" + num1 + "입니다.");
		
		if(num1>0) {
		System.out.println("당신은 비만이군요");
		}
	}

}
