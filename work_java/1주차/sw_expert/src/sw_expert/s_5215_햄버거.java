package sw_expert;

import java.util.Scanner;

public class s_5215_햄버거 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 재료의수
			int L = sc.nextInt(); // 제한 칼로리
			int[] score_arr = new int[N];
			int[] cal_arr = new int[N];
			for (int i = 0; i < N; i++) {
				score_arr[i] = sc.nextInt();
				cal_arr[i] = sc.nextInt();
			}

			int tmax = 0;

			for (int i = 0; i < (1 << N); i++) {
				int tsum = 0;
				int sum = 0;
				for (int j = 0; j < N; j++) {

					if (((1 << j) & i) != 0) {
						tsum += score_arr[j];
						sum += cal_arr[j];
					}
				}
				if (sum > L)
					continue;
				if (tmax < tsum)
					tmax = tsum;

			}
			System.out.println("#" + tc + " " + tmax);
		}
	}
}
