package test;

import java.util.Arrays;
import java.util.Scanner;
//카드 셔플
public class Solution2 {
	public static void main(String args[]) throws Exception {
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr= new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int cnt = 0;
			
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
