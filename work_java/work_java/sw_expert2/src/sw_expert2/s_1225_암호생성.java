package sw_expert2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s_1225_암호생성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int ttc = sc.nextInt();

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i <= 8; i++) {
				queue.add(sc.nextInt());
			}

			boolean ck = true;
			while (ck) {
				for (int i = 1; i <= 5; i++) {
					int val = queue.poll();
					if (val - i <= 0) {
						ck = false;
						queue.add(0);
						break;
					} else {
						val -= i;
						queue.add(val);
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}
