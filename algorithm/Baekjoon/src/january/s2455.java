package january;

import java.io.*;
import java.util.*;

public class s2455 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int start = 0;
		int sum = 0;
		int max = 0;

		for (int i = 0; i < 4; i++) {
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (i == 0) {
				start = b;
			} else {
				sum = b - a;
				start += sum;
			}
			max = Math.max(start, max);
		}

		bw.append(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
