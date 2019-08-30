package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_4789_성공적인공연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int[] arr = new int[str.length()];
			int res = 0;

			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) - '0';
			}
			int sum = arr[0]; // 박수친사람
			for (int i = 1; i < arr.length; i++) {
				if (sum >= i)
					sum += arr[i];
				else {
//					arr[i]+=i-sum;
					res += i - sum;
					sum += (i-sum)+arr[i];
				}
			}
			

			System.out.println("#" + tc + " " + res);
		}
	}
}
