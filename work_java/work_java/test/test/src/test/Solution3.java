package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//원자소멸시뮬
public class Solution3 {
	static class info implements Comparable<info> {
		int x;
		int y;
		int dic;
		int power;

		public info(int a, int b, int c, int d) {
			x = a;
			y = b;
			dic = c;
			power = d;
		}

		@Override
		public int compareTo(info o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "info [x=" + x + ", y=" + y + ", dic=" + dic + ", power=" + power + "]";
		}

	}

	static boolean range(int x, int y) {
		if (x > 1999 || y > 1999 || x < 0 || y < 0)
			return true;
		else
			return false;
	}

	public static void main(String args[]) throws Exception {
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			info[] arr = new info[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new info(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				System.out.println(arr[i]);
			}
			int sum = 0;
			int cnt = 9;
			while (cnt != 0) {
				for (int i = 0; i < n; i++) {
					if (arr[i] != null) {
						if (arr[i].dic == 0) {
							arr[i].y += 1;
						}
						if (arr[i].dic == 1) {
							arr[i].y -= 1;
						}
						if (arr[i].dic == 2) {
							arr[i].x -= 1;
						}
						if (arr[i].dic == 3) {
							arr[i].x += 1;
						}
					}
				}
				System.out.println("==================");
				for (int i = 0; i < n; i++) {
					System.out.println(arr[i]);
				}
				for (int i = 0; i < n-1; i++) {
					boolean bb = false;
					for (int j = i + 1; j < n; j++) {
						if (arr[i] != null && arr[j] != null) {
							if (arr[i].x == arr[j].x && arr[i].y == arr[j].y) {
								sum +=arr[j].power;
								arr[j] = null;
								bb=true;
							}
							else if (arr[i].x == arr[j].x) {
								if (arr[i].dic == 0 && arr[j].dic == 1) {
									sum += arr[j].power;
									arr[j] = null;
									bb = true;
								}
							}
							else if (arr[i].y == arr[j].y) {
								if (arr[i].dic == 3 && arr[j].dic == 2) {
									sum += arr[j].power;
									arr[j] = null;
									bb = true;
								}
							}

						}
					}
					if (bb) {
						sum += arr[i].power;
						arr[i] = null;
					}
					System.out.println(sum+" : sum");
				}
				cnt--;
			}
			System.out.println(sum);

//			int cnt = 9;
//			while (cnt!=0) {
//				// 1초 지남
//				for (int i = 0; i < n; i++) {
//					if (arr[i] != null) {
//						if (arr[i].dic == 0) {
//							arr[i].y += 1;
//						}
//						if (arr[i].dic == 1) {
//							arr[i].y -= 1;
//						}
//						if (arr[i].dic == 2) {
//							arr[i].x -= 1;
//						}
//						if (arr[i].dic == 3) {
//							arr[i].x += 1;
//						}
//					}
//				}
//				System.out.println("==================");
//				for (int i = 0; i < n; i++) {
//					System.out.println(arr[i]);
//				}
//				for (int i = 0; i < n - 1; i++) {
//					boolean bb =false;
//					for (int j = i + 1; j < n; j++) {
//						if (arr[i] != null&&arr[j]!=null) {
//							if (arr[i].x == arr[j].x && arr[i].y == arr[j].y) {
//								sum +=arr[j].power;
//								arr[j] = null;
//								bb=true;
//							}
//						}
//					}
//					if(bb) {
//						sum+=arr[i].power;
//						arr[i] = null;
//					}
//				}
//				System.out.println(sum+" : sum");
//				cnt--;
//			}

			System.out.println("#" + tc + " " + sum);
		}
	}
}
