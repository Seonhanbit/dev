package argorithm2;

import java.util.Scanner;

public class BSearch {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,13,15};
		int low = 0;
		int high = arr.length -1;
		
		int key = new Scanner(System.in).nextInt();
		while(low <=high) {
			int mid = (low+high)/2;
			if(arr[mid] == key) {
				high = mid;
				break;
			}
			//누나는 메롱이야
			else if(arr[mid] < key) {
				low = mid+1;
			}
			else
				high =mid -1;
			//히히 지우기 귀찮죠
		}
		System.out.println(high);
	}
//전 강우예요
}
