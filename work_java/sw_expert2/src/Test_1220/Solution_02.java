package Test_1220;

import java.io.*;
import java.util.*;

/*1번부터 N번까지 번호가 붙여져 있는 학생들에 대하여 두 학생끼리 키를 비교한 결과의 일부가 주어져 있다.

단, N명의 학생들의 키는 모두 다르다고 가정한다.

예를 들어, 6명의 학생들에 대하여 6번만 키를 비교하였고, 그 결과가 다음과 같다고 하자.

● 1번 학생의 키 < 5번 학생의 키
● 3번 학생의 키 < 4번 학생의 키
● 5번 학생의 키 < 4번 학생의 키
● 4번 학생의 키 < 2번 학생의 키
● 4번 학생의 키 < 6번 학생의 키
● 5번 학생의 키 < 2번 학생의 키

이 비교 결과로부터 모든 학생 중에서 키가 가장 작은 학생부터 자신이 몇 번째인지 알 수 있는 학생들도 있고

그렇지 못한 학생들도 있다는 사실을 아래처럼 그림을 그려 쉽게 확인할 수 있다.

a번 학생의 키가 b번 학생의 키보다 작다면, a에서 b로 화살표를 그려서 표현하였다.

 

1번은 5번보다 키가 작고, 5번은 4번보다 작기 때문에, 1번은 4번보다 작게 된다.

그러면 1번, 3번, 5번은 모두 4번보다 작게 된다.

또한 4번은 2번과 6번보다 작기 때문에, 4번 학생은 자기보다 작은 학생이 3명이 있고,

자기보다 큰 학생이 2명이 있게 되어 자신의 키가 몇 번째인지 정확히 알 수 있다.

그러나 4번을 제외한 학생들은 자신의 키가 몇 번째인지 알 수 없다.

학생들의 키를 비교한 결과가 주어질 때, 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산하여 출력하는 프로그램을 작성하시오.


[입력]
첫 줄에 테스트케이스의 개수 T가 주어진다. (1 ≤ T ≤ 15)

각 테스트 케이스의 첫 번째 줄에 학생들의 수 N이 주어진다. (2 ≤ N ≤ 500)

각 테스트 케이스의 두 번째 줄에 두 학생의 키를 비교한 횟수 M이 주어진다. (0 ≤ M ≤ N*(N-1)/2)

각 테스트 케이스의 세 번째 줄부터 M개의 줄에 걸쳐 두 학생의 키를 비교한 결과를 나타내는 두 양의 정수 a, b가 주어진다.

이는 번호가 a인 학생이 번호가 b인 학생보다 키가 작은 것을 의미한다. 이 때, 입력은 항상 모순이 없도록 주어진다.

[출력]
각 테스트케이스마다 한 줄에 걸쳐, 테스트케이스 수 “#(TC) “를 출력하고,

자신이 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지를 출력한다.

*/

public class Solution_02 {
	static int N, M, ans;
	static int[][] arr;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N + 1][N + 1];
			ans = 0;

			for (int i = 0; i < M; i++) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}

			for (int i = 1; i < N + 1; i++) {
				bfs(i);
				boolean flag = ck();
				if (flag)
					ans++;
			}
			bw.append("#" + tc + " " + ans + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void bfs(int n) {
		check = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		check[n] = true;
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int j = 1; j < N + 1; j++) {
				if (arr[tmp][j] == 1&&!check[j]) {
					queue.add(j);
					check[j] = true;
				}
			}
		}
		queue.add(n);
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int j = 1; j < N + 1; j++) {
				if (arr[j][tmp] == 1&&!check[j]) {
					queue.add(j);
					check[j] = true;
				}
			}
		}
	}

	static public boolean ck() {
		boolean flag = true;
		out: for (int i = 1; i < check.length; i++) {
			if (!check[i]) {
				flag = false;
				break out;
			}
		}
		return flag;
	}
}
