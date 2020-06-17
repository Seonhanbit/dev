package june;

import java.io.*;
import java.util.*;

public class p01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr1 = { 46, 33, 33 ,22, 31, 50 };
		int[] arr2 = {27 ,56, 19, 14, 14, 10 };
		solution(6, arr1, arr2);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		char[][] result = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str2 = Integer.toBinaryString(arr1[i]);
			String str3 = Integer.toBinaryString(arr2[i]);
			String on = "0";
			int s = n - str2.length();
			int s1 = n - str3.length();
			for (int j = 0; j < s - 1; j++) {
				on += "0";
			}
			if (str2.length() < n) {
				str2 = on.concat(str2);
			}
			on = "0";
			for (int j = 0; j < s1 - 1; j++) {
				on += "0";
			}
			char[] str = str2.toCharArray();
			if (str3.length() < n) {
				str3 = on.concat(str3);
			}
			char[] str1 = str3.toCharArray();

			for (int j = 0; j < n; j++) {
				if (str[j] == '1')
					result[i][j] = '#';
				if (str1[j] == '1')
					result[i][j] = '#';
			}
		}
		for (int i = 0; i < n; i++) {
			String ans = "";
			for (int j = 0; j < n; j++) {
				ans += result[i][j];
			}
			answer[i] = ans;
			System.out.println(answer[i]);
		}
		return answer;

	}
}
