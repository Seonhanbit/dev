package argorithm2;

import java.util.Arrays;

public class 중복순열_정리 {
	public static boolean check[];
	public static int[]brr;
	public final static int LIMIT=2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,2,3};
		check=new boolean [arr.length];
		brr=new int[LIMIT];
		a_permutation(arr,0);
	}
	public static void a_permutation(int[]arr, int idx) {
		if(brr.length==idx) {

			System.out.println(Arrays.toString(brr));
			return;
		}
		for(int i=0;i<arr.length;i++) {
			brr[idx]=arr[i];
			a_permutation(arr,idx+1);
		}
	}
}
