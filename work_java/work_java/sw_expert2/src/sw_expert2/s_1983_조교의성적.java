package sw_expert2;

import java.util.Arrays;
import java.util.Scanner;

public class s_1983_조교의성적 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int stu = sc.nextInt();
			int[] arr = new int[stu];
			int idx = sc.nextInt();
			String[] str = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			int[] jumsu = new int[10];

			for(int i=0; i<stu; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int sum = (int) ((a*35) + (b*45) + (c*20));
				arr[i] = sum;
			}
			
			int len = 0;
			for(int i=0; i<10; i++) {
				len = stu/10;
				jumsu[i] = len;
			}

			int cnt = 0; 
			for(int i=0; i<arr.length; i++) {
				if(arr[idx-1]<arr[i]) {
					cnt++;
				}
			}

			//System.out.println(Arrays.toString(arr));
			int sun= 0;
			System.out.print("#"+tc+ " ");
			for(int i=0; i<10; i++) {
				sun += jumsu[i];
				if(cnt<sun) {
					System.out.println(str[i]);
					break;
				}
			}
		}
	}
}
