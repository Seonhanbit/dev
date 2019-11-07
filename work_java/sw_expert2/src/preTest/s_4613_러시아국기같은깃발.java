package preTest;

import java.io.*;
import java.util.*;

public class s_4613_러시아국기같은깃발 {
	static int T, N, M, max;
	static char[][] arr;
	static int[][] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				arr[i] = str.toCharArray();
			}
			int red = 0;
			int white = 0;
			int blue = 0;

			color = new int[N][3];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				red = 0;
				white = 0;
				blue = 0;
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 'W')
						white++;
					if (arr[i][j] == 'R')
						red++;
					if (arr[i][j] == 'B')
						blue++;
				}
				color[i][0] = white;
				color[i][1] = blue;
				color[i][2] = red;
			}
			dfs(0, 0, 0);
/*			for (int i = 1; i < N - 1; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(color[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println(max);*/
			bw.append("#").append(String.valueOf(tc)).append(" ").append((N * M - max) + "\n");
			bw.flush();
		}
		bw.close();
	}

	// 현재 위치 컬러랑 행(바꿔주기위해서)이랑 행을 지날때마다 더할 cnt
	// 완전 탐색하기 WWWW, WBBB, WBBR, WBRR ...
	static void dfs(int col, int x, int cnt) {
		if (x == N&& col == 3) {
			if (cnt > max)
				max = cnt;
			return;
		}
		if (x == N)
			return;
		if (col == 3)
			return;
		
		dfs(col+1, x+1, cnt+color[x][col]);
		dfs(col, x+1, cnt+color[x][col]);
	}

}
