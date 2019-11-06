package jungol;

import java.io.*;
import java.util.*;

public class s1113_119구급대bfs {
	static int[][] arr;
	static boolean[][] visited;
	static int M, N, m, n, res;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static PriorityQueue<XY> queue;

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class XY implements Comparable<XY> {
		int x, y, dic, cnt;

		XY(int x, int y, int dic, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dic = dic;
		}

		@Override
		public int compareTo(XY o) {
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", dic=" + dic + ", cnt=" + cnt + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		res = Integer.MAX_VALUE;
		queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs();
		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}
	// bfs 꺾은 횟수가 작은 애(우선순위 큐를 써서 꺾은 친구가 적은 쪽이 먼저 나오게 하기)
	public static void bfs() {
		queue.add(new XY(0,0,0,0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			if (tmp.x == m && tmp.y == n) {
				System.out.println(queue.toString());
				//0,0에서 시작할때 양옆으로 이동 시 
				//방향을 바꾼게 아닌데, cnt가 +1되니까 -1해주기
				res = tmp.cnt-1;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] != 1)
					continue;
				if (visited[nx][ny])
					continue;
				if (tmp.dic == i) {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny, i, tmp.cnt));
				}
				if (tmp.dic != i) {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny, i, tmp.cnt + 1));
				}
			}
		}
	}
}
