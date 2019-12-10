package Sub_12;

import java.io.*;
import java.util.*;
//내 코드를 살릴 방법은 없을까?
public class b1516_게임개발2 {
	static int[] parent;
	static List<Integer>[] list;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		parent = new int[N + 1];
		int[] clock = new int[N + 1];
		int[] result = new int[N + 1];

		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();

		for (int k = 1; k <= N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				cnt++;
				if (n == -1)
					break;
				if (cnt == 1) {
					clock[k] = n;
				} else {
					list[k].add(n);
					parent[k]++;
				}
			}
		}

		int[] tmp = new int[N + 1];
		tmp = parent.clone();

		for (int i = 1; i < N + 1; i++) {
			parent = tmp.clone();

			if (parent[i] == 0) {
				result[i] += clock[i];
			} else {
				List<Integer> nlist = bfs(i);
				for (int j = 0; j < nlist.size(); j++) {
					result[i] += clock[nlist.get(j)];
				}
			}
		}

		for (int i = 1; i < N + 1; i++)
			bw.append(result[i] + "\n");

		bw.flush();
		bw.close();
	}

	public static List<Integer> bfs(int su) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> nlist = new ArrayList<Integer>();
		boolean[] check = new boolean[N + 1];
		queue.add(su);

		while (!queue.isEmpty()) {
			int n = queue.poll();
			nlist.add(n);
			for (int i = 0; i < list[n].size(); i++) {
				if (!check[list[n].get(i)]) {
					check[list[n].get(i)]=true;
					queue.add(list[n].get(i));
				}
			}
		}
		return nlist;
	}
}
