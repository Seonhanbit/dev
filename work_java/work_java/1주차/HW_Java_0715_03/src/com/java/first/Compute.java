package com.java.first;

import java.util.Scanner;

public class Compute {

	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 0;
		
		scan = new Scanner(System.in);
		a= scan.nextInt();
		b= scan.nextInt();
		
		int num1 = a * b;
		int num2 = a/b;
		
		
		System.out.println("°ö=" + num1);
		System.out.println("¸ò=" + num2);
	}

}
