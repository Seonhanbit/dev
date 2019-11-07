import java.io.*;
import java.util.*;
//경사로....
public class Baek_14890 {
	static int N, L, res;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			boolean ck = true;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] != arr[i][j + 1]) {
					
				}
			}
			if (ck && cnt == N)
				res++;
		}

		bw.append(res + "\n");
		bw.flush();
		bw.close();
	}
}
