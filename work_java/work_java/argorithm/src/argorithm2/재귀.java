package argorithm2;

public class 재귀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,5};
		recur(arr,0,1);
	}
	static int sum=0;
	static void recur(int[] arr, int n, int k) {
		if(n==arr.length) {
			System.out.println(k);
			return;
		}
		
		recur(arr,n+1,arr[n]+k);
		recur(arr,n+1,arr[n]*k);
		
	}

}
