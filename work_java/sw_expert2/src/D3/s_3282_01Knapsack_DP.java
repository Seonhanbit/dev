package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_3282_01Knapsack_DP {
	static class VC {
		int v;
		int c;

		VC(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public String toString() {
			return "VC [v=" + v + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			VC[] vc = new VC[N];
			int[][] arr = new int[N][K + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				vc[i] = new VC(a, b);
				// System.out.println(vc[i]);
			}
			for (int j = 1; j < K + 1; j++) {
				if (vc[0].v <= K && vc[0].v <= j)
					arr[0][j] = vc[0].c;
				//System.out.println(arr[0][j]);
			}

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < K + 1; j++) {
					if (vc[i].v <= K && i - 1 >= 0 && j - vc[i].v >= 0) {
						if ((arr[i - 1][j - vc[i].v] + vc[i].c) > arr[i - 1][j])
							arr[i][j] = arr[i - 1][j - vc[i].v] + vc[i].c;
						else
							arr[i][j] = arr[i - 1][j];
					} else {
						arr[i][j] = arr[i - 1][j];
					}
				}
			}

			System.out.println("#" + tc + " " + arr[N - 1][K]);
		}

	}

}
