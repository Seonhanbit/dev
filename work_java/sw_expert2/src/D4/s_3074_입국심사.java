package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_3074_입국심사 {
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				if (arr[i] > max)
					max = arr[i];
			}
			long left = 1;
			long right = (long) max * M;
			while (left <= right) {
				long mid = (left+right)/2;
				long res = 0;
				for(int i=0; i<N; i++)
					res+=mid/arr[i];
				if(res<M) //내가 처리하는 애들보다 작으면
					left=mid+1;
				else
					right=mid-1;
			}
			System.out.println("#"+tc+" "+left);
		}
	}
}
