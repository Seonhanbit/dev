package Sub_12;

import java.io.*;
import java.util.*;
/*
4 5 1 3
1 2 
1 3
1 4
2 4
3 4
 */
public class b1260_DFSBFS2 {
	static int N, M, V, end, su, cnt;
	static int[][] arr;
	static boolean[] visited;
	static List<Integer> list;
	static List<Integer> res;

	// 출발점과 도착점을 입력받아서
	// 출발점에서 도착점으로 도달하는 경로의 수 출력
	// 출발점에서 도착점으로 도달하는 가장 긴 경로 출력

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		list = new ArrayList<Integer>();
		res = new ArrayList<Integer>();
		cnt = 0;
		dfs(V, 1);
		System.out.println(su);
		for(int i=0; i<res.size();i++) {
			System.out.print(res.get(i)+" ");
		}

	}

	public static void dfs(int current, int dist) {
		visited[current] = true;
		list.add(current);
		if (current == end) {
			su++;
			if(dist>cnt)
				cnt = dist;
			if(cnt==list.size()) {
				res.clear();
				for(int i=0; i<list.size();i++) {
					res.add(list.get(i));
				}
				list.clear();
			}
			visited[current] = false;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (arr[current][i] != 0 && !visited[i])
				dfs(i, dist+1);
		}
		visited[current] = false;
	}

}
