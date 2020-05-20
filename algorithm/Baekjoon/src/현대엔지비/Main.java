package 현대엔지비;

import java.io.*;
import java.util.*;

public class Main {
	static long N, K;

	/*
	 * 7 3 1414213
	 * 
	 * 8 3 00000013
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());

		String str = br.readLine();
		long res = 0;
		long num = 0;
		for (int i = 0; i < N - K + 1; i++) {
			num = 0;
			for (int j = i; j < i + K; j++) {
				num *= 10;
				num += str.charAt(j) - '0';
			}
			if (num > res)
				res = num;
		}
		bw.append(String.valueOf(res));
		bw.flush();
		bw.close();
	}
}
