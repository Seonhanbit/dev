package edu.ssafy.chap01;

public class LoopTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
//				System.out.println(i+" X " + j + " = " + j * i);
				System.out.print(" * ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------");
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(" * ");
			}
			System.out.println("");
		}
		
		System.out.println("-----------------");
		
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" * ");
			}
			System.out.println("");
		}
		
		System.out.println("-----------------");
		
		for (int i = 1; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" * ");
			}
			System.out.println("");
		}
//for(;1==1;){} >>公茄风橇 规过

	}

}
