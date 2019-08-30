package sw_expert2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class s_1228_암호문1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();

			for (int i = 0; i < len; i++) {
				list.add(sc.nextInt());
			}
			int len2 = sc.nextInt();
			for (int i = 0; i < len2; i++) {
				sc.next();
				int position = sc.nextInt();
				int num = sc.nextInt();
				for (int j = 0; j < num; j++) {
					list.add(position++, sc.nextInt());
				}
			}
			System.out.print("#" + tc+" ");

			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}
