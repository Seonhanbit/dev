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
				
		System.out.println("�񸸼�ġ��" + num1 + "�Դϴ�.");
		
		if(num1>0) {
		System.out.println("����� ���̱���");
		}
	}

}
