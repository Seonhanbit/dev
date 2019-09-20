package D4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class s_4408_자기방으로 {
	static class XY implements Comparable<XY> {
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

		@Override
		public int compareTo(XY o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			XY[] arr = new XY[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new XY(sc.nextInt(), sc.nextInt());
			}
			for (int i = 0; i < n; i++) {
				if(arr[i].x>arr[i].y) {
					int tmp = arr[i].x;
					arr[i].x = arr[i].y;
					arr[i].y = tmp;
				}
				
				if (arr[i].x % 2 == 0) {
					arr[i].x -= 1;
				}
				if (arr[i].y % 2 == 0) {
					arr[i].y -= 1;
				}
			}			
					
			Arrays.sort(arr);
			int cnt = 0;
			while (true) {
				boolean bk = false;
				int ny = 0;
				for (int i = 0; i < n; i++) {
					if (arr[i] != null) {
						if (ny < arr[i].x) {
							bk = true;
							ny = arr[i].y;
							arr[i] = null;
						}
					}
				}
				if (bk == false)
					break;
				else
					cnt++;
			}
			System.out.println("#" + tc + " "+cnt);
		}
	}
}
