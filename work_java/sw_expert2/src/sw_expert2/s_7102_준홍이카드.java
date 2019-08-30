package sw_expert2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class s_7102_준홍이카드 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			int[] res = new int[n+ m+1];

			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= m; b++) {
						list.add(a+b);
				}
			}

			for(int i=0; i<list.size(); i++) {
				res[list.get(i)]++;
			}
			
			int max = 0;
			int idx = 0;
			int cnt = 0;
			for(int i=1; i<res.length; i++) {
				if(max<res[i]) {
					max = res[i];
				}
			}
			
			boolean ck =true;
			for(int i=1; i<res.length; i++) {
				if(max==res[i]) {
					cnt++;
					if(ck) {
					idx = i;
					ck=false;
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<cnt; i++) {
				System.out.print(idx+i+" ");
			}
			System.out.println();
		}

	}
}
