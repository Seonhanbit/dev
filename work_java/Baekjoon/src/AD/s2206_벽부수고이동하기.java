package AD;

import java.io.*;
import java.util.*;

public class s2206_벽부수고이동하기 {
	static int N, M, res;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static PriorityQueue<XY> queue;

	static class XY implements Comparable<XY> {
		int x;
		int y;
		int cnt;
		int ck;

		XY(int x, int y, int cnt, int ck) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.ck = ck;
		}

		@Override
		public int compareTo(XY o) {
			return this.cnt - o.cnt;
		}

	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][2];
		queue = new PriorityQueue<>();
		res = 987654321;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		bfs();
		if (res == 987654321)
			bw.append("-1");
		else
			bw.append(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		queue.add(new XY(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			if (tmp.x == N - 1 && tmp.y == M - 1) {
				res = Math.min(res, tmp.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] == 0) {
					if (visited[nx][ny][tmp.ck])
						continue;
					visited[nx][ny][tmp.ck] = true;
					queue.add(new XY(nx, ny, tmp.cnt + 1, tmp.ck));
				}
				if (arr[nx][ny] == 1 && tmp.ck == 0) {
					if (visited[nx][ny][1])
						continue;
					//System.out.println(nx + "," + ny);
					visited[nx][ny][1] = true;
					queue.add(new XY(nx, ny, tmp.cnt + 1, tmp.ck + 1));
				}
			}
		}
	}
}
