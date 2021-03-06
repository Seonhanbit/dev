package D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class s_5948_새샘이의735 {
	static HashSet<Integer> res=null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			res = new HashSet<Integer>();
			int[] arr = new int[7];
			int[] sel = new int[3];
			for (int i = 0; i < 7; i++) {
				arr[i] = sc.nextInt();
			}
			sum(arr, sel, 0, 0);
//			System.out.println(res);
			ArrayList<Integer> list = new ArrayList<>();
			for (int i : res) {
			    list.add(i);
			}
//			System.out.println(list);
			Collections.sort(list);
//			System.out.println(list);
			System.out.println("#"+tc+" "+list.get(list.size()-5));
		}
	}

	static void sum(int[] arr, int[] sel, int n, int c) {
		if (c == sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			res.add(sum); 
//			System.out.println(res);
			return;
		}
		if (n == arr.length) {
			return;
		}
		sel[c] = arr[n];
		sum(arr, sel, n + 1, c + 1);
		sum(arr, sel, n + 1, c);
	}
}
