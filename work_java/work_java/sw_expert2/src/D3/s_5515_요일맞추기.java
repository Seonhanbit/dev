package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_5515_요일맞추기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			StringTokenizer sto = new StringTokenizer(str);
			int month = Integer.parseInt(sto.nextToken());
			int date = Integer.parseInt(sto.nextToken());

//			int[] arr = { 0, 4, 5, 6, 0, 1, 2, 3 };
			int[] mon = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

//			int a = month - 1;
			int total_days = 0;
			for (int i = 1; i <month; i++) {
				total_days += mon[i];
			}
			total_days += date-1;

			int result =(4+total_days)%7;
			System.out.println("#"+tc+" "+result);
		}
	}
}
