package September;

import java.util.Scanner;

public class s_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mok = N / 5;
		int na = 0;
		int sum = 0;
		for (int i = mok; i>=0; i--) {
			sum = i;
			na = N - (i * 5);
			if (na % 3 == 0) {
				mok = na / 3;
				sum += mok;
				System.out.println(sum);
				break;
			} else if (i == 0) {
				System.out.println(-1);
				break;
			}
		}
	}

}
