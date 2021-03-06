package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_7465_창용마을무리의수 {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			rank = new int[N + 1];
			int cnt = 0;
			for (int k = 1; k < N + 1; k++) {
				parents[k] = k;
				rank[k]=0;
			}
			for (int k = 0; k < M; k++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				union(i, j);
			}
			for (int k = 1; k < N + 1; k++) {
				if (k == parents[k])
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		parents[x] = findSet(parents[x]);
		return parents[x];
	}

	static void union(int x, int y) {
		//parents[findSet(y)] = findSet(x);
		if(rank[x]<rank[y]) {
			parents[findSet(x)] = findSet(y);
		}else{
			parents[findSet(y)] = findSet(x);
			if(rank[findSet(y)] == rank[findSet(x)]) {
				rank[findSet(x)]++;
			}
		}
	}

}
