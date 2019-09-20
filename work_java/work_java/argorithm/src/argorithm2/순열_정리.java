package argorithm2;

import java.util.Arrays;

public class 순열_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,2,3};
		check=new boolean [arr.length];
		brr=new int[LIMIT];
		permutation(arr,0);
	}
	public static boolean check[];
	public static int[]brr;
	public final static int LIMIT=2;
	public static void permutation(int[] arr, int idx) {
		if(idx==brr.length) {
			
			System.out.println(Arrays.toString(brr));
			
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!check[i]) {
				check[i]=true;
				brr[idx]=arr[i];
				permutation(arr,idx+1);
				check[i]=false;
			}
		}
	}
}
