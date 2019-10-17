package argorithm5_복습;

import java.util.Scanner;

public class unionfind {
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		int N = sc.nextInt(); // 노드의 갯수
		int M = sc.nextInt(); // 두 원소가 같은 집합임을 표현하는 입력의 갯수

		// makeSet연산 수행
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++)
			parents[i] = i;

		rank = new int[N + 1];
		// M개의 연산을 union연산을 하고
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (parents[i] == i)
				cnt++;
		}
		System.out.println(cnt);
	}

	static final String src = "7 8\n" + "1 2\n" + "1 2\n" + "2 4\n" + "2 5\n" + "4 6\n" + "5 6\n" + "6 7\n" + "3 7\n";

	// x원소의 대표자를 찾아서 리턴
	static int findSet(int x) {
		// 자신의 부모가 자신이면 루트노드이므로, 대표자. 자신을 리턴
		if (parents[x] == x)
			return x;
		// 아니라면, 계속해서 부모를 찾아나감
		return parents[x] = findSet(parents[x]);
	}

	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (rank[x] > rank[y])
			parents[y] = x;
		else {
			parents[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
		// parents[nx] =parents[ny];
	}
}
