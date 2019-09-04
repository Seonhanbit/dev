package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class s_16922_로마숫자 {

	static HashSet<Integer> list = new HashSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] res = new int[n];
		int[] arr = { 1, 5, 10, 50 };
//		combination(arr,res,0,0);
		duple_combination(arr,res,0,0);
		System.out.println(list);
		System.out.println(list.size());
	}

	static void re_perm(int[] arr, int c, int[] res) {
		if (c == res.length) {
			int sum = 0;
			for(int i=0; i<res.length;i++)
				sum+=res[i];
			list.add(sum);
			return;
		}
		//원소만큼 돌아줘야해
		for (int i = 0; i < arr.length; i++) {
			res[c] = arr[i];
			re_perm(arr, c + 1, res);
		}
	}

	
	public static void duple_combination(int[] arr, int[] res, int n, int c) {
		if (c == res.length) {
			int sum = 0;
			for(int i=0; i<res.length;i++)
				sum+=res[i];
			list.add(sum);
			return;
		}
		if (n == arr.length)
			return;
//		n, c+1
//		n+1,c
		res[c]=arr[n];
		duple_combination(arr, res, n, c+1);
		duple_combination(arr, res, n+1, c);
//		for(int i=n; i<arr.length; i++) {
//			res[c] = arr[n];
//			duple_combination(arr,res,i,c+1);
//		}

	}

}
