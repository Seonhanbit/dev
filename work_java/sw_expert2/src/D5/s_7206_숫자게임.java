package D5;

import java.io.*;
import java.util.*;

public class s_7206_숫자게임 {
	static int T;
	static String N;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = br.readLine();

			dfs(Integer.parseInt(N), 0);
			System.out.println("#" + t + " " + max);
			max = 0;
		} // tc
	}

	static int max = Integer.MIN_VALUE;

	public static void dfs(int n, int cnt) {
		if (n < 10) {
			if (max < cnt)
				max = cnt;
			return;
		}
		if (n >= 10)
			dfs((n / 10) * (n % 10), cnt + 1);
		if (n >= 100) {
			dfs((n / 100) * (n % 100), cnt + 1);
			dfs((n / 100) * (n % 100 / 10) * (n % 10), cnt + 1);
		}
		if (n >= 1000) {
			dfs(n / 1000 * (n % 1000), cnt + 1);// 천
			dfs(n / 1000 * (n % 1000 / 100) * (n % 100), cnt + 1); // 천과 백
			dfs(n / 1000 * (n % 1000 / 10) * (n % 10), cnt + 1); // 천과 십
			dfs(n / 1000 * (n % 1000 / 100) * (n % 100 / 10) * (n % 10), cnt + 1); // 천과 백과 십
		}
		if (n >= 10000) {
			// 만 , 만십, 만백, 만천, 만천백, 만천십, 만백십, 만천백십
			dfs(n / 10000 * (n % 10000), cnt + 1); // 만
			dfs(n / 10000 * (n % 10000 / 10) * (n % 10), cnt + 1); // 만십
			dfs(n / 10000 * (n % 10000 / 100) * (n % 100), cnt + 1); // 만백
			dfs(n / 10000 * (n % 10000 / 1000) * (n % 1000), cnt + 1); // 만천
			dfs(n / 10000 * (n % 10000 / 1000) * (n % 1000 / 100) * (n % 100), cnt + 1); // 만천백
			dfs(n / 10000 * (n % 10000 / 1000) * (n % 1000 / 10) * (n % 10), cnt + 1); // 만천십
			dfs(n / 10000 * (n % 10000 / 100) * (n % 100 / 10) * (n % 10), cnt + 1); // 만백십
			dfs(n / 10000 * (n % 10000 / 1000) * (n % 1000 / 100) * (n % 100 / 10) * (n % 10), cnt + 1); // 만천백십
		}
	}
}
