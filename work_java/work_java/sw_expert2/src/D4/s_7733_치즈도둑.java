package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_7733_치즈도둑 {
	static int N;
	static int[][] arr;
	static boolean[][] ck_arr;
	static int res;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int kk;

	public static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}

	static class XY {
		int x;
		int y;
		int day;

		XY(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			int max_day = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] > max_day)
						max_day = arr[i][j];
				}
			}
			res = 0;
			for (int k = 0; k <= max_day; k++) {
				ck_arr = new boolean[N][N];
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] > k && !ck_arr[i][j]) {
							bfs(i, j, k);
							cnt++;
						}
					}
				}
				//res = Math.max(res,cnt);
				if (cnt > res)
					res = cnt;
			}
			System.out.println("#" + tc + " " + res);
		}
	}

	public static void bfs(int x, int y, int k) {
		Queue<XY> queue = new LinkedList<XY>();
		queue.add(new XY(x, y, k));
		ck_arr[x][y] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] <= k)
					continue;
				if (ck_arr[nx][ny])
					continue;
				queue.add(new XY(nx, ny, k));
				ck_arr[nx][ny] = true;
			}
		}
	}
	
	
	
}
