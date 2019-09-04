package D4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class s_4408_자기방으로2 {
	static class XY {
		int x;
		int y;

		public XY(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();

			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] == o2[0])
						return o1[1] - o2[1];
					return o1[0] - o2[0];
				}
			});
			
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[0] == o2[0])
						return o2[1] - o1[1];
					return o2[0] - o1[0];
				}

			});
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
