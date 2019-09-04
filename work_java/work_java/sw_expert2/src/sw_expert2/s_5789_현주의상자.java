package sw_expert2;

import java.util.Scanner;

public class s_5789_현주의상자 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] arr = new int[n];
			int val = 1;
			
			for(int i=0; i<q; i++) {
				int ii = sc.nextInt();
				int r = sc.nextInt();
				
				for(int j=ii-1; j<r; j++) {
					arr[j] =val;
				}
				val++;	
			}
			
			System.out.print("#"+tc+" ");
			for(int i =0; i<n; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}
