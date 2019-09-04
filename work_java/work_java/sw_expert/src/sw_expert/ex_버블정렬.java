package sw_expert;

import java.util.Arrays;

public class ex_버블정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 4, 2, 8, 9, 6, 3, 5, 0, 1 };

		for (int j = 0; j < arr.length; j++) {
			int tmp = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}

	}

}
