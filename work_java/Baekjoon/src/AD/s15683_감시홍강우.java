package AD;

import java.io.*;
import java.util.*;

public class s15683_감시홍강우 {
	static class Camera {
		int r, c, type;

		public Camera(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

	static int R, C, cameraListSize, res;
	static int[][] map;
	static ArrayList<Camera> cameraList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cameraList = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (5 >= map[r][c] && map[r][c] >= 1)
					cameraList.add(new Camera(r, c, map[r][c] - 1));
			}
		}
		cameraListSize = cameraList.size();
		res = Integer.MAX_VALUE;
		dfs(new int[cameraListSize], 0);
		System.out.println(res);
	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][][] TYPE = {
			{ { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } },
			{ { 1, 0, 1, 0 }, { 0, 1, 0, 1 }								 },
			{ { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } },
			{ { 1, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 } },
			{ { 1, 1, 1, 1 }												 }};

	static void dfs(int[] sel, int sel_idx) {
		if (sel_idx == cameraListSize) {
			boolean[][] visited = new boolean[R][C];
			for (int i = 0; i < cameraListSize; i++) {
				int r = cameraList.get(i).r, c = cameraList.get(i).c, type = cameraList.get(i).type;
				for (int d = 0; d < 4; d++)
					if (TYPE[type][sel[i]][d] == 1) {
						int nr = r, nc = c;
						while (true) {
							nr += dr[d];
							nc += dc[d];
							if (nr >= R || nc >= C || 0 > nr || 0 > nc || map[nr][nc] == 6)
								break;
							visited[nr][nc] = true;
						}
					}
			}
			int cnt = 0;
			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					if (map[r][c] == 0 && !visited[r][c])
						cnt++;
			if (res > cnt)
				res = cnt;
			return;
		}
		for (int d = 0; d < TYPE[cameraList.get(sel_idx).type].length; d++) {
			sel[sel_idx] = d;
			dfs(sel, sel_idx + 1);
		}
	}
}
