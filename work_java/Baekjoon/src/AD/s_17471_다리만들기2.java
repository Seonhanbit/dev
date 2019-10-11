package AD;

import java.io.*;
import java.util.*;

public class s_17471_다리만들기2 {
	static int N, M;
	static int[][] arr;
	static int[][] islands;
	static boolean[][] visited;
	// 상,하,좌,우 0 1 2 3
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

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

	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, cnt + 1);
					cnt++;
				}
			}
		}
		islands = new int[cnt + 1][cnt + 1];

		for (int[] row : islands) {
			Arrays.fill(row, 100);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					bfs2(i, j, 0);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		for (int i = 1; i < islands.length; i++) {
			for (int j = 1; j < islands.length; j++) {
				System.out.print(islands[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void bfs(int x, int y, int cnt) {
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(x, y, cnt));
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			arr[tmp.x][tmp.y] = tmp.cnt;
			visited[tmp.x][tmp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (arr[nx][ny] == 0)
					continue;
				arr[nx][ny] = cnt;
				visited[nx][ny] = true;
				queue.add(new XY(nx, ny, cnt));
			}
		}
	}

	static void bfs2(int x, int y, int cnt) {
		Queue<XY> queue = new LinkedList<>();
		int number = arr[x][y];
		//for문을 밖에 놔주면 한방향으로만 진행
		for (int i = 0; i < 4; i++) {
			queue.add(new XY(x, y, cnt));
			while (!queue.isEmpty()) {
				XY tmp = queue.poll();
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] != 0) {
					if (tmp.cnt < islands[number][arr[nx][ny]] && tmp.cnt >= 2) {
						islands[number][arr[nx][ny]] = tmp.cnt;
						islands[arr[nx][ny]][number] = tmp.cnt;
					}
					continue;
				}
				queue.add(new XY(nx, ny, tmp.cnt+1));
			}
		}
	}

}
