package August;

import java.util.Arrays;
import java.util.Scanner;

public class s_15649_n과m {

	static boolean[] ck;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 자연수 N과 M이 주어졌을때, 중복없이 m개를 고른 수열 출력
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		ck = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}

		String str = "";
		dfs(arr, n, m, str);
	}

	static void dfs(int[] arr, int n, int m, String str) {
		if (str.length() == m) {
			for(int i=0; i<str.length(); i++) {
				System.out.print(str.charAt(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i =0; i<n; i++) {
			if(ck[i] == false) {
				//한번이라도 온 적 있나 검사하기 
				ck[i] = true;
				dfs(arr, n, m, str+arr[i]);
				ck[i] = false;
			}
		}
	}
}
