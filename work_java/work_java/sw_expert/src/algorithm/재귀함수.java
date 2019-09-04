package algorithm;

import java.util.Arrays;

public class 재귀함수 {

	public static void main(String[] args) {
		int n = 3;
		int[] arr = {1,2,3,4};
//
		recur(n);
//		arrSum(arr,0,0);
//		
		boolean[] sel = new boolean[3];
		powerset(sel,0);
	}
	
	//부분집합 구하기
	static void powerset(boolean[] sel, int idx) {
		if(idx == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		sel[idx] = true;
		powerset(sel, idx+1);
		sel[idx] = false;
		powerset(sel, idx+1);
	}
	
	//부분집합 합 구하기
	static void subSum(int[] arr, int idx, int sum) {
		if(idx == arr.length) {
			System.out.println(sum);
			return;
		}
		subSum(arr,idx+1, sum);
		subSum(arr,idx+1, sum+arr[idx]);

	}

	
	static void recur(int n) {
		if (n == 0) {
			return;
		}
		System.out.println("1: " +n);
		recur(n - 1);
		System.out.println("----");
		recur(n - 1);
		System.out.println("2: " +n);
	}
}

//	static void traversalArr(int[] arr, int idx) {
//		if (idx == arr.length)
//			return;
//		System.out.println(arr[idx]);
//		traversalArr(arr, idx + 1);
//	}
//	
//	static void arrSum(int[] arr, int idx, int sum) {
//		if(idx == arr.length) {
//			System.out.println(sum);
//			return;
//		}
//		sum+=arr[idx];
//		arrSum(arr,idx+1,sum);
//	}
//
//}
