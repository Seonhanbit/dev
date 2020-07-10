package new_;

import java.io.*;
import java.util.*;

// 안전영역
public class baek_2468 {
	static int N, max, val;
	static int[][] arr;
	static boolean[][] ck;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<XY> queue;

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		max = 0;
		val = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > max)
					max = arr[i][j];
			}
		}
		for (int k = 1; k <= max; k++) {
			int cnt = 0;
			ck = new boolean[N][N];
			// 물에 잠기면 true 표시
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] - k <= 0)
						ck[i][j] = true;
				}
			}
			// bfs 돌기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!ck[i][j]) {
						queue = new LinkedList<>();
						queue.add(new XY(i, j));
						bfs();
						cnt++;
					}
				}
			}

			if (cnt > val)
				val = cnt;
		}

		bw.write(String.valueOf(val));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			ck[tmp.x][tmp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (ck[nx][ny])
					continue;
				queue.add(new XY(nx, ny));
			}
		}
	}

}
