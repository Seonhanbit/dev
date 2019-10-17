package October;

import java.io.*;
import java.util.*;

public class s_14889_스타트와링크 {
	static int N, min;
	static int[][] arr;
	static int[] arr1;
	static int[] res;
	static ArrayList<Integer> queue1; // 첫번째 그룹
	static ArrayList<Integer> queue2; // 두번쨰 그룹

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		arr1 = new int[N]; // 그룹 사람들
		res = new int[N / 2]; // 스타트와 링크팀으로 나눌 집합
		queue1 = new ArrayList<>(); // 스타트팀
		queue2 = new ArrayList<>(); // 링크팀
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr1[i] = i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0, 0);
		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}

	static void combi(int n, int c) {
		if (c == res.length) {
			// 스타트팀은 res에 담겨져 있음
			for (int i = 0; i < res.length; i++) {
				queue1.add(res[i]);
			}
			// 링크팀은 스타트팀에 포함되지 않은 arr1사람들..
			for (int i = 0; i < arr1.length; i++) {
				if (!queue1.contains(arr1[i]))
					queue2.add(arr1[i]);
			}
			// sum함수를 불러주자
			int sum = sum();
			// 제일 작은 값 비교
			if (sum < min)
				min = sum;
			// 리스트는 다시 돌때 클리어해주기
			queue1.clear();
			queue2.clear();
			return;
		}
		if (n == arr1.length)
			return;
		res[c] = arr1[n];
		combi(n + 1, c + 1);
		combi(n + 1, c);
	}

	static int sum() {
		int sum1 = 0; // 스타트팀 합
		int sum2 = 0; // 링크팀 합

/*		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (queue1.contains(i) && queue1.contains(j))
					sum1 += arr[i][j];
				if (queue2.contains(i) && queue2.contains(j))
					sum2 += arr[i][j];
			}
		}*/

		int a = queue1.size(); // 절반
		for (int i = 0; i < queue1.size(); i++) {
			if (a == 0) // 절반만 돌거야
				break;
			int aa = N / 2; // j도 절반만..
			for (int j = i + 1; j < queue1.size(); j++) {
				if (aa == 0)
					break;
				sum1 += arr[queue1.get(i)][queue1.get(j)];
				aa--;
			}
			// 리스트 인덱스는 올라가니까 추가해주면서 다음 팀원들도 보기
			queue1.add(queue1.get(i));
			a--;
		}
		int b = queue2.size(); // 절반
		for (int i = 0; i < queue2.size(); i++) {
			if (b == 0)
				break;
			int bb = N / 2;
			for (int j = i + 1; j < queue2.size(); j++) {
				if (bb == 0)
					break;
				sum2 += arr[queue2.get(i)][queue2.get(j)];
				bb--;
			}
			queue2.add(queue2.get(i));
			b--;
		}
		// 차이값 리턴하기
		if (sum1 > sum2)
			return sum1 - sum2;
		else
			return sum2 - sum1;
	}

}
