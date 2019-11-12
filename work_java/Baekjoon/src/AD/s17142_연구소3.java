package AD;

import java.io.*;
import java.util.*;

public class s17142_연구소3 {
	static int N, M, result, ncnt;
	static int[][] arr;
	static ArrayList<XY> list;
	static Queue<XY> queue;
	static boolean[][] visited;
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

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		queue = new LinkedList<>();
		arr = new int[N][N];
		visited = new boolean[N][N];
		result = 987654321;
		ncnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					list.add(new XY(i, j)); // 바이러스 리스트
				if (arr[i][j] == 0)
					ncnt++;
			}
		}

		combi(0, 0, new XY[M]);
		if (ncnt == 0) {
			bw.append("0");
		} else if (result != 987654321) {
			bw.append(String.valueOf(result));
		} else
			bw.append("-1");

		bw.flush();
		bw.close();
	}

	static void combi(int c, int n, XY[] res) {
		if (c == res.length) {
			visited = new boolean[N][N];
			// 바이러스 퍼진거 tmp에 숫자 넣어줄거라서...배열 복사해줌
			int[][] tmp = new int[N][N];
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}
			// 우선 조합으로 뽑힌거 큐에 넣어줌
			// 혹시 모르니까 방문도 해줌..
			for (int i = 0; i < res.length; i++) {
				queue.add(res[i]);
			}
			bfs(tmp);

			queue.clear();
			return;
		}
		if (n == list.size())
			return;
		res[c] = list.get(n);
		combi(c + 1, n + 1, res);
		combi(c, n + 1, res);
	}

	static void bfs(int[][] tmparr) {
		// cnt 확산 시간
		int cnt = 0;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			visited[tmp.x][tmp.y] = true;
			cnt = tmp.cnt;

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (tmparr[nx][ny] == 1)
					continue;
				if (tmparr[nx][ny] == 2 || tmparr[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.add(new XY(nx, ny, tmp.cnt + 1));
					if (tmparr[nx][ny] == 0)
						tmparr[nx][ny] = tmp.cnt + 1;
					else {
						if (tmparr[nx][ny] > tmp.cnt + 1)
							tmparr[nx][ny] = tmp.cnt + 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(tmparr[i][j]+" ");
			}System.out.println();
		}
		System.out.println("===========");
		int temp = 0;
		if (ck(tmparr)) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (tmparr[i][j] > temp)
						temp = tmparr[i][j];
					if(temp>result)
						return;
				}
			}
			result = Math.min(result, temp);
		}
	}

	static boolean ck(int[][] visited) {
		boolean ck = true;
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {
					ck = false;
					break loop;
				}
			}
		}
		return ck;
	}
}
