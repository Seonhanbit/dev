package preTest;

import java.io.*;
import java.util.*;

public class s_1949_등산로조성 {
	static int T, N, K, res;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			res = Integer.MIN_VALUE;
			visited = new boolean[N][N];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > max)
						max = arr[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max) {
						visited = new boolean[N][N];
						dfs(i, j, 1, false);
					}
				}
			}

			bw.append("#" + String.valueOf(tc) + " " + String.valueOf(res) + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void dfs(int x, int y, int cnt, boolean isUse) {
		visited[x][y] = true;
		res = Math.max(cnt, res);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (!range(nx, ny))
				continue;
			if (visited[nx][ny])
				continue;
			if (arr[nx][ny] < arr[x][y]) {
				dfs(nx, ny, cnt + 1, isUse);
			} else {
				if (!isUse && arr[nx][ny] - K < arr[x][y]) {
					int tmp = arr[nx][ny];
					arr[nx][ny] = arr[x][y] - 1;
					dfs(nx, ny, cnt + 1, true);
					arr[nx][ny] = tmp;
				}
			}
		}
		visited[x][y] = false;
	}

	public static void print(int[][] map) {
		for (int[] a : map) {
			System.out.println(Arrays.toString(a));
		}
	}
}
