package DFSBFS;

import java.io.*;
import java.util.*;

public class s_4963_섬의개수 {
	static int w, h, res;
	static int[][] arr;
	// static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

	static boolean range(int x, int y) {
		if (x >= 0 && x < h && y >= 0 && y < w)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			res = 0;
			arr = new int[h][w];
			// visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						dfs(i, j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}

	static void dfs(int x, int y) {
		// visited[x][y] = true;
		arr[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (!range(nx, ny))
				continue;
			/*
			 * if (visited[nx][ny]) continue;
			 */
			if (arr[nx][ny] == 0)
				continue;
			// visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}

}
