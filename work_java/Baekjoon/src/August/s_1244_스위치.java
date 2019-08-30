package August;

import java.util.Arrays;
import java.util.Scanner;

public class s_1244_스위치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] arr = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			arr[i] = sc.nextInt();
		}

		int student = sc.nextInt();

		for (int k = 0; k < student; k++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			// 남자
			if (a == 1) {
				for (int i = 1; i <= num; i++) {
					//arr[b] = arr[b] == 1? 0: 1;
					int c = b * i;
					if (c > num)
						break;
					else {
						if (arr[c] == 0)
							arr[c] = 1;
						else
							arr[c] = 0;
					}
				}
			}

			if (a == 2) {
				if (arr[b] == 0)
					arr[b] = 1;
				else
					arr[b] = 0;
				
					for (int j = 1; j <= num; j++) {
						if (b - j < 1 || b + j > num||arr[b - j] != arr[b + j])
							break;
						
						else if (arr[b - j] == arr[b + j]) {
							if (arr[b - j] == 1) {
								arr[b - j] = 0;
								arr[b + j] = 0;
							} else {
								arr[b - j] = 1;
								arr[b + j] = 1;
							}
						} 
				}
			}
		}
		for (int i = 1; i <= num; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
	}

}

