package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1009_분산처리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int res = 1;
			for(int i=1; i<=b%10; i++) {
				res*=a;
			}
//			System.out.println(res%10);
			System.out.println((int)Math.pow(a, b%10)%10);
		}
	}

}
