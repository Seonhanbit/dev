package August;

import java.util.Scanner;

public class s_2577_숫자의개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int res = a*b*c;
		String s = Integer.toString(res);

		int[] arr= new int[10];
		for(int i=0; i<s.length(); i++) {
//			System.out.println(s.charAt(i));
			int l = s.charAt(i)-'0';
			arr[l]++;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
