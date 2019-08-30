package argorithm2;

import java.util.Arrays;

public class 조합_정리 {
	public static boolean check[];
	public static int[]brr;
	public final static int LIMIT=2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,2,3};
		check=new boolean [arr.length];
		brr=new int[LIMIT];
		combination(arr,0,0);
	}
	public static void combination(int[] arr, int idx, int cnt) {
		if(brr.length==cnt) {
			System.out.println(Arrays.toString(brr));
			return;
			
		}
		if(arr.length==idx)
			return;
		brr[cnt]=arr[idx];
		combination(arr,idx+1,cnt+1);
		combination(arr,idx+1,cnt);
	}

}
