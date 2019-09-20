package argorithm3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
7 11
0 1 31
0 2 31
0 6 31
0 5 60
1 2 21
2 4 46
2 6 25
3 4 34
4 6 51
5 3 18
5 4 40
*/
public class Kruskal {
	static int[] parents;
	static int N, K, sum;
	static XY[] xy;

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

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
	}

	public static void main(String[] args) {
		String input = "7 11\n" + "0 1 31\r\n" + "0 2 31\r\n" + "0 6 31\r\n" + "0 5 60\r\n" + "1 2 21\r\n"
				+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n";
		Scanner br = new Scanner(input);
		StringTokenizer st = new StringTokenizer(br.nextLine());
		N = Integer.parseInt(st.nextToken());
		parents = new int[N];
		K = Integer.parseInt(st.nextToken());
		xy = new XY[K];
		for (int l = 0; l < N; l++) // makeSet
			parents[l] = l;
		for (int l = 0; l < K; l++) {
			st = new StringTokenizer(br.nextLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			xy[l] = new XY(x, y, val);
		}
		Arrays.sort(xy);
		System.out.println(Arrays.toString(xy));
		for (int l = 0; l < K; l++) {
			int nx = findSet(xy[l].x);
			int ny = findSet(xy[l].y);
			if (nx != ny) {
				union(xy[l].x, xy[l].y);
				sum += xy[l].val;
			}
		}
		System.out.println(sum);
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = findSet(parents[x]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		parents[py] = px;
	}

}
