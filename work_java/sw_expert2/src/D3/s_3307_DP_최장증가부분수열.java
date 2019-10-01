package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_3307_DP_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n + 1];
			int[] res = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			int re = Integer.MIN_VALUE;
			for (int i = 1; i < n + 1; i++) {
				boolean bk = false;
				int max = Integer.MIN_VALUE;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						cnt = res[j];
						if(cnt >max)
							max = cnt;
						bk = true;
					}
				}
				if (bk) {
					res[i] = max + 1;
				}
			}
			Arrays.sort(res);
			System.out.println("#" + tc + " " + res[n]);
		}
	}
	
/*	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] lis = new int[N];
			int ans = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				//내 앞에놈들을 검사하면서
				int max = 0;
				for(int j = 0; j < i; j++) {
					//나보다 작은놈 중에서 가장 긴 증가수열의 길이를 갖고 있는 놈을 찾자.
					if( arr[j] < arr[i] && max < lis[j] ) {
						max = lis[j];
					}
				}
				//걔 뒤에 붙으면 내가 가질 수 있는 가장 긴 증가수열의 길이
				lis[i] = max + 1;
				ans = Math.max(ans, lis[i]);
			}
			System.out.println("#" + tc + " " + ans); 
		}
	}*/

}
