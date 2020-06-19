package june;

import java.io.*;
import java.util.*;

public class p4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };
		solution("1231234", 3);
	}

	static int num = 0;

	public static String solution(String number, int k) {
		String answer = "";
		char[] tmp = number.toCharArray();
		int[] arr = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			arr[i] = tmp[i] - '0';
		}
		int n = number.length()-k;
		combi(arr, 0, 0, new int[n]);
		answer = String.valueOf(num);
		System.out.println(answer);
		return answer;
	}

	public static void combi(int[] arr, int n, int r, int[] sel) {
		if (r == sel.length) {
			String str = "";
			for (int i = 0; i < sel.length; i++) {
				str += sel[i];
			}
			if (Integer.parseInt(str) > num)
				num = Integer.parseInt(str);
			return;
		}
		if (n == arr.length)
			return;
		sel[r] = arr[n];
		combi(arr, n + 1, r + 1, sel);
		combi(arr, n + 1, r, sel);
	}
	
	public static String solution1(String number, int k) {
	    int idx = 0;
	    char max;
		StringBuilder answer = new StringBuilder();

		if(number.charAt(0) == '0') return "0";
		for(int i = 0; i < number.length() - k; i++) {
			max = '0';
			for(int j = idx; j <= k + i; j++) {
		        	if(max < number.charAt(j)) {
		        		max = number.charAt(j); idx = j + 1;
		        	}
			}			
			answer.append(max);
		}
	        return answer.toString();
		}
	
	public static String solution2(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		int delCount = 0;
		int index = 1;
		int i = 0;
		
		while(delCount != k) {
			
			// 4 1 7 7 ... <- 1 7 비교해서 뒤에 숫자가 더 크면 앞 숫자 제거
			// 제거했으니 앞 index(4, 7)를 비교하기 위해 index --, 
			// 제거한 delCount ++;
			if(index >= 1 && sb.charAt(index-1) < sb.charAt(index)) {
				sb.deleteCharAt(index-1);
				index --;
				delCount ++;
			}
			else {
				// index가 가장 끝값일때
				if(index == sb.length() - 1 && sb.charAt(index) <= sb.charAt(index-1)) {
					sb.deleteCharAt(index);
					delCount ++;
					index --;
				}
				else {
					index ++;
				}
			}
		}
		
		return sb.toString();
	}
}
