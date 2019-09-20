package sw_expert;

import java.util.Arrays;
import java.util.Scanner;

public class s_5431_민석이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			int [] input = new int[num+1];
			int student = sc.nextInt();
			
			for(int i =0; i<student; i++)
			{
				input[sc.nextInt()] = 1;
			}
			
//			System.out.println(Arrays.toString(input));
			
			System.out.print("#"+tc+" ");
			
			for(int i =1; i<input.length; i++)
			{
				if(input[i]==0) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
//노력			
//			int[] arr = new int[100];
//			for (int i = 0; i < arr.length; i++) {
//				for (int j = 0; j < input.length; j++) {
//					if (i == (input[j]) - 1) {
//						arr[i] = 1;
//					}
//				}
//			}
//			
//			int[] index= new int[100];
//			for(int i =0; i<arr.length; i++) {
//				if(arr[i] == 0) {
//					index[i] = arr[i];
//				}
//			}
//			
		}
	}

}
