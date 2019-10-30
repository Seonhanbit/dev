package D4;

import java.io.*;
import java.util.*;

public class s_4050_재관이의대량할인 {
	static int T, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.parallelSort(arr);
			if (N % 3 == 0) {
				for (int i = N; i >= 1; i--) {
					if (i % 3 == 1) {
						continue;
					}
					sum += arr[i];
				}
			} else {
					int cnt = 1;
					for (int i = N; i >= 1; i--) {
						if (cnt % 3 == 0) {
							cnt++;
							if (i == 0 || i == 1)
								sum += arr[i];
							continue;
						}
						cnt++;
						sum += arr[i];
					}
			}

			bw.append("#").append(String.valueOf(tc)).append(" ").append(sum + "\n");
			bw.flush();
		}
		bw.close();
	}
}
