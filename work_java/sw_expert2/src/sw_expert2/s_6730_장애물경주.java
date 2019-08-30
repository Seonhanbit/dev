package sw_expert2;

import java.util.Arrays;
import java.util.Scanner;

public class s_6730_장애물경주 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
//			int[] val = new int[n - 1];
			int min =0;
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				int tmp;
				if(i>0) {
					if(arr[i-1]<arr[i]) {
						tmp = arr[i]-arr[i-1];
						if(max < tmp) max = tmp;
					}else if(arr[i-1]>arr[i]) {
						tmp = arr[i - 1] - arr[i];
						if (min< tmp) min = tmp;
					}
				}
			}
//
//			for (int i = 0; i < arr.length - 1; i++) {
//				val[i] = arr[i] - arr[i + 1];
//			}
//
//			Arrays.sort(val);
//
//			if (val.length == 1) {
//				if (val[0] > 0) {
//					max = val[0];
//					min = 0;
//				} else if (val[0] == 0) {
//					min = 0;
//					max = 0;
//				} else {
//					min = -val[0];
//					max = 0;
//
//				}
//			} else {
//				min = val[0];
//
//				if (min == 0) {
//					min = 0;
//				} else if (min < 0) {
//					min = -min;
//				} else {
//					min = min;
//				}
//
//				max = val[n - 2];
//			}

			System.out.println("#" + tc + " " + max + " " + min);

		}

	}
}
