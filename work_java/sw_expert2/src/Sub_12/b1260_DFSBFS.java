package Sub_12;

import java.io.*;
import java.util.*;

public class b1260_DFSBFS {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		dfs(V);
		System.out.println();
		visited = new boolean[N + 1];
		bfs();

	}

	public static void dfs(int current) {
		visited[current] = true;
		System.out.print(current + " ");
		for (int i = 1; i <= N; i++) {
			if (arr[current][i] != 0 && !visited[i])
				dfs(i);
		}
		// visited[current] = false;
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		visited[V] = true;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n + " ");
			for (int i = 1; i <= N; i++) {
				if (arr[n][i] != 0 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
