import java.util.Scanner;

public class s_1945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt();
			int[] arr = new int [5];
			
			arr[0] = n%2;
			arr[0] = n%3;
			arr[0] = n%5;
			arr[0] = n%7;
			arr[0] = n%11;
				
			System.out.print("#"+ tc+" ");
			
			for(int i =0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}

		}

	}

}
