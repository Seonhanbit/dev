package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s_3124_prim {
	static ArrayList<Node>[] list;
	static int V, E;
	static class Node implements Comparable<Node>{
		int dic;
		int cost;
		Node(int dic, int cost){
			this.dic=dic;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			for(int i=1; i<V+1; i++)
				list[i] = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list[n1].add(new Node(n2, cost));
				list[n2].add(new Node(n1, cost));
			}
			int cnt = 1;
			long result = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[V+1];
			pq.addAll(list[1]);
			visited[1] = true;
			while(cnt<V) {
				Node e = pq.poll();
				if(visited[e.dic])
					continue;
				result += e.cost;
				cnt++;
				visited[e.dic] = true;
				pq.addAll(list[e.dic]);
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
