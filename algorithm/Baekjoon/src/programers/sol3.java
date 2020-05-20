package programers;

import java.io.*;
import java.util.*;

public class sol3 {
	static int[] numbers = { 10, 40, 30, 20 };
	static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = 20;
		int cnt = solution();

		bw.append(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

	static int[] number, check;
	static boolean[] ck;
	static int min;

	public static int solution() {
		number = new int[numbers.length];
		check = new int[numbers.length];
		ck = new boolean[numbers.length];
		min = Integer.MAX_VALUE;
		sol(0);
		return min;
	}

	public static void sol(int cnt) {
		if (cnt == numbers.length) {
			int res = check();
			if (min > res)
				min = res;
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!ck[i]) {
				ck[i] = true;
				check[cnt] = i + 1;
				number[cnt] = numbers[i];
				sol(cnt + 1);
				ck[i] = false;
			}
		}
	}
	
	public static int check() {
		boolean flag = true;
		int cnt = 0;
		for(int i=1; i<numbers.length; i++) {
			if(Math.abs(number[i-1]-number[i])<K) {
				flag = false;
				break;
			}
		}
		if(flag) {
			for(int i=0;i<numbers.length; i++) {
				if(check[i]!=i)
					cnt++;
			}
		}
		cnt /=2;
		return cnt;
	}
}
