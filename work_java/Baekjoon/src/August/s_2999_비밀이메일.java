package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();

		int r = Integer.MIN_VALUE, c = 0;
		for (int i = 1; i < n / 2 - 1; i++) {
			for (int j = 1; j <= n; j++) {
				if (i <= j && i * j == n) {
					if (r < i) {
						r = i;
						c = j;
					}
				}
			}
		}

//		for (int i = n / 2; i >= 1; i--) {
//			for (int j = i; j <= n; j++) {
//				if (i<=j && i*j==n) {
//					r = i;
//					c = j;
//					i=0;
//					break;
//				}
//			}
//		}

		char[][] arr = new char[r][c];
		StringBuilder sb = new StringBuilder();
		int k = 0;
		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				arr[i][j] = str.charAt(k++);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
//				System.out.print(arr[i][j]);
				if (arr[i][j] != '\0')
					sb.append(arr[i][j]);
			}
//			System.out.println();
		}

//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				sb.append(str.charAt(r * j + i));
//			}
//		}

		System.out.println(sb);

	}

}
