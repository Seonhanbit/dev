package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1부터 9자리까지, arr[0]은 0이 들어가지 않고, 10-20-30-40...자리 수가 들어감
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		Scanner s = new Scanner(System.in);

		int tmp = 0;
		while (true) {
			tmp = s.nextInt();
			if (tmp == 0)
				break;
			arr[tmp / 10]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0) continue;
			System.out.println(i + " : " + arr[i] + "개");
		}
	}
}

//�Է� �ޱ�
//while(val==0) {
//for(int i=0; i<arr.length; i++)
//{
//	for(int j=0; j<arr[i].length; j++)
//	{
//		arr[i][j] = s.nextInt();
//	}
//}
