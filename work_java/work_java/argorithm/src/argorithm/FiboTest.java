package argorithm;

import java.util.Scanner;

public class FiboTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		long start = System.currentTimeMillis();
		System.out.println(fibo(n));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	static int[] memo = new int[100];
	static int fibo(int n) {
		
		if(n==0) return 0;
		if(n==1) return 1;
		
		// fibo 함수가 같은 입력값으로 중복된 호출이 자주 일어나므로
		// 이미 그 값을 기억해놔서 시간을 빠르게 단축시키기
		if(memo[n] == 0) {
		memo[n] = fibo(n-1)+fibo(n-2);}
		return memo[n];
	}

}
