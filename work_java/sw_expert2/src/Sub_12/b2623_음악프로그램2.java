package Sub_12;

import java.io.*;
import java.util.*;

public class b2623_음악프로그램2 {
	static int N, M;
	static List<Integer>[] list;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		parent = new int[N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int su = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			for (int j = 1; j < su; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				list[first].add(tmp);
				parent[tmp]++;
				first = tmp;
			}
		}
		
/*		for (int i = 0; i < N + 1; i++) {
			for(int j=0; j<list[i].size(); j++) {
				System.out.print(list[i].get(j)+ " ");
			}System.out.println();
		}*/

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (parent[i] == 0)
				queue.add(i);
		}
		int ck = 0;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			sb.append(n + "\n");
			ck++;
			for (int j = 0; j < list[n].size(); j++) {
				if(--parent[list[n].get(j)]==0)
					queue.add(list[n].get(j));
			}
		}

		if (ck == N) {
			bw.append(sb);
		} else {
			bw.append("0");
		}
		bw.flush();
		bw.close();
	}
}
