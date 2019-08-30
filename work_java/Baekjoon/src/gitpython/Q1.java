package gitpython;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		/*
		연속한 숫자가 증가하는 구간의 길이를 찾으려고 한다. 
		주어진 N개의 정수에서 가장 긴 증가 구간의 길이를 출력하는 프로그램을 만드시오. 증가 구간의 최소길이는 1이다.
		예를 들어 4 5 1 2 3 의 경우 가장 긴 증가 구간은 1 2 3으로 길이는 3이 된다.
		5 4 3 2 1의 경우 증가 구간의 최대 크기는 1이다.
		첫 줄에 N, 다음 줄에 1000 이하인 N개의 양의 정수가 주어진다.
		입력1
		7
		4 5 1 2 3 2 1
		출력 1
		3
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		int max = 0;
		for(int i=0; i<n-1; i++) {
			if(arr[i]-arr[i+1] == 1) {
				cnt++;
			}else {
				cnt=1;
			}
			
			if(max<cnt)
				max = cnt;
		}
		System.out.println(max);

	}

}
