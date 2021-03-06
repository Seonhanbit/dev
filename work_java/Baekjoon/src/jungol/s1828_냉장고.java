package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1828_냉장고 {
	static class XY implements Comparable<XY> {
		int x;
		int y;

		public XY(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(XY o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		XY[] arr = new XY[n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			arr[i] = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}

		int cnt = 0;
		while (true) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (arr[i] != null && min > arr[i].y)
					min = arr[i].y;
			}
			for (int i = 0; i < n; i++) {
				if (arr[i]!=null&&arr[i].x <= min && min <= arr[i].y)
					arr[i] = null;
			}
			if (min == Integer.MAX_VALUE) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
