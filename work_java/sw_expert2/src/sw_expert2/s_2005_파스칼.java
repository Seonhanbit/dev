package sw_expert2;

import java.util.ArrayList;
import java.util.Scanner;

public class s_2005_파스칼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			System.out.println("#" + tc);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[j][0] = 1;
					if (i == j) {
						arr[i][j] = 1;
					}
				}
			}

			for (int i = 2; i < arr.length; i++) {
				for (int j = 1; j < arr.length; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(arr[i][j]!=0) {
						System.out.print(arr[i][j]);
					}
				}
				System.out.println();
			}
			
		}
	}

}
