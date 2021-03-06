package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_7576_토마토 {
	static int M;
	static int N;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res;
	static Queue<XY> queue = null;
	static XY result;

	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

	static class XY {
		int x;
		int y;
		int cnt;

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		res = 0;
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					flag = false;
			}
		}
		if (!flag) {
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(res);
		} else {
			System.out.println(0);
		}
	}

	public static void bfs() {
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					queue.add(new XY(i, j, 0));
				}
			}
		}
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			if(tmp.cnt>res)
				res = tmp.cnt;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] == -1 || arr[nx][ny] == 1)
					continue;
				queue.add(new XY(nx, ny, tmp.cnt + 1));
				arr[nx][ny]=1;
			}
		}
	}
}
