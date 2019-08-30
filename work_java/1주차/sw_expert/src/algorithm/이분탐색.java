package algorithm;

import java.util.Scanner;

public class 이분탐색 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 4, 9, 16, 25, 36, 64, 81, 100, 121, 144, 169 };
		Scanner sc = new Scanner(System.in);

		// 해당 숫자보다 작은 가장 가까운 제곱 수를 찾으시오.
		int key = sc.nextInt();

		int right = arr.length - 1;
		int left = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			System.out.println("mid" + mid);
			System.out.println(arr[mid]);
			
			if (arr[mid] < key)
				left = mid + 1;
			else if (arr[mid] > key)
				right = mid - 1;
			else {
				right = mid;
				break;
			}
		}
		if(right >0)
		System.out.println(arr[right]);

	}
}
