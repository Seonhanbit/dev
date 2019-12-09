package argorithm6_sub;

import java.io.*;
import java.util.*;
/*
간선수, 정점수
8 7
0 2
0 1
2 5
1 4
5 4
3 4
3 6
1 3
*/

public class 위상정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 간선
		int N = Integer.parseInt(st.nextToken()); // 정점
		// 인접 리스트로 입력을 받아 보기
		// N개의 가변길이 배열이 필요함
		List<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adj[i] = new ArrayList<>();

		// 부모 찾기 위한 배열 준비
		int[] parents = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			parents[b]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		// 부모 카운트가 0인 친구들을 방문하기 위해서 큐에 삽입
		for (int i = 0; i < N; i++) {
			if (parents[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			// 큐 꺼내서 방문하기
			int ns = queue.poll();
			System.out.print(ns+" ");
			// 방문한 노드에서 연결되는 친구들의 부모카운트를 1씩 감소 -> 그 값이 0이되면 큐에 삽입
			for (int j = 0; j < adj[ns].size(); j++) {
/*				parents[(int) adj[ns].get(j)]--;
				if(parents[(int) adj[ns].get(j)]==0)
					queue.add((int) adj[ns].get(j));*/
				if(--parents[adj[ns].get(j)]==0)
					queue.add(adj[ns].get(j));
			}
		}

	}

}
