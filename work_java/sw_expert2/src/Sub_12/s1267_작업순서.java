package Sub_12;

import java.io.*;
import java.util.*;

public class s1267_작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=1; tc<=10; tc++) {
			bw.append("#"+tc+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); //정점
			int E = Integer.parseInt(st.nextToken()); //간선
			
			List<Integer>[] list = new ArrayList[V+1];
			int[] parents = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i < V+1; i++)
				list[i] = new ArrayList<>();
			
			for(int i=0; i<E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				parents[b]++;
			}
			
/*			while(!st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				parents[b]++;
			}*/
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int i=1; i<V+1; i++) {
				if(parents[i]==0)
					queue.add(i);
			}
			while(!queue.isEmpty()) {
				int n = queue.poll();
				bw.append(n+" ");
				for(int i=0; i<list[n].size(); i++) {
					if(--parents[list[n].get(i)]==0)
						queue.add(list[n].get(i));
				}
			}
			bw.append("\n");
			bw.flush();
		}
		bw.close();
	}
}
