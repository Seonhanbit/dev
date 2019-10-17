package October;

import java.io.*;
import java.util.*;

public class s_2564_경비원 {
	static int N, M, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				arr[i] = b;
			} else if (a == 2) {
				arr[i] = N + M + (N - b);
			} else if (a == 3) {
				arr[i] = N + M + N + (M - b);
			} else if (a == 4) {
				arr[i] = N + b;
			}
		}

		for (int i = 0; i < n; i++) {
			int tmp = Math.abs(arr[n] - arr[i]);
			if (tmp > N + M) {
				sum += (2 * (M + N)) -tmp;
			} else
				sum += tmp;
			//System.out.println(sum);
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}

}
