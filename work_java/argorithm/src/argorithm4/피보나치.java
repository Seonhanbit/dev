package argorithm4;

public class 피보나치 {

	public static void main(String[] args) {
		memo = new int[100];
		long start = System.currentTimeMillis();
//		System.out.println(fibo(99));
		System.out.println(fibo_dp(99));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	// 점화식 : 상향식이던 하향식이던 점화식을 잘 뽑기
	static int real_fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibo(n - 1) + fibo(n - 2);
	}

	// 하향식 DP (기억할 것 2가지 : 기억있으면 재사용, n번쨰 기억하기)
	static int[] memo;

	static int fibo(int n) {
		// n번째에 대한 기억이 있으면 재사용!!!
		if (memo[n] != 0)
			return memo[n];

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		// n번쨰는 이거야!! 기억하기
		memo[n] = fibo(n - 1) + fibo(n - 2);
		return memo[n];
	}

	// 상향식 DP (일반적인 DP, 하향식보다는 더 성능이 좋은편 : 함수 콜 오버헤드가 없음)
	static int fibo_dp(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
