package sw_expert;

import java.util.Scanner;

public class 연습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dx = { 0, -1, 1, 0, 0 };
		int[] dy = { 0, 0, 0, -1, 1 };

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			int bug = sc.nextInt();
			int result = bug;
			boolean chk = true;
			for (int i = 0; i < bug; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int dir = sc.nextInt();

				row += dx[dir] * 6;
				col += dy[dir] * 6;

				if (row < 0 || row >= n || col < 0 || col >= n) {
					result--;
					chk = false;
					continue;
				}
				if (map[row][col] == 1) {
					result--;
					chk = false;
					continue;
				}
				if (chk == true)
					map[row][col] = 1;
			}
			System.out.println("#"+tc+" "+result);
		}

	}
}