package march;

import java.io.*;
import java.util.*;

public class s2644_촌수계산 {
	static int N, res, num1, num2, n, max;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		arr = new int[101][101];
		visited = new boolean[N + 1];
		res = Integer.MAX_VALUE;
		max = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x >= y) {
				max = Math.max(max, x);
			} else
				max = Math.max(max, y);
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		for (int i = 1; i <= max; i++) {
			if (arr[num1][i] == 1 && !visited[i]) {
				perm(i, 1);
			}
		}
		res = res == Integer.MAX_VALUE ? -1 : res;
		bw.append(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	public static void perm(int y, int cnt) {
		if (y == num2) {
			res = Math.min(res, cnt);
			return;
		}
		for (int i = 1; i <= max; i++) {
			if (arr[i][y] == 1 && !visited[i]) {
				visited[i] = true;
				perm(i, cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void bfs() {
		int[] visit = new int[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num1);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= max; i++) {
				if (arr[i][v] == 1 && visit[i] == 0) {
					queue.add(i);
					//방문체크, num1로 부터 갈 수 있는 거리(뎁스 저장)
					visit[i] = visit[v] + 1;
				}
			}
		}
		System.out.println(visit[num2]==0?-1:visit[num2]);
	}

}
