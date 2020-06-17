package june;

import java.io.*;
import java.util.*;

public class p3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };
		solution(6, arr1, arr2);
	}

	public static int solution(String[][] clothes) {
		int answer = clothes.length;
		return answer;
	}

	static void combination(int[] arr, int n, int c, int[] sel) {
		int answer = 0;
		if (c == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		if (n == arr.length) {
			return;
		}

		sel[c] = arr[n];
		combination(arr, n + 1, c + 1, sel);
		combination(arr, n + 1, c, sel);
	}
}
