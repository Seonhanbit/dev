package jungol;

import java.io.*;
import java.util.*;

public class s1113_119구급대강사님 {
	static int[][] arr;
	static int[][] visited;
	static int M, N, m, n, res;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static PriorityQueue<XY> queue;

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class XY implements Comparable<XY> {
		int x, y, dic, cnt;

		XY(int x, int y, int dic, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dic = dic;
		}

		@Override
		public int compareTo(XY o) {
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", dic=" + dic + ", cnt=" + cnt + "]";
		}

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
		visited = new int[N][M];
		res = Integer.MAX_VALUE;
		queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], 987654321);
		}
		visited[0][0] = 0;
		queue.add(new XY(0, 0, 1, 0));
		queue.add(new XY(0, 0, 3, 0));

		while (!queue.isEmpty()) {
			XY xy = queue.poll();
			if (xy.x == m && xy.y == n) {
				bw.write(xy.cnt + "\n");
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = xy.x + dx[i], ny = xy.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] == 1 && visited[nx][ny] > xy.cnt) {
					int cnt = xy.cnt;
					if (i != xy.dic)
						cnt++;
					visited[nx][ny] = xy.cnt;
					queue.add(new XY(nx, ny, i, cnt));
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
