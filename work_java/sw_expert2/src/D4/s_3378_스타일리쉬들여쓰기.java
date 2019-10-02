package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_3378_스타일리쉬들여쓰기 {
	static int p, q;
	static String[] good, bad;
	static int[] res; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			good = new String[p];
			bad = new String[q];
			res = new int[q];

			for (int i = 0; i < p; i++)
				good[i] = br.readLine();
			for (int i = 0; i < q; i++)
				bad[i] = br.readLine();
			//각 라인의 들여쓰기 계산 결과를 저장할 배열을 준비해두고, 초기 값 -2(아직 계산값 없음)
			//계산한 값이 나오면 그 값으로 대체
			//계산한 값이 또 나왔는데 -1가 아니라면 두개 이상의 경우이므로 -1로
			for (int i = 0; i < q; i++)
				res[i] = -2;
			//Arrays.fill(res,-2);

			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						// r,c,s 조합이 마스터문장 모든 라인에 대해서 수식을 만족하는가?!
						if (isGood(i, j, k))
							// 그 r,c,s로 각 라인별 들여쓰기 계산하기
							isBad(i, j, k);
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < res.length; i++)
				System.out.print(res[i] + " ");
			System.out.println();
		}
	}

	static boolean isGood(int r, int c, int s) {
		int tr = 0, tc = 0, ts = 0;

		for (int i = 0; i < p; i++) {
			int cnt = 0;
			int k = 0;
			for (int j = 0; j < good[i].length(); j++) {
				if (good[i].charAt(j) == '.')
					cnt++;
				else {
					k = j;
					break;
				}
			}
			if (tr * r + tc * c + ts * s != cnt)
				return false;
			// 다음 라인 들여쓰기 검사를 위한 현재라인 괄호 유무 체크
			for (int j = k; j < good[i].length(); j++) {
				if (good[i].charAt(j) == '(')
					tr++;
				else if (good[i].charAt(j) == ')')
					tr--;
				else if (good[i].charAt(j) == '{')
					tc++;
				else if (good[i].charAt(j) == '}')
					tc--;
				else if (good[i].charAt(j) == '[')
					ts++;
				else if (good[i].charAt(j) == ']')
					ts--;
			}
		}
		// 모든 라인이 끝날때까지 false아니면 멀쩡한거야
		return true;
	}

	static void isBad(int r, int c, int s) {
		int tr = 0, tc = 0, ts = 0, cnt = 0;

		for (int i = 0; i < q; i++) {
			if (res[i] == -2)
				res[i] = r * tr + c * tc + s * ts;
			//처음이 아닌데 다른 경우의 들여쓰기 횟수가 계산되면 두가지 이상이므로 알 수 없음
			else if(cnt!=res[i])
				res[i]=-1;

			for (int j = 0; j < bad[i].length(); j++) {
				if (bad[i].charAt(j) == '(')
					tr++;
				else if (bad[i].charAt(j) == ')')
					tr--;
				if (bad[i].charAt(j) == '{')
					tc++;
				else if (bad[i].charAt(j) == '}')
					tc--;
				if (bad[i].charAt(j) == '[')
					ts++;
				else if (bad[i].charAt(j) == ']')
					ts--;
			}
			cnt = r * tr + c * tc + s * ts;
		}
	}
}
