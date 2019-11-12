package AD;

import java.io.*;
import java.util.*;

public class s1600_말이되고픈원숭이 {
	static int K, N, M, res;
	static int[][] arr;
	static boolean[][][] visited;
	static Queue<XY> queue;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static class XY {
		int x;
		int y;
		int cnt;
		int k;

		XY(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][K + 1];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 987654321;
		bfs();
		if (res == 987654321) {
			bw.append("-1");
		} else
			bw.append(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		queue.add(new XY(0, 0, 0, K));
		visited[0][0][K] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			if (tmp.x == N - 1 && tmp.y == M - 1) {
				// System.out.println(tmp.cnt);
				res = Math.min(res, tmp.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny][tmp.k])
					continue;
				if (arr[nx][ny] == 1)
					continue;
				// System.out.println("원숭이 : " + nx + "," + ny);
				visited[nx][ny][tmp.k] = true;
				queue.add(new XY(nx, ny, tmp.cnt + 1, tmp.k));
			}
			if (tmp.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = tmp.x + hx[i], ny = tmp.y + hy[i];
					if (!range(nx, ny))
						continue;
					if (visited[nx][ny][tmp.k - 1]) //기회를 소진해서 뛴적이 있는지를 확인
						continue;
					if (arr[nx][ny] == 1)
						continue;
					// System.out.println("말 : " + nx + "," + ny);
					visited[nx][ny][tmp.k - 1] = true;
					queue.add(new XY(nx, ny, tmp.cnt + 1, tmp.k - 1));
				}
			}
		}
	}
}
