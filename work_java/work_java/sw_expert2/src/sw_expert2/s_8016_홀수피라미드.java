package sw_expert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s_8016_홀수피라미드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int su = (n*2)-1;
			int min = 0, max = 0;
			if(su ==1) {
				System.out.println("#"+tc+" "+1);
			}else {
				int sum = 0;
				for(int i=1; i<=su; i++) {
					if(i%2!=0)
						sum+=i;
				}
				min = (sum-su)*2 +1;
				max = sum*2 -1;
				System.out.println("#"+tc+" "+min+" "+max);
			}

		}
	}
}
