package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ex_2036_카운팅정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //입력될 갯수
		
		int[] search = new int[200]; //문제에서 최대값 199
		
		for(int i=0; i<n; i++) {
			search[sc.nextInt()]++;
		}
				
		int sum=0;
		int i=0;
		while(true) {
			sum+= search[i];
			if(sum>n/2) break;
			i++;
		}
		System.out.println(i);	
	}

}
