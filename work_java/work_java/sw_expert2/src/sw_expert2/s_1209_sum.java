package sw_expert2;

import java.util.Scanner;

public class s_1209_sum {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if (sum > max)
					max = sum;
			}
			
//			int sum=0;
//			 for (int k = 0; k < 100; k++) {
//                 sum += arr[k][k];
//             }
//			 

			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				if (sum > max)
					max = sum;
			}

			int sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (i == j) {
						sum += arr[j][i];
						break;
					}
				}
			}
			if (sum > max)
				max = sum;
			
//			int i = 0;
//            for (int k = 99; k >= 0; k--) {
//                temp += array[k][i];
//                i++;
//            }
            
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (i + j == 99) {
						sum += arr[i][j];
						break;
					}
				}
			}
			if (sum > max)
				max = sum;
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
