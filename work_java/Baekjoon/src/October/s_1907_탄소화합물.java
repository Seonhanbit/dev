package October;

import java.io.*;
import java.util.*;

public class s_1907_탄소화합물 {
	// 계수는 10이하라서 10번 중복순열 돌려보기
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int[] C, H, O;
	// 결과 값 저장
	static int x1, x2, x3;
	static boolean bk = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] input = str.split("\\+|\\=");
		// C,H,O 값을 담아줄 배열 준비
		// 인덱스 0 + 인덱스 1 = 인덱스 2
		C = new int[3];
		H = new int[3];
		O = new int[3];

		// C,H,O 값을 받아주기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < input[i].length(); j++) {
				if (input[i].charAt(j) == 'C') {
					if (j + 1 < input[i].length()) {
						int num = input[i].charAt(j + 1) - '0';
						if (9 >= num && num >= 1) {
							C[i] += num;
						}
						else {
							C[i] += 1;
						}
					} else {
						C[i] += 1;
					}
				} else if (input[i].charAt(j) == 'H') {
					if (j + 1 < input[i].length()) {
						int num = input[i].charAt(j + 1) - '0';
						if (9 >= num && num >= 1) {
							H[i] += num;
						}
						else {
							H[i] += 1;
						}
					} else {
						H[i] += 1;
					}
				} else if (input[i].charAt(j) == 'O') {
					if (j + 1 < input[i].length()) {
						int num = input[i].charAt(j + 1) - '0';
						if (9 >= num && num >= 1) {
							O[i] += num;
						}
						else {
							O[i] += 1;
						}
					} else {
						O[i] += 1;
					}
				}
			}
		}


		if (C[0] + C[1] == C[2] && H[0] + H[1] == H[2] && O[0] + O[1] == O[2]) {
			System.out.println(1 + " " + 1 + " " + 1);
		} else {
			re_perm(0, new int[3]);
			System.out.println(x1 + " " + x2 + " " + x3);
		}
	}

	static void re_perm(int c, int[] result) {
		if (bk)
			return;
		if (c == result.length) {
			int[] nc = new int[3];
			int[] nh = new int[3];
			int[] no = new int[3];
			System.arraycopy(C, 0, nc, 0, C.length);
			System.arraycopy(H, 0, nh, 0, H.length);
			System.arraycopy(O, 0, no, 0, O.length);
			for (int i = 0; i < 3; i++) {
				nc[i] = result[i] * nc[i];
				nh[i] = result[i] * nh[i];
				no[i] = result[i] * no[i];
			}
			if (nc[0] + nc[1] == nc[2] && nh[0] + nh[1] == nh[2] && no[0] + no[1] == no[2]) {
				x1 = result[0];
				x2 = result[1];
				x3 = result[2];
				bk = true;
			}
			return;
		}
		// 원소만큼 돌아줘야해
		for (int i = 0; i < arr.length; i++) {
			result[c] = arr[i];
			re_perm(c + 1, result);
		}
	}

}
