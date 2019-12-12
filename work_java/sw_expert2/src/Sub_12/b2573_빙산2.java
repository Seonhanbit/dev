package Sub_12;

import java.io.*;
import java.util.*;

public class b2573_빙산2 {
	static class H {
		int r, c;

		public H(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int R, C;
	static ArrayList<H> list = new ArrayList<>();
	static int[][] map, del;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		del = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		for (int year = 0; true; year++) {
			int group = 0;
			visited = new boolean[R][C];
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (map[r][c] > 0 && !visited[r][c]) {
						bfs_ice(new H(r, c));
						if (++group >= 2) {
							System.out.println(year);
							return;
						}
					}
			if (group == 0) {
				System.out.println(0);
				return;
			}
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (del[r][c] > 0) {
						map[r][c] -= del[r][c];
						if (0 > map[r][c])
							map[r][c] = 0;
						del[r][c] = 0;
					}
		}
	}

	static Queue<H> q = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs_ice(H go) {
		visited[go.r][go.c] = true;
		q.add(go);
		while (!q.isEmpty()) {
			H now = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d], nc = now.c + dc[d];
				if (nr >= R || nc >= C || 0 > nr || 0 > nc || visited[nr][nc])
					continue;
				if (map[nr][nc] == 0)
					del[now.r][now.c]++;
				else {
					visited[nr][nc] = true;
					q.add(new H(nr, nc));
				}
			}
		}
	}

}
