package August;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s_5543_상근날드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(br.readLine());
		arr[1] = Integer.parseInt(br.readLine());
		arr[2] = Integer.parseInt(br.readLine());
		int n4 = Integer.parseInt(br.readLine());
		int n5 = Integer.parseInt(br.readLine());

		//int minBuger = 12666666;
		//minBurger = Math.min(minBurger, sc.nextInt());
		int sum = 123421415;
		for (int i = 0; i < 3; i++) {
//			if (arr[i] < arr[i + 1]) {
//				sum = arr[i];
//				
//			} else {
//				sum = arr[i + 1];
//			}
			if(sum > arr[i]) sum = arr[i];
		}
		
		if (n4 <= n5) {
			sum += n4;
		} else {
			sum += n5;
		}
		System.out.println(sum - 50);
	}

}
