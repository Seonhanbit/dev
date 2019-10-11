package D4;

import java.io.*;
import java.util.*;

public class s_5643_키순서플로이드 {
	static final int INF = 99;
	static int N, M, res;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];
			res = 0;
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (arr[i][j] == 0)
						arr[i][j] = INF;
				}
			}
			for (int k = 1; k < N + 1; k++) {
				for (int i = 1; i < N + 1; i++) {
					for (int j = 1; j < N + 1; j++) {
						if (arr[i][k] != INF && arr[k][j] != INF)
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
			int[] sum = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (arr[i][j] != INF) {
						sum[i] += 1;
						sum[j] += 1;
					}
				}
			}
			for (int i = 1; i < N + 1; i++) {
				System.out.println(sum[i]);
				if(sum[i]==N-1)
					res++;
			}
			System.out.println("#" + tc + " " + res);
		}
	}

}
