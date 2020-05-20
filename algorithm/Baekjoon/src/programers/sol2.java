package programers;

import java.io.*;
import java.util.*;

public class sol2 {
	static int[][] office;
	static int r, c, N;
	static String[] move;
	// 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		r = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		int cnt = solution();

		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

	public static int solution() {
		N = office.length;
		int answer = 0;
		// 0 북쪽, 1 동쪽, 2 남쪽, 3 서쪽
		int dic = 0;
		answer += office[r][c];
		office[r][c] = 0;
		for (int k = 0; k < move.length; k++) {
			String str = move[k];
			System.out.println(r + "," + c);
			if (str.equals("go")) {
				int nr = r + dx[dic], nc = c + dy[dic];
				if (!range(nr, nc))
					continue;
				if (office[nr][nc] == -1)
					continue;
				r = nr;
				c = nc;
				answer += office[r][c];
				office[r][c] = 0;
			} else if (str.equals("right")) {
				dic += 1;
				if (dic > 3) {
					dic = 0;
				}
			} else if (str.equals("left")) {
				dic -= 1;
				if (dic < 0) {
					dic = 3;
				}
			}
		}
		return answer;
	}

}
