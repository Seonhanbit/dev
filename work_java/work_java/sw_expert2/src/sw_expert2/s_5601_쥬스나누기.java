package sw_expert2;

import java.util.Scanner;

public class s_5601_쥬스나누기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int val = sc.nextInt();
			

			
			System.out.print("#" + tc + " ");
			for(int i =0; i<val; i++) {
				System.out.print(1 + "/" + val + " ");	
			}
			System.out.println();
		}

	}
}
