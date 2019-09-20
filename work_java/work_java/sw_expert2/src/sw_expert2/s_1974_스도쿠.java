package sw_expert2;

import java.util.Arrays;
import java.util.Scanner;

public class s_1974_스도쿠 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			int val = 0;
			int sum = 45;
			int sum1 = 0;

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sum1 += arr[i][j];
				}
				if (sum1 == sum) {
					val = 1;
					sum1 = 0;
				} else {
					val = 0;
					break;
				}
			}

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sum1 += arr[j][i];
				}
				if (sum1 == sum) {
					val = 1;
					sum1 = 0;
				} else {
					val = 0;
					break;
				}
			}


			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i % 3 == 0 && j % 3 == 0) {
						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								sum1 += arr[i + k][j + l];
							}
						}
						if (sum1 == sum) {
							val = 1;
							sum1 = 0;
						} else {
							val = 0;
							break;
						}
					}
				}
			}
			

			System.out.println("#" + tc + " " + val);
		}

	}
}
