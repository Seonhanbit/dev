package Sub_12;

import java.io.*;
import java.util.*;

/*
7 8 1
1 2
1 3
2 4
2 5
4 6
5 6
6 7
3 7
 */
public class b1260_DFSBFS3 {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;
	static List<Integer>[] list;

	// 정점 수, 간선 수
	// 몇 초에 어떤 정점에 도착하는지 구하기
	// 각 정점이 몇번째에 도달하는지 출력하고
	// 1번째에 도달하는 친구가 몇개고, 2번쨰에 도달하는 친구가 몇개고...모두 출력하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken()); // start

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1]; // 순환이 있을 수도 있으니까 방문 배열 필요해

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		list = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();

		bfs();

		for (int i = 1; i < N + 1; i++) {
			if (list[i].size() == 0)
				break;
			System.out.println(i + "번째 들어오는 정점 수 : " + list[i].size());
			for (int j = 0; j < list[i].size(); j++) {
				System.out.print(list[i].get(j) + " ");
			}
			System.out.println();
		}
	}

	public static class XY {
		int jum;
		int dist;

		XY(int jum, int dist) {
			this.jum = jum;
			this.dist = dist;
		}
	}

	public static void bfs() {
		Queue<XY> queue = new LinkedList<XY>();
		queue.add(new XY(V, 1));
		visited[V] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			// System.out.println(tmp.jum+" 정점을 "+ tmp.dist+"번쨰로 방문합니다. ");
			list[tmp.dist].add(tmp.jum);
			for (int i = 1; i <= N; i++) {
				if (arr[tmp.jum][i] != 0 && !visited[i]) {
					queue.add(new XY(i, tmp.dist + 1));
					visited[i] = true;
				}
			}
		}
	}

	public static void bfs_강사님() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] result = new int[N + 1]; // 각 정점이 몇번째 도달하는 지 출력
		int[] cnt = new int[N + 1]; // 몇 초 후 도달하는 정점의 갯수 배열

		queue.add(V);
		result[V] = 1;
		cnt[V] = 1;

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (arr[tmp][i] != 0 && result[i] == 0) {
					queue.add(i);
					result[i] = result[tmp] + 1;
					cnt[result[i]] += 1;
				}
			}
		}
	}

}
