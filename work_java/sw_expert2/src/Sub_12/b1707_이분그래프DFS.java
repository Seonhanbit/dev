package Sub_12;

import java.io.*;
import java.util.*;

public class b1707_이분그래프DFS {
	static int N, M;
	static List<Integer>[] list;
	static int[] color;

	public static class pos {
		int jum;
		int dist;
		int color;

		pos(int jum, int dist, int color) {
			this.jum = jum;
			this.dist = dist;
			this.color = color;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 정점 수
			M = Integer.parseInt(st.nextToken()); // 간선 수
			list = new ArrayList[N + 1];
			color = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			isOK = true;
			for (int i = 1; i < N + 1; i++) {
				if (color[i] == 0)
					dfs(i, 1);
			}
			if(isOK)
				bw.append("YES");
			else
				bw.append("NO");
			bw.flush();
		}
		bw.close();
	}

	static boolean isOK;

	static void dfs(int node, int c) {
		color[node] = c;
		for (int i = 0; i < list[node].size(); i++) {
			int tmp = list[node].get(i);
			if (color[tmp] == c) {
				isOK = false;
				return;
			}
			if (color[tmp] == 0)
				dfs(tmp, -c);
		}
	}
}
