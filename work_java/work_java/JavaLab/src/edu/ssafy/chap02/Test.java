package edu.ssafy.chap02;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("로또의 최고 숫자를 입력하세요.");
		Scanner s = new Scanner(System.in);
		int[] lotto = new int[6];
		int idx = 0;
		int max = s.nextInt();

		for (int i = 0; i < lotto.length; i++) {
			int val = (int)(Math.random()*100%max + 1); // 로또값
			// 중복 체크
			// s.nextLine(); 개행이 이뤄질때까지 입력받음
			lotto[idx] = val;
			idx++;
		}

		for (int i : lotto) {
			System.out.println(i);
		}
	}

}
