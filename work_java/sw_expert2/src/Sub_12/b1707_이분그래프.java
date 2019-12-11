package Sub_12;

import java.io.*;
import java.util.*;

public class b1707_이분그래프 {
	static int N, M;
	static List<Integer>[] list;

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
			int[] result = new int[N + 1];

			for (int i = 0; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}

			Queue<pos> queue = new LinkedList<pos>();

			queue.add(new pos(1, 1, 1));
			
			boolean[] chk = new boolean[N + 1];

			while (!queue.isEmpty()) {
				pos n = queue.poll();
				chk[n.jum] = true;
				result[n.dist] = n.color;
				for (int j = 0; j < list[n.jum].size(); j++) {
					if (!chk[list[n.jum].get(j)]) {
						if (n.color == 1)
							queue.add(new pos(list[n.jum].get(j), n.dist + 1, -1));
						else
							queue.add(new pos(list[n.jum].get(j), n.dist + 1, 1));
					}
				}
			}

			boolean flag = true;
			loof: for (int i = 1; i < N + 1; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					if (result[i] == result[list[i].get(j)]) {
						flag = false;
						break loof;
					}
				}
			}

			if (flag)
				bw.append("YES");
			else
				bw.append("NO");
			bw.flush();
		}
		bw.close();
	}
}
