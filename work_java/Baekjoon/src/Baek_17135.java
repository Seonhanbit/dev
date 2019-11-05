
import java.io.*;
import java.util.*;

public class Baek_17135 {
	static int N, M, D, res;
	static int[][] arr;
	static int[] sel;

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int[] narr = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < M; j++) {
			narr[j] = j;
		}
		sel = new int[3];
		res = Integer.MIN_VALUE;
		combi(narr, 0, 0);
		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}

	public static void combi(int[] narr, int n, int c) {
		if (c == sel.length) {
			int cnt = func();
			//System.out.println("===" + cnt);
			if (cnt > res)
				res = cnt;
			return;
		}
		if (n == narr.length)
			return;
		sel[c] = narr[n];
		combi(narr, n + 1, c + 1);
		combi(narr, n + 1, c);
	}

	public static int func() {
		int cnt = 0;
		if (D == 1) {
			for (int k = 0; k < sel.length; k++) {
				for (int i = 0; i < N; i++) {
					if (arr[i][sel[k]] == 1)
						cnt++;
				}
			}
		} else {
			int nD = D;
			int[][] tmp = new int[N][M];
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}

			//System.out.println("3481y35098135");
			for (int k = 0; k < sel.length; k++) {
				//System.out.println("sel : " + sel[k]);
				for (int i = N-1; i >= 0; i--) {
					for (int j = 0; j <= nD; j++) {
/*						if (!range(i, sel[k] - j))
							continue;
						if (!range(i - j, sel[k]))
							continue;
						if (!range(i, sel[k] + j))
							continue;*/

						if (range(i, sel[k] - j)&&tmp[i][sel[k] - j] == 1) {
							tmp[i][sel[k] - j] = 2;
							//System.out.println(i+" : "+i + "," + (sel[k] - j));
							continue;
						}

						if (range(i - j, sel[k])&&tmp[i - j][sel[k]] == 1) {
							tmp[i - j][sel[k]] = 2;
							//System.out.println(i+" : "+(i - j) + "," + (sel[k]));
							continue;
						}

						if (range(i, sel[k] + j)&&tmp[i][sel[k] + j] == 1) {
							tmp[i][sel[k] + j] = 2;
							//System.out.println(i+" : "+i + "," + (sel[k] + j));
							continue;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tmp[i][j]==2)
						cnt++;
				}
			}
			
		}

		return cnt;
	}
}
