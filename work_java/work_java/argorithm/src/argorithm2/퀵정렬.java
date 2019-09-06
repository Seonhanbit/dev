package argorithm2;

import java.util.Arrays;

public class 퀵정렬 {

	public static void main(String[] args) {
		int[] arr = {3,2,4,6,9,1,8,7,5};
		quickSort(arr, 0, 8);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[]arr, int left, int right) {
		if(left<right) {
			int pivot= patition(arr,left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	static int patition(int[] arr, int left, int right) {
		int x = arr[right];
		int i=left;
		for(int j=left; j<right; j++) {
			if(arr[j]<=x) {
				swap(arr,i,j);
				i++;
			}
		}
		swap(arr,i,right);
		return i;
	}
	
	static void swap(int[] arr, int a, int b) {
//		arr[a]와 arr[b]의 자리 바꾸기
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
