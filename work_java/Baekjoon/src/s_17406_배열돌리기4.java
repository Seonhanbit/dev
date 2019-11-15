import java.io.*;
import java.util.*;

public class s_17406_배열돌리기4 {
	static int N, M, SR, S;
	static int[][] arr, copy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		SR = sc.nextInt();
		S = Math.min(N, M) / 2; // 1회전에서 돌려야하는 사각형의 개수
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		spin();
		print();
	}

	private static void print() {
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	static void spin() {
		for (int s = 0; s < S; s++) {
			int T = s;
			int B = N - 1 - s;
			int R = M - 1 - s;
			int L = s;
			int r = SR % (2 * (R - L + 1) + 2 * (B - T + 1) - 4);
			while (r-- != 0) {
				int tmp = arr[s][s];
				for (int i = L; i < R; i++)
					arr[T][i] = arr[T][i + 1];
				for (int i = T; i < B; i++)
					arr[i][R] = arr[i + 1][R];
				for (int i = R; i > L; i--)
					arr[B][i] = arr[B][i - 1];
				for (int i = B; i > T; i--)
					arr[i][L] = arr[i - 1][L];
				arr[T + 1][L] = tmp;
			}
		}
	}
}
