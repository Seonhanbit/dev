package August;

import java.util.Scanner;

public class s_2563_색종이 {

	static class XY{
		int x;
		int y;
		public XY(int a, int b) {
			x= a;
			y =b;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[100][100];
		XY[] x_arr = new XY[n];
		for(int i=0; i<n; i++) {
			x_arr[i] = new XY(sc.nextInt(), sc.nextInt());
		}
		int cnt =0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				for(int k=0; k<n; k++) {
					if(i==x_arr[k].y&&j==x_arr[k].x) {
						for(int l=0; l<10; l++) {
							for(int p=0; p<10; p++) {
								if(arr[i+l][j+p] ==0)
									cnt++;
								arr[i+l][j+p] =1;
							}
						}
					}
				}
			}
		}
//		int cnt =0;
//		for(int i=0; i<100; i++) {
//			for(int j=0; j<100; j++) {
//				if(arr[i][j]==1)
//					cnt++;
//			}
//		}
		
		System.out.println(cnt);
	}

}
