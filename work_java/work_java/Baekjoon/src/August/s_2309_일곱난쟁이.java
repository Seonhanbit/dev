package August;

import java.util.Arrays;
import java.util.Scanner;

public class s_2309_일곱난쟁이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(arr, 0, 0, new int[7]);
	}

	static boolean isFinished = false;
	static void combination(int[] arr, int n, int c, int[] sel) {
		if (c == sel.length) {
			if(isFinished) return;
			
			// 조건 검사를 통해 재껴내는것
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if (sum == 100) {
				isFinished = true;
				Arrays.sort(sel);
				for(int s : sel)
					System.out.println(s);
//				for(int i=0; i<sel.length; i++) {
//					System.out.println(sel[i]);
//				}
			}
			return;
		}

		if (n == arr.length) { //끝
			return;
		}

// n번쨰에 대해서 sel에 담고 지나가기
		sel[c] = arr[n];
		combination(arr, n + 1, c + 1, sel);
// n번쨰에 대해서 sel에 안담고 지나가기
		combination(arr, n + 1, c, sel);
	}
}
