package sw_expert2;

import java.util.Scanner;

public class s_1940_가랏rc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int speed = 0;
			int dis = 0;

			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				if (a != 0) {
					int b = sc.nextInt();
					if (a == 1) {
						speed += b;
						dis += speed;
					}
					if (a == 2) {
						if (speed < b) {
							speed = 0;
						} else {
							speed -= b;
							dis += speed;
						}
					}
				}
				if (a == 0) {
					dis += speed;
				}
			}

			System.out.println("#" + tc + " " + dis);

		}

	}
}
