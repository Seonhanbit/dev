package sw_expert2;

import java.util.Scanner;

public class s_6692_다솔이월급 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();

			float sum = 0;
			
			for(int i=0; i<n; i++) {
				float p = sc.nextFloat();
				int money = sc.nextInt();
				
				sum += (float)p*money;
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
