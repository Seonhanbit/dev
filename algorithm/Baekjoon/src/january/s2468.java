package january;

import java.io.*;
import java.util.*;

public class s2468 {
	static int N, max;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int height = 0;
		max = 1; // 아무 지역도 물에 잠기지 않을 수 있다.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(arr[i][j], height);
			}
		}

		for (int k = 1; k <= height; k++) {
			visited = new boolean[N][N];
			int sum = 0;
			/*
			 * for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) { if (arr[i][j] - k
			 * < 0) { visited[i][j] = true; } } }
			 */

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && arr[i][j] > k) {
						bfs(i, j, k);
						sum++;
					}
				}
			}
			max = Math.max(sum, max);
		}

		bw.append(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	public static void bfs(int x, int y, int k) {
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(x, y));
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			visited[tmp.x][tmp.y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (arr[nx][ny] > k) {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny));
				}
			}

		}
	}

}
