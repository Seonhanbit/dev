package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s_4179_불 {
	static int R;
	static int C;
	static char[][] arr;
	static int a, b;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res;
	static boolean flag;
	static Queue<pair> queue;

	static boolean range(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C)
			return true;
		else
			return false;
	}

	static class pair {
		int x;
		int y;
		int cnt;

		pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		queue = new LinkedList<>();
		res = 0;
		flag = false;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'J') {
					a = i;
					b = j;
				}
				if (arr[i][j] == 'F') {
					queue.add(new pair(i, j, 0));
				}
			}
		}

		bfs(a, b);
		if (flag)
			System.out.println(res);
		else
			System.out.println("IMPOSSIBLE");

	}

	static void bfs(int a, int b) {
		queue.add(new pair(a, b, 1));
		while (!queue.isEmpty()) {
			pair tmp = queue.poll();
			if (arr[tmp.x][tmp.y] == 'F') {
				for (int i = 0; i < 4; i++) {
					int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
					if (!range(nx, ny) || arr[nx][ny] == '#' || arr[nx][ny] == 'F')
						continue;
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = 'F';
						queue.add(new pair(nx, ny, tmp.cnt));
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
					if (!range(nx, ny)) {
						res = tmp.cnt;
						flag = true;
						return;
					} else {
						if (arr[nx][ny] == '#' || arr[nx][ny] == 'F')
							continue;
						if (arr[nx][ny] == '.') {
							arr[nx][ny] = 'J';
							queue.add(new pair(nx, ny, tmp.cnt + 1));
						}
					}
				}
			}
		}
	}
}
