package edu.ssafy.chap02;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�ζ��� �ְ� ���ڸ� �Է��ϼ���.");
		Scanner s = new Scanner(System.in);
		int[] lotto = new int[6];
		int idx = 0;
		int max = s.nextInt();

		for (int i = 0; i < lotto.length; i++) {
			int val = (int)(Math.random()*100%max + 1); // �ζǰ�
			// �ߺ� üũ
			// s.nextLine(); ������ �̷��������� �Է¹���
			lotto[idx] = val;
			idx++;
		}

		for (int i : lotto) {
			System.out.println(i);
		}
	}

}
