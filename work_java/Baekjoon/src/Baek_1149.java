import java.io.*;
import java.util.*;

public class Baek_1149 {
	static int N, result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		int sum = 0;
		int su = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(su>arr[i][j]) {
					su=arr[i][j];
					index = i;
				}
			}
		}
		sum+=su;
		su = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j==index)
					continue;
				if(su>arr[i][j])
					su=arr[i][j];
			}
		}
		sum+=su;

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}

}
