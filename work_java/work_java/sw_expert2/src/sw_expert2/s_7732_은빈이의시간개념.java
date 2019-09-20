package sw_expert2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s_7732_은빈이의시간개념 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] s1 = br.readLine().split(":");
			String[] s2 = br.readLine().split(":");
			int result[] = new int[3];

			int a = 0, b = 0;
			a = Integer.parseInt(s1[0]) * 3600 + Integer.parseInt(s1[1]) * 60 + Integer.parseInt(s1[2]);
			b = Integer.parseInt(s2[0]) * 3600 + Integer.parseInt(s2[1]) * 60 + Integer.parseInt(s2[2]);
			int res = 0;
			if (b > a) {
				res = b - a;
			} else {
				res = 86400 -( a - b);
				
			}
			result[0] = res / 3600;
			result[1] = (res % 3600) / 60;
			result[2] = (res % 3600) % 60;
			System.out.printf("#%d %02d:%02d:%02d\n", tc, result[0], result[1], result[2]);
		}
	}
}
