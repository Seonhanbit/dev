package jungol;

import java.io.*;
import java.util.*;

public class s1113_119구급대 {
	static int[][] arr;
	static boolean[][] visited;
	static int M, N, m, n, res;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		res = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		// 방향은 처음에 모르니까 -1로 해주기
		dfs(0, 0, -1, 0);
		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y, int dic, int cnt) {
		visited[x][y] = true;
		if (cnt > res)
			return;
		if (x == m && y == n) {
			//System.out.println(cnt);
			res = Math.min(res, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			//System.out.println(nx + "," + ny);
			if (!range(nx, ny))
				continue;
			if (arr[nx][ny] != 1)
				continue;
			if (visited[nx][ny])
				continue;

			if (dic == -1 || dic == i) {
				dfs(nx, ny, i, cnt);
				visited[nx][ny] = false;
			}
			if (dic != i) {
				dfs(nx, ny, i, cnt + 1);
				visited[nx][ny] = false;
			}
		}

	}
}
