import java.io.*;
import java.util.*;

public class Baek_2665 {
	static int N, res;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	static class XY implements Comparable<XY> {
		int x;
		int y;
		int cnt;

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(XY o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		//dfs(0, 0, 0);
		bw.append(res + "\n");
		bw.flush();
		bw.close();
	}

	static void bfs() {
		PriorityQueue<XY> queue = new PriorityQueue<>();
		queue.add(new XY(0, 0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			if (tmp.x == N - 1 && tmp.y == N - 1) {
				res = Math.min(res, tmp.cnt);
				//System.out.println(queue.toString());
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny, tmp.cnt));
				}
				if (arr[nx][ny] == 0) {
					queue.add(new XY(nx, ny, tmp.cnt+1));
					visited[nx][ny] = true;
				}
			}
		}
	}

	static void dfs(int x, int y, int cnt) {
		if (cnt > res)
			return;
		if (x == N - 1 && y == N - 1) {
			if (cnt < res)
				res = cnt;
			return;
		}
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if (!range(nx, ny))
				continue;
			if (visited[nx][ny])
				continue;
			if (arr[nx][ny] == 1) {
				dfs(nx, ny, cnt);
				visited[nx][ny] = false;
			}
			if (arr[nx][ny] == 0) {
				dfs(nx, ny, cnt + 1);
				visited[nx][ny] = false;
			}
		}
	}
}
