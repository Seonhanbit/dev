package argorithm2;

import java.util.Arrays;

public class 조합_정리2_다른방식 {

	public static boolean check[];
	public static int[]brr;
	public final static int LIMIT=2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,2,3};
		check=new boolean [arr.length];
		brr=new int[LIMIT];
		combination2(arr,0,0);
	}
	public static void combination2(int[]arr,int idx,int cnt) {
		if(brr.length==cnt) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		for(int i=idx;i<arr.length;i++) {
			brr[cnt]=arr[i];
			combination2(arr,i+1,cnt+1);
		}
	}
}
