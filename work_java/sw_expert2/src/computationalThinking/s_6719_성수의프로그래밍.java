package computationalThinking;

import java.io.*;
import java.util.*;

public class s_6719_성수의프로그래밍 {
	static int N, K, A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = 0;
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int n = 1;
			float result = 0f;
			for (int i = arr.length-K; i <arr.length; i++) {
				result = (result+arr[i])/2;
				if(n==K)
					break;
				n++;
			}
			System.out.print("#"+tc+" ");
			System.out.format("%6f", result);
			System.out.println();
			//String str = String.format("%6f", result);
			//bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(tc)).append(str+"\n");
			//bw.flush();
		}
		bw.close();
	}
}
