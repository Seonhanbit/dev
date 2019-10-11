package argorithm2;

import java.util.Arrays;

public class 재귀함수 {

	public static void main(String[] args) {
		// 0부터 9까지 출력되도록 함수
//		recur(10,0);

		// 부분집합 구하기
//		int[] arr = {7,2,4};
//		powerset(arr,0, new boolean[arr.length]);
		// 5개 원소 중 3개를 뽑는 조합
//		int[] arr = {1,2,3,4,5,6,7,8,9,10};
//		combination(arr,0 , 0, new int[3]);
//		int[] arr = { 1, 2, 3 };
//		re_perm(arr, 0, new int[3]);
		int[] arr = { 1, 2, 3, 4 };
		perm(arr, 0, new int[3], new boolean[4]);
	}

	// 순열 **************눈 디버깅 아주 많이**************************
	// n진트리를 탐색하되, 해당 뎁쓰에 오기까지 이미 선택된 원소는 재끼자
	static void perm(int[] arr, int c, int[] result, boolean[] visited) {
		if (c == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[c] = arr[i];
				perm(arr, c + 1, result, visited);
				visited[i] = false;
			}
		}
	}

	// 중복 순열(포화 n진 트리)
	static void re_perm(int[] arr, int c, int[] result) {
		if (c == result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		//원소만큼 돌아줘야해
		for (int i = 0; i < arr.length; i++) {
			result[c] = arr[i];
			re_perm(arr, c + 1, result);
		}
	}

	// n은 현재 고를까 말까하는 위치를 가리키는 변수
	// c는 이번 고른걸 담은 위치의 변수
	static void combination(int[] arr, int n, int c, int[] sel) {
		if (c == sel.length) {
			// 다 고른것
			System.out.println(Arrays.toString(sel));
			return;
		}

		if (n == arr.length) {
			// 끝난것
			return;
		}

		// n번쨰에 대해서 sel에 담고 지나가기
		sel[c] = arr[n];
		combination(arr, n + 1, c + 1, sel);
		// n번쨰에 대해서 sel에 안담고 지나가기
		combination(arr, n + 1, c, sel);
	}
	
	//부분집합
	static void powerset(int[] arr, int idx, boolean[] sel) {
		if (idx == arr.length) {
			// 해당 자리를 체크하면 가지고가기, 아니면 안 가지고가기
			for (int i = 0; i < arr.length; i++) {
				if (sel[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		sel[idx] = false;
		powerset(arr, idx + 1, sel);
		sel[idx] = true;
		powerset(arr, idx + 1, sel);
	}

	static void recur(int n, int idx, int[] arr) {
		// 기저파트(재귀함수가 종료되는 조건) 안에 있는 변수가 재귀부를때 변화하는 변수
		if (idx == n) {
			return;
		}
		// doSomething
//		System.out.println(idx);
		System.out.println(arr[idx]);

		// 재귀 호출
		recur(n, idx + 1, arr);
	}
	
	public static void duple_combination(int[] arr, int[] res, int n, int c) {
		if (c == res.length) {
			int sum = 0;
			for(int i=0; i<res.length;i++)
				sum+=res[i];
//			list.add(sum);
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
