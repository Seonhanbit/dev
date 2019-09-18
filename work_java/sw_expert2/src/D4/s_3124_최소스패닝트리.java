package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_3124_최소스패닝트리 {
	static int[] parents;
	static int V, E;
	static int[] rank;

	static class XY implements Comparable<XY> {
		int x;
		int y;
		int val;

		XY(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(XY o) {
			if (this.val == o.val) {
				if (this.x == o.x)
					return this.y - o.y;
				else
					return this.x - o.x;
			}
			return this.val - o.val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V + 1];
			rank = new int[V + 1];
			XY[] arr = new XY[E];
			for (int i = 1; i < V + 1; i++) {
				parents[i] = i;
				rank[i] = 0;
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(arr);
			long sum = 0;
			for (int i = 0; i < E; i++) {
				int nx = findSet(arr[i].x);
				int ny = findSet(arr[i].y);
				if (nx == ny)
					continue;
				union(arr[i].x, arr[i].y);
				sum += arr[i].val;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		parents[x]=findSet(parents[x]);
		return parents[x];
	}

	static void union(int x, int y) {
		//parents[findSet(y)] = findSet(x);
		int px = findSet(x);
		int py = findSet(y);
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
