package Sub_12;

import java.io.*;
import java.util.*;

public class b1707_이분그래프2 {
	static ArrayList<Integer>[] list = null;
	static boolean[] check, visited;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				list[i] = new ArrayList<Integer>();

			check = new boolean[V + 1];
			visited = new boolean[V + 1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());
				list[s].add(f);
				list[f].add(s);
			}

			for (int i = 1; i < V; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(i);
				}
			}

			String result = "YES";
			loop: for (int i = 1; i <= V; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					if (check[i] == check[list[i].get(j)]) {
						result = "NO";
						break loop;
					}
				}
			}
			System.out.println(result);
		}

	}

	static void dfs(int idx) {

		for (int i = 0; i < list[idx].size(); i++) {
			if (!visited[list[idx].get(i)]) {
				visited[list[idx].get(i)] = true;
				check[list[idx].get(i)] = !check[idx];
				dfs(list[idx].get(i));
			}
		}
	}
}
