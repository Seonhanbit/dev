package Test_1220;

import java.io.*;
import java.util.*;


/*내일은 현승이의 생일이다! 돈이 드는 선물은 준비하기 힘들고,

생색을 내기 위해 은지는 N 이하의 양의 정수를 하나 선물하기로 했다.

은지는 숫자 x와 y를 좋아하기 때문에, 선물하는 수를 x와 y로 이루어진 수로 만들고 싶다.

(x 또는 y로 수를 만들거나, x, y 모두 사용하여 수를 만들 수 있음)

선물하는 것이 가능한 정수 중에서 가장 큰 수를 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 N, x, y(1 ≤ N ≤ 10100,000, 0 ≤ x < y ≤ 9)가 공백 하나로 구분되어 주어진다.

N은 0으로 시작하지 않는다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 선물할 수 있는 수 중에서 가장 큰 수를 출력한다.

만약 선물할 수 있는 수가 없으면, -1을 출력한다.*/

public class Solution_03 {
	static long N, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			N = Long.parseLong(str);
			arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			ans = Long.MIN_VALUE;
	
			re_perm(0, new int[str.length()]);
			if (ans == Long.MIN_VALUE)
				ans = -1;
			bw.append("#" + tc + " " + ans + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void re_perm(int c, int[] result) {
		if (c == result.length) {
			String str = "";
			for (int i = 0; i < result.length; i++)
				str += result[i];
			long a = Long.parseLong(str);
			if (a < N && a != 0) {
				ans = Math.max(ans, a);
			}
			// System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			result[c] = arr[i];
			re_perm(c + 1, result);
		}
	}

}
