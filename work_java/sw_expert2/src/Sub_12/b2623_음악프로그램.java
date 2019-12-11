package Sub_12;

import java.io.*;
import java.util.*;

public class b2623_음악프로그램 {
	static int N, M;
	static List<Integer>[] list;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[M];
		parent = new int[N + 1];
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < M; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int su = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= su; j++) {
				int a = Integer.parseInt(st.nextToken());
				list[i].add(a);
				if (j != 1)
					parent[a]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (parent[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int n = queue.poll();
			result.add(n);
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < list[i].size(); j++) {
					if (list[i].get(j) == n && j + 1 < list[i].size()) {
						if (--parent[list[i].get(j + 1)] == 0)
							queue.add(list[i].get(j + 1));
					}
				}
			}
		}
		
		if(result.size()==N) {
			for(int i=0; i<result.size(); i++)
				System.out.println(result.get(i));
		}else {
			System.out.println(0);
		}
	}
}
