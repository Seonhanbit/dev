package sw_expert2;

import java.util.Scanner;

public class s_1976_시각덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int a1 = sc.nextInt();
			int b1 = sc.nextInt();
			
			int sum1 = a + a1;
			int sum2 = b + b1;
			
			int cnt = 0;
			
			if(sum2%60==0) {
				cnt++;
				sum2 = 0;
			}else if(sum2>60) {
				sum2 = sum2%60;
				cnt++;
			}
			sum1 += cnt;
		
			if(sum1%12==0) {
				sum1 = 12;
			}else if(sum1>12) {
				sum1 = sum1%12;
			}
			
			System.out.println("#"+tc+" "+sum1+" "+sum2);
		}
	}
}
