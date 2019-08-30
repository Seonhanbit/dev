package sw_expert;

import java.util.Scanner;

public class s_2817_부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 수열 수
			int[] arr = new int[N];

			int S = sc.nextInt(); // 합이다

			// 수열을 받아보자
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 합을 구해보자
			int cnt = 0;
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (((1 << j) & i) != 0)
						sum += arr[j];
				}

				// 합이 같으면 cnt를 늘려주자
				if (sum == S)
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}
}
