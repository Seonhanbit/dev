package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class s_1208_Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int max = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<max; i++) {
		        Arrays.sort(arr);
				arr[99]--;
				arr[0]++;
			}
			Arrays.sort(arr);	
			int result = arr[99] - arr[0];			
			
			System.out.println("#"+ tc + " "+result);
			
//			int[] arr = {42, 68, 35, 1, 70, 25, 79, 59, 63, 65};
//			
//			for(int i=0; i<4; i++) {
//		        Arrays.sort(arr);
//				arr[9]--;
//				arr[0]++;
//			}
//			System.out.println(Arrays.toString(arr));
//			int result = arr[9] - arr[0];
//			System.out.println(result);
			
		}
	}
}
