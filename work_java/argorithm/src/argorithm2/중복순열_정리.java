package argorithm2;

import java.util.Arrays;
//숫자들을 모든 경우의 수로 늘어놓되 중복을 허용
//부분집합과 조합이 상태공간트리가 2진트리 형태라면(고르는경우, 안 고르는 경우)
//중복 조합은 원소가 n개라면 n진트리 형태가 만들어짐(1번째꺼 고르는 경우, 2번째 고르는 경우....n번쨰 고르는 경우)
public class 중복순열_정리 {
	public static boolean check[];
	public static int[] brr;
	public final static int LIMIT=3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,2,3};
		check=new boolean [arr.length];
		brr=new int[arr.length];
		a_permutation(arr,0);
	}
	public static void a_permutation(int[]arr, int idx) {
		if(brr.length==idx) {

			System.out.println(Arrays.toString(brr));
			return;
		}
		//원소의 갯수만큼 > 원소 갯수 몇개인지 모르니까
		for(int i=0;i<arr.length;i++) {
			brr[idx]=arr[i];
			a_permutation(arr,idx+1);
		}
	}
}
