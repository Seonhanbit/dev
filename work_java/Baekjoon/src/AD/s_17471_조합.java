package AD;

import java.io.*;
import java.util.*;

public class s_17471_조합 {
	static int N;// 선거구 수
	static int[] people; // 각 선거구별 유권자 수
	static int[][] near; // 선거구 간의 인접 정보
	static int min = Integer.MAX_VALUE;
	static int[] combi;
	static List<Integer> areaA, areaB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		near = new int[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++)
			people[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				near[i][a] = 1;
				near[a][i] = 1;
			}
		}

		for (int i = 1; i <= N / 2; i++) {
			combi = new int[i + 1];
			Combination(1, 1);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void Combination(int n, int c) {
		if (c == combi.length) {
			if (check()) {
				int sumA = 0;
				int sumB = 0;
					for(int j=0; j<areaA.size(); j++) {
						sumA += people[areaA.get(j)];
					}

					for(int j=0; j<areaB.size(); j++) {
						sumB += people[areaB.get(j)];	
					}
				min = Math.min(min, Math.abs(sumA - sumB));
			}

			areaA.clear();
			areaB.clear();
			return;
		}
		if (n == N + 1) {
			return;
		}
		combi[c] = n;
		Combination(n + 1, c + 1);
		Combination(n + 1, c);
	}

	static boolean check() {
		areaA = new ArrayList<>();
		areaB = new ArrayList<>();
		for (int i = 1; i < combi.length; i++) {
			areaA.add(combi[i]);
		}
		for (int i = 1; i <= N; i++) {
			areaB.add(i);
		}
		for (int i = N; i > 0; i--) {
			for (int j = 0; j < areaA.size(); j++) {
				if (i == areaA.get(j))
					areaB.remove(i - 1);
			}
		}
/*		System.out.println(areaA);
		System.out.println(areaB);*/
		if (areaA.size() == 0 || areaB.size() == 0)
			return false;

		boolean[] visited = new boolean[N + 1];
		// A마을 아무 지점이나 출발로, B마을 아무 지점이나 출발로
		// 각각 BFS, DFS를 통해 탐색하며 방문할때 true로 변경
			Queue<Integer> queue = new LinkedList<>();
			queue.add(areaA.get(0));
			visited[areaA.get(0)] = true;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int i = 0; i < areaA.size(); i++) {
					if (near[node][areaA.get(i)] != 0 & !visited[areaA.get(i)]) {
						visited[areaA.get(i)] = true;
						queue.add(areaA.get(i));
					}
				}
			}

			queue.add(areaB.get(0));
			visited[areaB.get(0)] = true;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int i = 0; i < areaB.size(); i++) {
					if (near[node][areaB.get(i)] != 0 & !visited[areaB.get(i)]) {
						visited[areaB.get(i)] = true;
						queue.add(areaB.get(i));
					}
				}
			}

		// 양쪽 다 탐색 후 visited의 1번부터 N번까지 모두 true가 되어있다면 연결된 것
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}
}
