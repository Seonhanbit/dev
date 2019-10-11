package argorithm2;

import java.util.Arrays;

public class 순열_스왑 {
	static int[] arr = {1,3,5};

	public static void main(String[] args) {
		perm(0);
	}

	static void perm(int idx) {
		if (idx == arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx); // 다시 제자리로 바꿔놓기
		}
	}

	//원본 배열을 바꿔가면서 접근하기때문에 result배열이 따로 필요하지 않음
	static void swap(int a, int b) {
//		arr[a]와 arr[b]의 자리 바꾸기
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
