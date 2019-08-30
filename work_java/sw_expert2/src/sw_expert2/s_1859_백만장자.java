package sw_expert2;

import java.util.Arrays;
import java.util.Scanner;

public class s_1859_백만장자 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[]arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}

			int max = arr[n-1];			
			long money = 0;
			
			for(int i=n-2; i>=0; i--) {
				if(max<arr[i]) {
					max = arr[i];
				}else {
					money += max - arr[i];
				}
			}
			System.out.println("#"+tc+ " "+ money);

		}
	}
}
