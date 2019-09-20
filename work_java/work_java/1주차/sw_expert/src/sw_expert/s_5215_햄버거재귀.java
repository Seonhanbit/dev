package sw_expert;

import java.util.Scanner;

public class s_5215_햄버거재귀 {

	static int tmax;
	static int n;
	static int l;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt(); // 재료의수
			l = sc.nextInt(); // 제한 칼로리
			int[] score_arr = new int[n];
			int[] cal_arr = new int[n];
			for (int i = 0; i < n; i++) {
				score_arr[i] = sc.nextInt();
				cal_arr[i] = sc.nextInt();
			}

			best(score_arr, cal_arr, 0, 0, 0);
			System.out.println("#" + tc + " " + tmax);
			tmax = 0;
		}
	}
	
	static void best(int[] score_arr, int[] cal_arr, int idx, int s_sum, int c_sum) {
		if(idx ==n) {
			if(c_sum <= l)
				if(tmax < s_sum) {tmax=s_sum;}
			return;		
		}
		best(score_arr, cal_arr, idx+1, s_sum, c_sum);
		best(score_arr, cal_arr, idx+1, s_sum+score_arr[idx], c_sum+cal_arr[idx]);
	}

}
