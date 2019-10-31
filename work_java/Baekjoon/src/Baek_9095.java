import java.io.*;
import java.util.*;

public class Baek_9095 {
	static int T, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr = new int[12];
		arr[1] = 1; // 1 ->1개
		arr[2] = 2; // 1+1, 2 ->1개
		arr[3] = 4; // 1+1+1,1+2,2+1, 3 ->1개
		for (int i = 4; i < 12; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			bw.append(arr[N] + "\n");
			bw.flush();
		}
		bw.close();
	}
}
