package argotithm4;

//p.471 연습문제 2
public class DP_막대기 {

	public static void main(String[] args) {
		memo =new long[1000];
		System.out.println(getStick(25));

	}

	static long[] memo;
	static long getStick(int n) {
		if (memo[n] != 0)
			return memo[n];
		if (n == 1)
			return 2;
		if (n == 2)
			return 5;
		memo[n] = getStick(n - 1) * 2 + getStick(n - 2);
		return memo[n];
	}

	static long getStick_dp(int n) {
		long[] dp = new long[n + 1];
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] * 2 + dp[i - 2];
		}
		return dp[n];
	}

}
