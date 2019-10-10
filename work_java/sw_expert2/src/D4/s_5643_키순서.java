package D4;

import java.io.*;
import java.util.*;

public class s_5643_키순서 {
	static int N, M, res;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];
			res = 0;
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			for (int i = 1; i < N + 1; i++) {
				visited = new boolean[N + 1];
				search(i);
			}
			System.out.println("#" + tc + " " + res);
		}
	}

	static void search(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		queue.add(x);
		visited[x] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 1; i < N + 1; i++) {
				if (arr[tmp][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}

		// 역방향
		queue.add(x);
		visited[x] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 1; i < N + 1; i++) {
				if (arr[i][tmp] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}

		if (cnt == N - 1)
			res++;
	}

}
