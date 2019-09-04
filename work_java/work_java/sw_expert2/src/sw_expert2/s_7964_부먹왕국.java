package sw_expert2;

import java.util.Arrays;
import java.util.Scanner;

//돼지
public class s_7964_부먹왕국 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int city = sc.nextInt();
			int min = sc.nextInt();
			int[] arr = new int[city + 2];
			arr[0] = 1;
			arr[city + 1] = 1;
			for (int i = 1; i < arr.length - 1; i++) {
				arr[i] = sc.nextInt();
			}
			int cnt = 0;
			int k = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					k++;
				}else {
					k=0;
				}
				if(k==min) {
					cnt++;
					k=0;
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

}
