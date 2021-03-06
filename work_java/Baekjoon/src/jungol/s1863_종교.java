package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1863_종교 {
	static int n, m, i, j;
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		rank = new int[n + 1];
		int cnt = 0;
		for (int k = 1; k < parents.length; k++) {
			parents[k] = k;
			rank[k] = 0; // 랭크 활용 > 0으로 초기화
		}
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			union(i, j);
		}
		for (int k = 1; k < parents.length; k++) {
			if (k == parents[k])
				cnt++;
		}

		System.out.println(cnt);

	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		// 루트가 구해지면 바로 부모에 넣어버리기
		parents[x] = findSet(parents[x]);
		return parents[x];
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		//parents[py] = px;
		if (rank[px] < rank[py]) {
			parents[px] = py;
		} else {
			parents[py] = px;
			if(rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}
}
