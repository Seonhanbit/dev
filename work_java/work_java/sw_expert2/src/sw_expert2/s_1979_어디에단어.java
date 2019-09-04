package sw_expert2;

import java.util.Scanner;

public class s_1979_어디에단어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int key = sc.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;
			int chk = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == 1) {
						cnt++;
					} else {
						if (cnt == key)
							chk++;
						cnt = 0;
					}
				}
				if (cnt == key) {
					chk++;
				}
				cnt = 0;
			}

			cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j][i] == 1) {
						cnt++;
					} else {
						if (cnt == key)
							chk++;
						cnt = 0;
					}
				}
				if (cnt == key) {
					chk++;
				}
				cnt = 0;
			}
			System.out.println("#" + tc + " " + chk);
		}

	}
}
