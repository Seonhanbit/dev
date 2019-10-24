package computationalThinking;

import java.io.*;
import java.util.*;

public class s_6782_현주가좋아하는제곱근 {
	static int res;
	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Long.parseLong(br.readLine());
			res = 0;
			while (true) {
				//N이 2가 되면 멈추기
				if (N == 2)
					break;
				//루트N은  Math.sqrt(N)
				//Math.sqrt(N)정수일때는 %1은 0이야!(나머지가 0)
				//Math.sqrt(N)가 정수가 아니면
				if (Math.sqrt(N) % 1 > 0) {
					Long tmp = N;
					//가장 가깝고 큰 제곱근을 N에 넣어주기
					//(int) Math.sqrt(N)에 1을 더해주면 가장 가까운 제곱근을 구할 수 있음
					N = (long) Math.pow((int) Math.sqrt(N) + 1, 2);
					//그 차이를 res에 넣어야해
					res += N - tmp;
				}
				//다시 제곱근으로 돌아오고 바뀌었으니까  res++
				N = (long) Math.sqrt(N);
				res++;
			}
			bw.append("#").append(String.valueOf(tc)).append(" ").append(res + "\n");
			bw.flush();
		}
		bw.close();
	}
}
