
import java.io.*;
import java.util.*;

//캐슬디펜스
public class Baek_17135 {
	static int N, M, D, res;
	static int[][] arr;
	static int[] sel;

	static boolean range(int x, int y) {
		return x >= 0 && x < N + 1 && y >= 0 && y < M;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
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

	// M줄에 궁수가 갈 수 있는 조합을 뽑기
	public static void combi(int[] narr, int n, int c) {
		if (c == sel.length) {
			int cnt = func();
			// 조합에서 죽일 수 있는 적 갯수 중 제일 큰 놈을 구해보자
			// System.out.println("===" + cnt);
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

	public boolean ck(int x, int x1, int y, int y1) {
		return (Math.abs(x - x1) + Math.abs(y - y1)) >= D;
	}

	public static int func() {
		int cnt = 0;
		if (D == 1) {
			// 거리가 1일때는 앞 놈만 보면 돼
			for (int k = 0; k < sel.length; k++) {
				for (int i = 0; i < N; i++) {
					if (arr[i][sel[k]] == 1)
						cnt++;
				}
			}
		} else {
			// 1이 아닐때는 tmp에 죽인 놈 체크하면서 갈꺼니까 복사해주기
			int[][] tmp = new int[N + 1][M];
			for (int i = 0; i < N; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}

			// sel배열에 궁수가 갈 M(번호)이 적혀져 있음
			// i는 N-1부터 올라가기
			for (int i = N - 1; i >= 0; i--) {
				// 세 마리의 궁수가 돌거야
				for (int k = 0; k < sel.length; k++) {
					// D까지 돌기
					for (int j = 0; j <= D; j++) {

						if (range(i, sel[k] - j) && tmp[i][sel[k] - j] == 1) {
							tmp[i][sel[k] - j] = 2;
							// System.out.println(i + " : " + i + "," + (sel[k] - j));
							break;
						}

						if (range(i - j, sel[k]) && tmp[i - j][sel[k]] == 1) {
							tmp[i - j][sel[k]] = 2;
							// System.out.println(i + " : " + (i - j) + "," + (sel[k]));
							break;
						}

						if (range(i, sel[k] + j) && tmp[i][sel[k] + j] == 1) {
							tmp[i][sel[k] + j] = 2;
							// System.out.println(i + " : " + i + "," + (sel[k] + j));
							break;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j] == 2)
						cnt++;
				}
			}

		}

		return cnt;
	}
}
