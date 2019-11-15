import java.io.*;
import java.util.*;

public class Baek_16926 {
	static int N, M, K;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int l = 0; l < K; l++) {
			int x1 = 0;
			int y1 = 0;
			int x2 = N - 1;
			int y2 = M - 1;
			for (int k = 0; k < (N > M ? M / 2 : N / 2); k++) {
				int tmp = arr[x1][y1];
				for (int j = y1; j < y2; j++) {
					arr[x1][j] = arr[x1][j + 1];
				}
				for (int i = x1; i < x2; i++) {
					arr[i][y2] = arr[i + 1][y2];
				}
				for (int j = y2; j > y1; j--) {
					arr[x2][j] = arr[x2][j - 1];
				}
				for (int i = x2; i > x1; i--) {
					arr[i][y1] = arr[i - 1][y1];
				}
				arr[x1 + 1][y1] = tmp;
				x1++;
				y1++;
				x2--;
				y2--;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		// print();
	}

	static void print() {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
