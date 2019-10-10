package AD;

import java.io.*;
import java.util.*;

public class s_17471_게리맨더링 {
	static int N, sum1, sum2;
	static int[] people;
	static boolean[] visited;
	static int[][] near;
	static ArrayList<Integer> list1 = new ArrayList<>();
	static ArrayList<Integer> list2 = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		visited = new boolean[N];
		near = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			people[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				near[i][a - 1] = 1;
				near[a - 1][i] = 1;
			}
		}
		powerset(0, new boolean[N]);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void powerset(int idx, boolean[] check) {
		if (idx == people.length) {
			list1.clear();
			list2.clear();

			for (int i = 0; i < people.length; i++) {
				if (check[i]) {
					list1.add(i);
				} else
					list2.add(i);
			}
			min1 = min2 = Integer.MAX_VALUE;
			if (list1.size() != 0 && list2.size() != 0) {
				System.out.println(list1);
				System.out.println(list2);

				dfs1(list1, people[list1.get(0)], 1, list1.get(0));
				dfs2(list2, people[list2.get(0)], 1, list2.get(0));
			}
			System.out.println("min1:" + min1 + ", min2:" + min2);
			if (min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE && Math.abs(min1 - min2) < min) {
				min = Math.abs(min1 - min2);
			}

			return;
		}
		check[idx] = false;
		powerset(idx + 1, check);
		check[idx] = true;
		powerset(idx + 1, check);
	}

	static int min1, min2;

	static void dfs1(ArrayList<Integer> list, int sum, int cnt, int r) {
		visited[r] = true;

		if (cnt == list.size()) {
			if (min1 > sum) {
				min1 = sum;
			}
			return;
		}

		for (int c = 0; c < N; c++) {
			if (near[r][c] == 0)
				continue;
			if (visited[c])
				continue;
			if (!list.contains(c))
				continue;
			visited[c] = true;
			dfs1(list, sum + people[c], cnt + 1, c);
			visited[c] = false;
		}
	}

	static void dfs2(ArrayList<Integer> list, int sum, int cnt, int r) {
		visited[r] = true;

		if (cnt == list.size()) {
			if (min2 > sum) {
				min2 = sum;
			}
			return;
		}

		for (int c = 0; c < N; c++) {
			if (near[r][c] == 0)
				continue;
			if (visited[c])
				continue;
			if (!list.contains(c))
				continue;
			visited[c] = true;
			dfs2(list, sum + people[c], cnt + 1, c);
			visited[c] = false;
		}
	}

	static void sum() {
		int sum1 = 0;
		int sum2 = 0;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int k = list1.size() - 1; k >= 0; k--) {
				if (i == list1.get(k)) {
					sum1 += people[i];
					list1.remove(k);
				}
			}
			for (int k = list2.size() - 1; k >= 0; k--) {
				if (i == list2.get(k)) {
					sum2 += people[i];
					list2.remove(k);
				}
			}
		}
		System.out.println("sum1 " + sum1);
		System.out.println("sum2 " + sum2);
		if (sum1 >= sum2) {
			res = sum1 - sum2;
		} else {
			res = sum2 - sum1;
		}

		if (res < min)
			min = res;

	}

}
