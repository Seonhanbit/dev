package Sub_12;

import java.io.*;
import java.util.*;

public class b2573_빙산 {
	static int N, M, res;
	static int[][] arr;
	static boolean[][] visited;
	static List<XY> list;
	static Queue<XY> queue = new LinkedList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	static class XY {
		int x;
		int y;
		int k;

		XY(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0)
					list.add(new XY(i, j, 0));
			}
		}

		for (int loop = 0; list.size() > 0; loop++) {
			visited = new boolean[N][M];
			int re = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 0 && !visited[i][j]) {
						bfs(i, j);
						re++;
					}
				}
			}

			if (re >= 2) {
				bw.append(String.valueOf(loop));
				bw.flush();
				bw.close();
				return;
			}

			for (int i = 0; i < list.size(); i++) {
				XY p = list.get(i);
				for (int d = 0; d < 4; d++) {
					int nr = p.x + dx[d], nc = p.y + dy[d];
					if (arr[nr][nc] == 0)
						p.k++;
				}
			}

			ArrayList<Integer> del_list = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				XY p = list.get(i);
				arr[p.x][p.y] -= p.k;
				if (arr[p.x][p.y] <= 0) { // 빙하깎기
					arr[p.x][p.y] = 0;
					del_list.add(i);
				}
				p.k = 0;
			}
			
			Collections.sort(del_list); // 리스트는 뒤에서부터 삭제해줘야지 안꼬임
			for (int i = del_list.size() - 1; i >= 0; i--) {
				int del_idx = del_list.get(i);
				list.remove(del_idx);
			}

		}

		bw.append("0");
		bw.flush();
		bw.close();
	}

	static void bfs(int r, int c) {
		queue.add(new XY(r, c, 0));
		visited[r][c] = true; // 방문체크
		while (!queue.isEmpty()) { // 연결된 것이 없어질때까지 도는거야
			XY now = queue.poll(); // 큐 먼저 빼고
			for (int d = 0; d < 4; d++) { // 네바퀴를 돌고
				int nr = now.x + dx[d], nc = now.y + dy[d];
				if (arr[nr][nc] == 0)
					continue;
				if (visited[nr][nc])
					continue;
				queue.add(new XY(nr, nc, 0));
				visited[nr][nc] = true;
			}
		}
	}

}
