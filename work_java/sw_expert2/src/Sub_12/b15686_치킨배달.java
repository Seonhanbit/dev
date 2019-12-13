package Sub_12;

import java.io.*;
import java.util.*;

public class b15686_치킨배달 {
	static int[][] arr;
	static int N, M, min;
	static List<XY> chicken, home;

	static int dist(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					home.add(new XY(i, j));
				if (arr[i][j] == 2)
					chicken.add(new XY(i, j));
			}
		}
		//int[] com = new int[chicken.size()];
		int[] res = new int[M];
		min = Integer.MAX_VALUE;

		//for (int i = 0; i < com.length; i++)
		//	com[i] = i;

		combi(res, 0, 0);
		bw.append(String.valueOf(min));
		bw.flush();
		bw.close();
	}

	public static void combi(int[] res, int n, int c) {
		if (c == res.length) {
			int nnd = 0;
			
			for (int i = 0; i < home.size(); i++) {
				int d = Integer.MAX_VALUE;
				for (int j = 0; j < res.length; j++) {
					int nd = dist(home.get(i).x, home.get(i).y, chicken.get(res[j]).x, chicken.get(res[j]).y);
					if (nd < d)
						d = nd;
				}
				nnd += d;
			}
			if (nnd < min)
				min = nnd;
			return;
		}
		if (n == chicken.size())
			return;
		//res[c] = com[n];
		res[c] = n;
		combi(res, n + 1, c + 1);
		combi(res, n + 1, c);
	}
}
