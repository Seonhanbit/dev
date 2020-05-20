package 현대엔지비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2 {
	static int cnt_map[], sum_map[], arr[];
	static int N, M;
	static Queue<Integer> q = new LinkedList<Integer>();
	static long ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		cnt_map = new int[N + 1];
		sum_map = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			cnt_map[tmp]++;
		}

		for (int i = 1; i <= N; i++) {
			if (cnt_map[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == 0)
				break;

			int go = arr[tmp];
			cnt_map[go]--;
			if (cnt_map[go] == 0)
				q.add(go);
			sum_map[go] += (sum_map[tmp] + 1);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			ans += (sum_map[x] - sum_map[y]);

		}
		System.out.println(ans);
	}
}