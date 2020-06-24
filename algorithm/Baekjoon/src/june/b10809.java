package june;

import java.io.*;
import java.util.*;

public class b10809 {
	static int N;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine();
		char[] res = str.toCharArray();
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int[] result = new int[26];
		Arrays.fill(result, -1);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (res[i] == arr[j]&&result[j]==-1) {
					result[j] = i;
					break;
				}
			}
		}
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j]+" ");
		}
	}

}
