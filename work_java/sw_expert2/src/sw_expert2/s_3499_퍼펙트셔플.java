package sw_expert2;

import java.util.ArrayList;
import java.util.Scanner;

public class s_3499_퍼펙트셔플 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			String[] list = new String[n];

			for (int i = 0; i < n; i++) {
				list[i] = sc.next();
			}

			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();

			System.out.print("#" + tc + " ");
			int val = 0;
			if (n % 2 == 0) {
				val = n / 2;
				for (int i = 0; i < val; i++) {
					list1.add(i, list[i]);
				}
				for (int i = val; i < n; i++) {
					list2.add(list[i]);
				}
				for (int i = 0; i < val; i++) {
					System.out.print(list1.get(i) + " ");
					System.out.print(list2.get(i) + " ");
				}
				System.out.println();
			} else {
				val = (n / 2) + 1;
				for (int i = 0; i < val; i++) {
					list1.add(i, list[i]);
				}
				for (int i = val; i < n; i++) {
					list2.add(list[i]);
				}
				for (int i = 0; i < val - 1; i++) {
					System.out.print(list1.get(i) + " ");
					System.out.print(list2.get(i) + " ");
				}
				System.out.print(list1.get(val-1));
				System.out.println();
			}

		}
	}
}
