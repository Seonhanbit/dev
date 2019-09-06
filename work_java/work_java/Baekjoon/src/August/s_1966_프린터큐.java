package August;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s_1966_프린터큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int ttc = sc.nextInt();
			int val = sc.nextInt();
			ArrayList<Integer> cntt = new ArrayList<Integer>();

			for (int i = 0; i < ttc; i++) {
				if (i == val) {
					cntt.add(1);
				} else {
					cntt.add(0);
				}
			}

			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < ttc; i++) {
				list.add(sc.nextInt());
			}
//			Queue<Integer> queue = new LinkedList<>();
//			for (int i = 0; i < ttc; i++) {
//				queue.add(sc.nextInt());
//			}

			int cnt = 0;
			int tmp = 0;
			boolean ck = true;
			if (list.size() == 1) {
				System.out.println("----" + cntt.get(0));
			} else {
				while (ck) {
					for (int j = 0; j < ttc; j++) {
						int i = 0;
						if (list.get(i) > list.get(i + 1)) {
//							tmp = list.get(i);
							list.remove(i);
							cnt++;
//							list.add(tmp);

							if (cntt.get(i) == 1) {
//								cntt.add(1);
								System.out.println(cnt);
								ck = false;
								break;
							} else if (cntt.get(i) == 0) {
								cntt.remove(i);
//								cntt.add(0);
							}
						} else {
//							if (cntt.get(i) == 1) {
//								System.out.println(cnt);
//								break;
//							}
							tmp = list.get(i);
							list.remove(i);
							list.add(tmp);

							if (cntt.get(i) == 1) {
								cntt.add(1);
								cntt.remove(i);
							} else if (cntt.get(i) == 0) {
								cntt.remove(i);
								cntt.add(0);
							}
						}
					}
				}
			}
		}
	}
}
