package sw_expert2;

import java.util.Scanner;

public class s_3431_준환이의운동 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int min = sc.nextInt();
			int max = sc.nextInt();
			int val = sc.nextInt();
			
			int res = 0;
			if(min<=val && val<=max) {
				res = 0;
			}else if(min > val) {
				res = min - val;
			}else if(max < val) {
				res = -1;
			}
			
			System.out.println("#" + tc + " "+res);
		}

	}
}
