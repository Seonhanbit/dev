package sw_expert2;

import java.util.Arrays;
import java.util.Scanner;

public class s_8104_조만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] arr = new int[k][n];
			int[] res = new int[k];

			int a = 1;
			for (int j = 0; j < n; j++) {
				if (j % 2 == 1) {
					for (int i = k - 1; i >= 0; i--) {
						arr[i][j] = a;
						a++;
					}
				} else {
					for (int i = 0; i < k; i++) {
						arr[i][j] = a;
						a++;
					}
				}
			}
//			if(i%2 == 0) {
//				arr[i][j] = val++;
//			}else {
//				arr[i][K-1-j] = val++;
//			}
			//지그재그 순회
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<k; j++) {
//					arr[i][j+(K-1-(2*j))*(i%2)] = val++;
//				}
//			}
			

//			for (int i = 0; i < k; i++) {
//				arr[i][0] = a;
//				a++;
//			}
//			for (int i = k - 1; i >= 0; i--) {
//				arr[i][1] = a;
//				a++;
//			}
//			for (int i = 0; i < k; i++) {
//				arr[i][2] = a;
//				a++;
//			}
//			for (int i = k - 1; i >= 0; i--) {
//				arr[i][3] = a;
//				a++;
//			}

			int sum = 0;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < n; j++) {
					sum += arr[i][j];
				}
				res[i] = sum;
				sum = 0;
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < k; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}

}
