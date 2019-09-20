package argorithm3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {

	public static void main(String[] args) throws IOException {
		// 거리 배열을 준비
		// 시작점을 고르고 시작점으로부터 갈 수 있는 각 정점에서는 거리를 적고 못가는 곳은 큰 값 적어줌
		// 시작점에 대해 방문체크
		// 방문 체크가 안된 정점 중 현재까지 가장 작은 정점 찾기
		// 찾은 정점으로부터 갈 수 있는 정점들에 대해서 기존 알고 있던 거리보다 더 짧으면 갱신
		// 시작점에서 찾은 정점까지의 거리 + 찾은 정점에서 다른 정점까지 거리
		String input = "6 11\n0 1 3\n0 2 5\n1 2 2\n1 3 6\n2 1 1\n2 4 6\n2 3 4\n3 4 2\n3 5 3\n4 0 3\n4 5 6\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		int[][] adj = new int[V][V];
		// 인접 행렬
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = Integer
					.parseInt(stk.nextToken());
		}
		// 최단거리를 기록할 배열..
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		// 0번 정점에서 각 정점으로 최단거리가 얼만지... 구해봅시다.
		visited[0] = true;
		for(int i = 0; i < V; i++) {
			dist[i] = adj[0][i];
			if( adj[0][i] == 0 )
				dist[i] = 999;
		}
		dist[0] = 0;
		System.out.println(Arrays.toString(dist));
		// V-1개의 정점을 선택해가며 최단거리를 갱신할거야(출발지 뺴고 나머지)
		for (int i = 0; i < V - 1; i++) {
			// dist 배열 중에서 가장 작은 정점을 찾기
			int minIdx = 0;
			int min = 999;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > dist[j]) {
					minIdx = j;
					min = dist[j];
				}
			}
			System.out.println(minIdx);
			//모든 정점에 대해서 시작점에서 min위치를 들러서 다른 정점으로 가는 거리가 기존에 알던 dist보다 작으면 갱신.
			for(int j = 0; j < V; j++) {
				//min에서 검사하는 정점으로 갈 수 있는지 여부 adj[min][j] != 0
				//검사하는 정점까지 알고 있던 거리 dist[j]
				//min을 거쳐서 검사하는 정점까지 가는 거리 dist[min] + adj[min][j]
				if( adj[minIdx][j] != 0 && dist[minIdx] + adj[minIdx][j] < dist[j] )
					dist[j] = dist[minIdx] + adj[minIdx][j];
			}
			visited[minIdx] = true;
			System.out.println(Arrays.toString(dist));
		}
	}

}
