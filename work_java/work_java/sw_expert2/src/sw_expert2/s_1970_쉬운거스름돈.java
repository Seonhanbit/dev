package sw_expert2;

import java.util.Scanner;

public class s_1970_쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int[] val = new int[8];
			
			for(int i=0; i<arr.length; i++) {
				int mok = 0;
				if(arr[i]<=n) {
					mok = n/arr[i];
					val[i] = mok;
					n = n-(mok*arr[i]);
				}
			}

			System.out.println("#" + tc + " ");
			for(int i=0; i<val.length; i++) {
				System.out.print(val[i]+" ");
			}
			System.out.println();
		}

	}
}
