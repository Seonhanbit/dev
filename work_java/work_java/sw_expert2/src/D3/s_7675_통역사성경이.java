package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_7675_통역사성경이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int idx = 0; // 현재 몇번쨰 줄인지
//			while(idx <n) {
//				String word = sc.next();
//				char last = word.charAt(word.length()-1);
//				if(last == '.'||last == '?'||last == '!') {
//					idx++;
//				}
//			}

			String str = br.readLine();
			String[] s_arr = str.split(" ");
			int nn = n;
			int sum = 0;
			while (nn != 0) {
				for (int i = 0; i < s_arr.length; i++) {
					for (int j = 0; j < s_arr[i].length(); j++) {
						char ch = s_arr[i].charAt(0);
						char end = s_arr[i].charAt(s_arr[i].length()-1);
						if (Character.isUpperCase(ch) == true) {
							int cnt = 1;
							for (int l = j + 1; l < s_arr[i].length(); l++) {
								if (Character.isLowerCase(s_arr[i].charAt(l)) == false ||
										(Character.isDigit(s_arr[i].charAt(l)) == true)) {
									break; 
//									if (end == '.' || end == '!' || end == '?') {
//										sum+=1;
//									}
//									System.out.println(cnt);
								}
								else {
									cnt++;
								}
							}
							if (cnt == s_arr[i].length())
								sum += 1;
						}
//						System.out.println(s_arr[i]);
//						System.out.println("sum " + sum);
						if (end == '.' || end == '!' || end == '?') {
							int cnt = 1;
							for (int l = j + 1; l < s_arr[i].length()-1; l++) {
								if (Character.isLowerCase(s_arr[i].charAt(l)) == false ||
										(Character.isDigit(s_arr[i].charAt(l)) == true)) {
									break; 
//									if (end == '.' || end == '!' || end == '?') {
//										sum+=1;
//									}
//									System.out.println(cnt);
								}
								else {
									cnt++;
								}
							}
							if (cnt == s_arr[i].length())
								sum += 1;
							
							arr[n - nn] = sum;
							sum = 0;
							nn--;
						}
					}
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}
	}

}
