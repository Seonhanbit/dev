package Sub_12;

import java.io.*;
import java.util.*;

public class b7576_토마토 {
	static int N, M, cnt, chk;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<XY> queue;

	static class XY {
		int x;
		int y;
		int dist;

		XY(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new boolean[M][N];
		queue = new LinkedList<>();

		chk = M * N;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					visited[i][j] = true;
					queue.add(new XY(i, j, 0));
					chk--;
				}
				if (arr[i][j] == -1)
					chk--;
			}
		}

		bfs();

		if (chk==0) {
			bw.append(String.valueOf(cnt));
		} else
			bw.append("-1");

		bw.flush();
		bw.close();

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			cnt = tmp.dist;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] == 0) {
					queue.add(new XY(nx, ny, tmp.dist + 1));
					arr[nx][ny] = 1;
					chk--;
				}
			}
		}
	}

	public static boolean check() {
		boolean flag = true;
		loof: for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					flag = false;
					break loof;
				}
			}
		}
		return flag;
	}
}
