package argorithm2;

import java.util.Arrays;

public class 중복조합_정리 {

	public static boolean check[];
	public static int[]brr;
	public final static int LIMIT=2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,2,3};
		check=new boolean [arr.length];
		brr=new int[LIMIT];
		a_combination(arr,0,0);
	}
	public static void a_combination(int[] arr, int cnt, int idx) {
		if(cnt==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		for(int i=idx;i<arr.length;i++) {
			brr[cnt]=arr[i];
			a_combination(arr,cnt+1,i);
		}
	}
}
