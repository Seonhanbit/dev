package November;

import java.io.*;
import java.util.*;

public class baek_2439 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt = N;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (cnt > j)
					sb.append(" ");
				else
					sb.append("*");
			}
			cnt--;
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
