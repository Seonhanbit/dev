package AD;

import java.io.*;
import java.util.*;

public class s_17406_배열돌리기4 {
	static int N, M, K, re;
	static int[][] arr;
	static Point[] point;

	static class Point {
		int r;
		int c;
		int s;

		Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		point = new Point[K];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		re = Integer.MAX_VALUE;
		perm(0, new boolean[K], new int[K]);
		bw.append(re + "\n");
		bw.flush();
		bw.close();
	}

	static void perm(int idx, boolean[] sel, int[] result) {
		if (idx == K) {
			int[][] tmp = new int[N+1][M+1];
			for (int i = 1; i <= N; i++)
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);

			spin(result, tmp);
			int cnt = sum(tmp);
			//System.out.println("xnt : "+cnt);
			re = Math.min(cnt, re);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!sel[i]) {
				sel[i] = true;
				result[idx] = i;
				perm(idx + 1, sel, result);
				sel[i] = false;
			}
		}
	}

	static int sum(int[][] tmp) {
		int cnt = 0;
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			for (int j = 1; j <= M; j++) {
				cnt += tmp[i][j];
			}
			res = Math.min(res, cnt);
		}
		return res;
	}

	private static void print(int[][] tmp) {
		for (int[] is : tmp) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	static void spin(int[] result, int[][] tmp) {
		for (int k = 0; k < result.length; k++) {
			Point now = point[result[k]];
			int T = now.r - now.s;
			int L = now.c - now.s;
			
			int B = now.r + now.s;
			int R = now.c + now.s;
			//System.out.println(T+"<"+L+"<"+B+","+R);
			int S = Math.min(B - T, R - L) / 2;
			for (int s = 0; s < S; s++) {
				T += s;
				L += s;
				B -= s;
				R -= s;
				// System.out.println(T+","+L+","+B+","+R);
				int ntmp = tmp[T][L];
				for (int i = T; i < B; i++)
					tmp[i][L] = tmp[i + 1][L];
				for (int i = L; i < R; i++)
					tmp[B][i] = tmp[B][i + 1];
				for (int i = B; i > T; i--)
					tmp[i][R] = tmp[i - 1][R];
				for (int i = R; i > L; i--)
					tmp[T][i] = tmp[T][i - 1];

				tmp[T][L + 1] = ntmp;
			}
			//print(tmp);
			//System.out.println();
		}

		//System.out.println("-------------");
	}

}
