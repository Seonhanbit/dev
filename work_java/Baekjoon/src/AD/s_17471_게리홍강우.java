package AD;
import java.io.*;
import java.util.*;

public class s_17471_게리홍강우 {
	static int N, re_min;
	static int[] people;
	static boolean[] sel;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		re_min = Integer.MAX_VALUE;
		people = new int[N + 1];
		sel = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++)
			people[n] = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int STC = Integer.parseInt(st.nextToken());
			for (int stc = 0; stc < STC; stc++) {
				int g = Integer.parseInt(st.nextToken());
				map[n][g] = 1;
				map[g][n] = 1;
			}
		}

		go(1);
		System.out.println(re_min == Integer.MAX_VALUE ? -1 : re_min);
	}

	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;

	static void bfs() {
		int cnt = 0;

		int sum_A = 0;
		visited = new boolean[N + 1];
		q.add(a);
		visited[a] = true;
		sum_A += people[a];
		cnt++;
//		System.out.println("a: " + a + ", sum_A: " + sum_A + ", cnt:" + cnt);
		while (!q.isEmpty()) {
			int r = q.poll();
			for (int c = 1; c <= N; c++) {
				if (map[r][c] == 0)
					continue;
				if (visited[c])
					continue;
				if (hsm_A.get(c) == null)
					continue;
				q.add(c);
				visited[c] = true;
				sum_A += people[c];
				cnt++;
//				System.out.println("c: " + c + ", sum_A: " + sum_A + ", cnt:" + cnt);
			}
		}

		int sum_B = 0;
		visited = new boolean[N + 1];
		q.add(b);
		visited[b] = true;
		sum_B += people[b];
		cnt++;
//		System.out.println("b: " + b + ", sum_B: " + sum_B + ", cnt:" + cnt);
		while (!q.isEmpty()) {
			int r = q.poll();
			for (int c = 1; c <= N; c++) {
				if (map[r][c] == 0)
					continue;
				if (visited[c])
					continue;
				if (hsm_B.get(c) == null)
					continue;
				q.add(c);
				visited[c] = true;
				sum_B += people[c];
				cnt++;
//				System.out.println("c: " + c + ", sum_B: " + sum_B + ", cnt:" + cnt);
			}
		}

		if (cnt == N && re_min > Math.abs(sum_A - sum_B)) {
			re_min = Math.abs(sum_A - sum_B);
//			System.out.println("sum_A: " + sum_A + ", sum_B: " + sum_B + ", re_min: " + re_min);
//			System.out.println();
		}
	}

	static HashMap<Integer, Boolean> hsm_A = new HashMap<>();
	static HashMap<Integer, Boolean> hsm_B = new HashMap<>();
	static int a, b;

	static void go(int idx) {
		if (idx == N + 1) {
			hsm_A.clear();
			hsm_B.clear();
			for (int i = 1; i <= N; i++)
				if (sel[i]) {
					hsm_A.put(i, true);
					a = i;
				} else {
					hsm_B.put(i, true);
					b = i;
				}
			if (hsm_A.size() > 0 && hsm_B.size() > 0) {
//				for (int i = 1; i <= N; i++)
//					if (sel[i])
//						System.out.print(i + " ");
//				System.out.println();
//				for (int i = 1; i <= N; i++)
//					if (!sel[i])
//						System.out.print(i + " ");
//				System.out.println();
				bfs();
//				System.out.println();
			}
//			System.out.print(hsm_A.toString());
//			System.out.println(hsm_B.toString());
			return;
		}

		sel[idx] = false;
		go(idx + 1);
		sel[idx] = true;
		go(idx + 1);
	}
}
