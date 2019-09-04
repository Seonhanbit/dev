package sw_expert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_5356_의석이의세로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] arr = new String[5];
			for (int i = 0; i < 5; i++) {
				arr[i] = br.readLine();
			}

			int len = arr[0].length();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				if (len < arr[i + 1].length())
					len = arr[i + 1].length();
			}

			for (int i = 0; i < len; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[j].length() <= i) {
						continue;
					}else {
						sb.append(arr[j].charAt(i));
					}
				}
			}
			System.out.println("#"+tc+" "+sb);
		}
	}
}
