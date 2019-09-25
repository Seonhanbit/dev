package argotithm4;

public class 이항계수 {

	public static void main(String[] args) {
		memo = new long[101][51];
		System.out.println(bino_dp(100, 50));
	}

	// n개 중에서 k개를 뽑는 것을 기억해야하니까 2차원 배열
	static long[][] memo;

	static long bino(int n, int k) {
		if (memo[n][k] != 0)
			return memo[n][k];
		if (k == 0)
			return 1;
		if (k == n)
			return 1;
		memo[n][k] = bino(n - 1, k - 1) + bino(n - 1, k);
		return memo[n][k];
	}

	static long bino_dp(int n, int k) {
		long[][] dp = new long[n+1][k+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				// 안 고르는 경우와 모두 고르는 경우는 1
				if (j == 0 || j == i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		return dp[n][k];
	}
}
