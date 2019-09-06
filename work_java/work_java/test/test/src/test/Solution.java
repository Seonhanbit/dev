package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static int M;
	static int K;

	public static void main(String args[]) throws Exception {
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			int[][] arr = new int[N][M];
			int[] value = new int[11];
			for (int n = 0; n < K; n++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int nx = sc.nextInt();
				int ny = sc.nextInt();
				int val = sc.nextInt();

				boolean ck = true;
				for (int i = x; i <= nx; i++) {
					for (int j = y; j <= ny; j++) {
						if (arr[i][j] > val) {
							ck = false;
						}
					}
				}

				if (ck == true) {
					for (int i = x; i <= nx; i++) {
						for (int j = y; j <= ny; j++) {
							arr[i][j] = val;
						}
					}
				}
			}
			for (int k = 0; k < 11; k++) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (arr[i][j] == k)
							cnt++;
						value[k] = cnt;
					}
				}
			}

			Arrays.sort(value);
			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + tc + " " + value[10]);
		}

		sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
