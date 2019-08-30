package sw_expert;

import java.util.Scanner;

public class s_2817_재귀 {

	static int S;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 수열 수
			int[] arr = new int[N];

			S = sc.nextInt(); // 합이다

			// 수열을 받아보자
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 합을 구해보자
			addsum(arr, 0, 0);
			System.out.println("#" + tc + " " + cnt);
			cnt = 0; //테스트 케이스 여러번 도니깐
		}

	}

	static void addsum(int[] arr, int idx, int sum) {
		if (idx == arr.length) {
			if (sum == S) {
				cnt++;
			}
			return;
		}
		addsum(arr, idx + 1, sum);
		addsum(arr, idx + 1, sum + arr[idx]);
	}
}
