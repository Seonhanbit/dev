package Sub_12;

import java.io.*;
import java.util.*;

public class b2252_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N+1];
		int[] parent = new int[N+1];
		
		for(int i=0; i<N+1; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			parent[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(parent[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			bw.append(n+" ");
			for(int i=0; i<list[n].size(); i++) {
				if(--parent[list[n].get(i)]==0) {
					queue.add(list[n].get(i));
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
