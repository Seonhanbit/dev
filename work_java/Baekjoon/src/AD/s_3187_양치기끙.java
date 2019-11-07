package AD;

import java.io.*;
import java.util.*;

public class s_3187_양치기끙 {
	static int R, C, sheep, wolf, tmpsheep, tmpwolf;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class XY {
		int x, y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'v')
					wolf++;
				if (arr[i][j] == 'k')
					sheep++;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && arr[i][j] == 'v') {
					tmpsheep = 0;
					tmpwolf = 0;
					bfs(i, j);
					if (tmpsheep <= tmpwolf) {
						sheep -= tmpsheep;
					} else if (tmpsheep > tmpwolf) {
						wolf -= tmpwolf;
					}
				}
			}
		}
		bw.append(sheep + " " + wolf + "\n");
		bw.flush();
		bw.close();
	}

	public static void bfs(int x, int y) {
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(x, y));
		tmpwolf = 1;
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (arr[nx][ny] == '#')
					continue;
				if (arr[nx][ny] == 'v') {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny));
					tmpwolf++;
				}
				if (arr[nx][ny] == 'k') {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny));
					tmpsheep++;
				}
				if (arr[nx][ny] == '.') {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny));
				}
			}
		}
	}
}
