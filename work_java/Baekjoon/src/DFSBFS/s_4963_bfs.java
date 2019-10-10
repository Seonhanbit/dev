package DFSBFS;

import java.io.*;
import java.util.*;

public class s_4963_bfs {
	static int w, h, res;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

	static boolean range(int x, int y) {
		if (x >= 0 && x < h && y >= 0 && y < w)
			return true;
		else
			return false;
	}

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
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
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}

	static void bfs(int i, int j) {
		Queue<XY> queue= new LinkedList<>();
		queue.add(new XY(i,j));
		while(!queue.isEmpty()) {
			XY tmp = queue.poll();
			visited[tmp.x][tmp.y] = true;
			for (int k = 0; k < 8; k++) {
				int nx = tmp.x+dx[k], ny = tmp.y+dy[k];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (arr[nx][ny] == 0)
					continue;
				visited[nx][ny] = true;
				queue.add(new XY(nx,ny));
			}
		}
	}

}
