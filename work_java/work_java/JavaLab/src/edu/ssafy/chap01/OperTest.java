package edu.ssafy.chap01;

import java.util.Random;

public class OperTest {

	public static void main(String[] args) {
		
		int sum = 0, oper1 = 15, oper2 = 12;
		sum = oper1 + oper2;
		int min = oper1 - oper2;
		int cro = oper1 * oper2;
		float div = (float)oper1 / (float)oper2; //�� ��ȯ
		int mod = oper1 % oper2; // ���(������) ���ϱ�

//		System.out.println(sum);
//		System.out.println(min);
//		System.out.println(cro);
//		System.out.println(div);
//		System.out.println(mod);
		
		
		Random r = new Random();
		int val = r.nextInt(100) % 45 + 1; // 0~99������ int ���� �����ϰ� ������ > 0~44 > 0~45
		System.out.println(val);
		
		
	}
}
