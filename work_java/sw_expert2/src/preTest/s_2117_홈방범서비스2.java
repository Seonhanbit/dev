package preTest;

import java.io.*;
import java.util.*;

public class s_2117_홈방범서비스2 {
	static int T, N, M, K, res;
	static int[][] arr;
	static ArrayList<XY> home;

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			home = new ArrayList<>();
			res = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1)
						home.add(new XY(i, j));
				}
			}
			K = N + 2;
			while (K != 0) {
				int val = 0;
				int homesu = 0;
				int nk = K * K + (K - 1) * (K - 1);
				// System.out.println("K :" + K);
				// System.out.println("nk : " + nk);
				ArrayList<XY> list = new ArrayList<>();
				loof: for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// System.out.println(i + "," + j);
						list = func(i, j, K);
						// System.out.println(list.size());
						int tmp = (list.size() * M) - nk;
						if (tmp >= val) {
							val = tmp;
							homesu = list.size();
							if (homesu == home.size())
								break loof;
						}
					}
				}
				res = Math.max(homesu, res);
				if (res == home.size())
					break;
				K--;
			}

			bw.append("#" + tc + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}

	static ArrayList<XY> func(int x, int y, int k) {
		ArrayList<XY> list = new ArrayList<>();
		for (int i = 0; i < home.size(); i++) {
			if (range(x, y, home.get(i).x, home.get(i).y, k)) {
				// System.out.println(home.get(i).toString());
				list.add(home.get(i));
			}
		}
		return list;
	}

	static boolean range(int x, int y, int x1, int y1, int k) {
		return (Math.abs(x - x1) + Math.abs(y - y1)) < k;
	}
}
