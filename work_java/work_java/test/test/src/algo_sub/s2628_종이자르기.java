package algo_sub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class s2628_종이자르기 {
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
		int a = sc.nextInt();
		int b = sc.nextInt();
//		int[][] arr = new int[b][a];
		int n = sc.nextInt();
//		XY[] x_arr = new XY[n];
//		for (int k = 0; k < n; k++) {
//			x_arr[k] = new XY(sc.nextInt(),sc.nextInt());
//		}

//
//		int[][] arr1 = new int[n][2];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 2; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}

//		for (int i = 0; i < n - 1; i++) {
//			for (int j = 0; j < 2; j++) {
//				if (arr[i][0] == 0) {
//					a1 = Math.max(arr1[i][1] - a, a - arr1[i][1]);
//				} else {
//					b1 = Math.max(arr1[i][1] - b, b - arr1[i][1]);
//				}
//			}
//
//			int result = 0;
//			result = a1 * b1;
//			System.out.println(result);
		
		
		ArrayList<Integer> Hlist = new ArrayList<>();
		ArrayList<Integer> Wlist = new ArrayList<>();
		Hlist.add(0);
		Wlist.add(0);
		for(int i=0; i<n; i++) {
			int type = sc.nextInt();
			if(type==0) {
				Hlist.add(sc.nextInt());
			}else {
				Wlist.add(sc.nextInt());
			}
		}
		Hlist.add(b);
		Wlist.add(a);
		//가로 세로를 위한 리스트 생성, 시작점 0넣어주고 종료점 a,b값 넣어줌
		//두 리스트 정렬, 갭의 최대값을 구한 뒤 두놈 곱하면 끝
		
		int result = 0;
		Hlist.sort(null);
		Wlist.sort(null);
//		Collections.sort(Hlist);
//		int maxGap = 0;
//		for(int i=1; i<Hlist.size(); i++) {
//			maxGap = Math.max(Hlist.get(i) - Hlist.get(i-1), maxGap);
//		}
		
		int a1 = Wlist.get(Wlist.size()-1) -  Wlist.get(Wlist.size()-2) ;
		int b1 = Hlist.get(Hlist.size()-1) -  Hlist.get(Hlist.size()-2);
		for(int i=Hlist.size() -2; i>0; i--) {
			if(b1 < Hlist.get(i)-Hlist.get(i-1))
				b1 = Hlist.get(i)-Hlist.get(i-1);
		}
		for(int i=Wlist.size() -2; i>0; i--) {
			if(a1 < Wlist.get(i)-Wlist.get(i-1))
				a1 = Wlist.get(i)-Wlist.get(i-1);
		}
		result = a1*b1;
		System.out.println(result);
	}
}
