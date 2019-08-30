package August;

import java.util.Scanner;

public class s_8338_계산기 {
	static int max = 0;

	static void calc(int[] arr, int c, int idx) {
		if (idx == arr.length) {
			//max = Math.max(max, val);
			if (max < c) {
				max = c;
			}
			return;
		}
//		if (cnt == arr.length) {
//			if (max < c) {
//				c = max;
//			}
//			System.out.println(c);
//		}

		calc(arr, c + arr[idx], idx + 1);
		calc(arr, c * arr[idx], idx + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.print("#" + tc + " ");
//			int sum = arr[0];
//			for (int i = 1; i < n; i++) {
//				if (arr[i] == 0 || arr[i] == 1 || sum == 0 || sum == 1) {
//					sum += arr[i];
//				} else {
//					sum *= arr[i];
//				}
//			}
//			System.out.println(sum);
			
			
			/*
			 * 첫번쨰 인자를 기억하기
			 * int result = sc.nextInt();
			 * for(int i=0; i<n; i++){
			 * int n = sc.nextInt();
			 * int mul = result*n;
			 * int sum = result+n;
			 * result = Math.max(mul, sum);}
			 */
			calc(arr, 0, 0);
			System.out.println(max);
			max = 0;

		}

	}

}
