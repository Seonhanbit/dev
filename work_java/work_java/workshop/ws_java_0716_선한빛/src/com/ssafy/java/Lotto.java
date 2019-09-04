package com.ssafy.java;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("로또의 최고 숫자를 입력하세요.");
		Scanner s = new Scanner(System.in);
		int[] lotto = new int[6];
		int max = s.nextInt();
		int cnt = 0;
		boolean a = true;

		while (cnt < 6) {
			int val = (int) (Math.random() * 100 % max + 1); // 로또값
			// 중복 체크
			for (int i = 0; i < lotto.length; i++) {
				if (lotto[i] == val) {
					a = false;
					break;
				}
			}
				if (a == true) {
					lotto[cnt] = val;
					cnt++;
				} else {
					a = true;
					continue;
				}
			}
		for (int i : lotto) {
			System.out.println(i);
		}
	}
}
