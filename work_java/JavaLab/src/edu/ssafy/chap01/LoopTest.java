package edu.ssafy.chap01;

import java.util.Random;

public class LoopTest {

	public static void main(String[] args) {
			
		Random r = new Random();
		
		// while ������ true�� ���� ����
		int condition = 0;
//		while(condition < 6){
//			
//			int val1 = r.nextInt(100) % 45 + 1;
//			System.out.println(val1);
//			condition ++;						
//		}
//		do {
//			int val1 = r.nextInt(100) % 45 + 1;
//			System.out.println(val1);
//			
//			condition ++;
//			
//		}while(condition < 6);
		
		//(�ʱⰪ;���ǰ�;������)
		for(int a=4, b=1; a>=1; a--, b++) { 
			System.out.println(a);
			System.out.println(b);
		}
		
				
	}
}
