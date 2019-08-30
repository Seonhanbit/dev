package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class 중간값찾기 {

		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        int [] arr = new int[T];
	        for(int i= 0; i<T; i++)
	        {
	            arr[i] = sc.nextInt();
	        }
	        int a = arr.length/2;
	        Arrays.sort(arr);
	        System.out.println(arr[a]);
	    }
		
	}
