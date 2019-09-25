package argotithm4;

import java.util.Arrays;
import java.util.Scanner;

public class DP_배낭문제_메모 {
	static int N, K;
	static int[] weights;
	static int[] values;

	public static void main(String[] args) {
		// 일단 그냥 재귀함수를 구현
		// 재귀 함수가 호출될때 전달해지는 매개변수를 보면 해당 상태를 구분할 수 있음
		// 해당 매개변수 상태를 구분할 수 있는 배열 혹은 해쉬맵을 준비해서 거기다가 상태에 대한 정보를 저장
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 아이템의 갯수 1≤N100
			K = sc.nextInt(); // 배낭의 최대부피 1≤K≤1000
			weights = new int[N];
			values = new int[N];

			for (int i = 0; i < N; i++) {
				weights[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			memo = new int[N][K + 1];
			for(int i = 0; i < N; i++)
				Arrays.fill(memo[i], -1);
			System.out.println("#" + tc + " " + dfs(0, 0));
			dfs(0,0);
			dfs(0,0,0);
			
		}
	}

	static int memoCnt = 0; //테스트 용
	static int nonMemoCnt = 0; //테스트 용
	static int[][] memo;

	static int dfs(int idx, int weight) {
		if (idx == N) {
			// 갯수를 셀떄는 1개를 리턴
			return 0;
		}
		//이미 값을 알고 있기때문에 더 적게 호출할 수 있음
		if (memo[idx][weight] != -1)
			return memo[idx][weight];
		memoCnt++;
		// 못담음
		if (weight + weights[idx] > K) {
			memo[idx][weight] = dfs(idx + 1, weight);
			return memo[idx][weight];
		} else {
			//올라가면서 value값을 더하기 
			//리턴하기 직전에 그 상태의 최선의 값을 알 수 있음
			//두번 호출하기 Math.max(안담고, 담고)
			memo[idx][weight] = Math.max(dfs(idx + 1, weight), values[idx] + dfs(idx + 1, weight + weights[idx]));
			return memo[idx][weight];
		}
	}

	// 상태는 검사 중인 아이템의 번호, 지금까지 무게, 지금까지 가치
	static void dfs(int idx, int weight, int value) {
		nonMemoCnt++;
		if (idx == N) {
			return;
		}
		dfs(idx + 1, weight, value);
		dfs(idx + 1, weight + weights[idx], value + values[idx]);
	}

}
