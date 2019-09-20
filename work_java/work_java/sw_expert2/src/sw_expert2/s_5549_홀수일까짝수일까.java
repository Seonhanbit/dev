package sw_expert2;

import java.util.Scanner;

public class s_5549_홀수일까짝수일까 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String n =sc.next();
			int a = 0;
			for(int i=0; i<n.length(); i++) {
				a = n.charAt(n.length()-1);
			}
			System.out.print("#"+tc+ " ");
			if(a%2==0) {
				System.out.println("Even");
			}else
				System.out.println("Odd");
		}
	}
}
