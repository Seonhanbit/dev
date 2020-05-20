package march;

import java.io.*;
import java.util.*;

public class s1107_리모컨 {
	static int N, M, res, min;
	static String str;
	static boolean[] broken;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		broken = new boolean[10];
		res = Math.abs(N - 100);
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				broken[Integer.parseInt(st.nextToken())] = true;
		}

		// 고장난 채널을 index로 고장날 시 -1을 넣어준다.
		// 먼저 100일때는 채널 옮길 필요가 없엉
		if (N == 100) {
			res = 0;
		} else {
			// 아닐떄는 가고 싶은 채널을 찾아야해
			// 초기에 누를 수 있는 모든 숫자를 고려(0<=N<=500,000)
			// 숫자판이 고장난 경우
			for (int i = 0; i < 999999; i++) {
				int cnt = check(i);
				if (cnt > 0) {
					// 누를 수 있다면
					int len = Math.abs(i - N);
					res = Math.min(res, cnt + len);
				}
			}
		}
		bw.append(String.valueOf(res));
		bw.flush();
		bw.close();
	}

	/**
	 * 숫자판 버튼을 눌러서 num 숫자를 완성할 수 있는지 판별하는 메서드 누를 수 없다면 0, 누를 수 있으면 몇번 눌렀는지 몇번 눌렀는지
	 * 회수를 리턴
	 * 
	 * @param num
	 */
	public static int check(int num) {
		// num 숫자를 누를 수 있는지 한자리씩(1의자리부터) 짤라내서 확인
		int cnt = 0; // 누를 수 있다면, 버튼을 누른 회수 누적
		while (num > 0) {// 자리수 만큼 반복하기
			if (broken[num % 10]) {
				// 숫자 버튼이 깨졌는지 확인
				return 0;
			}
			num /= 10;
			cnt++;
		}
		return cnt;
	}
}
