package October;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_2630_색종이만들기 {
	static int N, white, blue;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		white = 0;
		blue = 0;
		int all = 0;
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				all += arr[i][j] == 1 ? 1 : 0;
			}
		}
		if (all == N * N) {
			System.out.println(1);
			System.out.println(0);
		} else if (all==0) {
			System.out.println(0);
			System.out.println(1);
		} else {
			dfs_blue(0, 0, N);
			dfs_white(0, 0, N);
			System.out.println(white);
			System.out.println(blue);
		}
	}

	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	static void dfs_blue(int R, int C, int n) {
		if (n == 1)
			return;
		int nn = n / 2;

		for (int i = 0; i < 4; i++) {
			int sr = R + (nn * dr[i]);
			int sc = C + (nn * dc[i]);
			boolean bk = false;

			out: for (int r = sr; r < sr + nn; r++) {
				for (int c = sc; c < sc + nn; c++) {
					if (arr[r][c] == 0) {
						bk = true;
						break out;
					}
				}
			}
			if (bk)
				dfs_blue(sr, sc, n / 2);
			else
				blue++;
		}
	}

	static void dfs_white(int R, int C, int n) {
		if (n == 1)
			return;
		int nn = n / 2;

		for (int i = 0; i < 4; i++) {
			int sr = R + (nn * dr[i]);
			int sc = C + (nn * dc[i]);
			boolean bk = false;

			out: for (int r = sr; r < sr + nn; r++) {
				for (int c = sc; c < sc + nn; c++) {
					if (arr[r][c] == 1) {
						bk = true;
						break out;
					}
				}
			}
			if (bk)
				dfs_white(sr, sc, n / 2);
			else
				white++;
		}
	}
}
