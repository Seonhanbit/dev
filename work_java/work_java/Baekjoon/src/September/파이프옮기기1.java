package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//왜틀려!@!!!!!!으아아아아아아
public class 파이프옮기기1 {
	public static int dp[][][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int col = 0; col < N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][N][3];

		dp[0][1][0] = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 2; c < N; c++) {
				if (arr[r][c] == 0) {
					if (c - 1 >= 0 &&arr[r][c - 1] == 0) {
						if (dp[r][c - 1][0] != 0) {
							dp[r][c][0] += dp[r][c - 1][0];
						}
						if (dp[r][c - 1][2] != 0) {
							dp[r][c][0] += dp[r][c - 1][2];
						}
					}
					if (r - 1 >= 0 &&arr[r - 1][c] == 0) {
						if (dp[r - 1][c][1] != 0) {
							dp[r][c][1] += dp[r - 1][c][1];
						}
						if (dp[r - 1][c][2] != 0) {
							dp[r][c][1] += dp[r - 1][c][2];
						}
					}
					if (r - 1 >= 0 && c - 1 >= 0 &&arr[r - 1][c - 1] == 0) {
						if (dp[r - 1][c - 1][0] != 0) {
							dp[r][c][2] += dp[r - 1][c - 1][0];
						}
						if (dp[r - 1][c - 1][1] != 0) {
							dp[r][c][2] += dp[r - 1][c - 1][1];
						}
						if (dp[r - 1][c - 1][2] != 0) {
							dp[r][c][2] += dp[r - 1][c - 1][2];
						}
					}
				}
			}
			System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
		}
	}

}
