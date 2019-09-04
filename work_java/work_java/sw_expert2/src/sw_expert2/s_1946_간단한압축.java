package sw_expert2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class s_1946_간단한압축 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			String[] str = new String[n];
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				str[i] = sc.next();
				arr[i] = sc.nextInt();
			}

//			int sum = 0;
//			for (int i = 0; i < n; i++) {
//				sum += arr[i];
//			}
//			String[] arr1 = new String[sum];
//
//			for (int i = 0; i < arr1.length; i++) {
//				for (int j = 0; j < n; i++) {
//					while (arr[j] != 0) {
//						arr1[i] = str[i];
//					}
//				}
//			}

			ArrayList<String> res = new ArrayList<String>();

			for (int i = 0; i < n; i++) {
				while (arr[i] != 0) {
					res.add(str[i]);
					arr[i]--;
				}
			}

			System.out.println("#" + tc);
			for(int i=0; i<res.size(); i++) {
					System.out.print(res.get(i));
				if((i+1)%10==0) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}
