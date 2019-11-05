package November;

import java.io.*;
import java.util.*;

public class baek_2446 {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < i; j++)
				bw.write(" ");
			for (int j = 0; j < (N - i) * 2 + 1; j++)
				bw.write("*");
			bw.write("\n");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N - i; j++)
				bw.write(" ");
			for (int j = 0; j < i * 2 + 1; j++)
				bw.write("*");
			bw.write("\n");
		}
		bw.flush();
	}

}
