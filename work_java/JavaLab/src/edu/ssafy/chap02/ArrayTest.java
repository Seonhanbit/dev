package edu.ssafy.chap02;

public class ArrayTest {
	// Array
	// 정의 : 같은 데이터 타입의 순서적 나열 (자료구조 중 가장 빠른 검색 가능)
	// 특징 : 선언과 동시에 크기가 결정되어지고, 한번 결정된 크기는 변경 불가
	// 배열은 생성하면 타입에 따라 기본값으로 초기화
	// 정수 0, 실수 0.0, 문자 \u0000, 논리 false, 참조(reference) null
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kuk=100, math=80, eng=50;
		int sum = kuk+math+eng;
		System.out.println(sum);
		System.out.println("----------------------");
		
		int [] jumsu = new int[3];
		jumsu[0]=100;
		jumsu[1]=80;
		jumsu[2]=50;
		
		sum =jumsu[0]+jumsu[1]+jumsu[2];
		
		System.out.println(sum);
		System.out.println("----------------------");
		
		float [] arr1 = new float[3];
		System.out.println(arr1[0]);
		
		char [] arr2 = new char[4];
		System.out.println(arr2[0]);
		
		boolean[] arr3 = new boolean[5];
		System.out.println(arr3[0]);
		
		System.out.println(arr2.length);
		System.out.println("----------------------");
		
		testFunc(jumsu);
		System.out.println("main kuk(jumsu[0]) : " + jumsu[0]);
		
		Member m = new Member();
		Member m2 = new Member();
//		Member m3 = new Member();
		Member [] marr = new Member[3];
		marr[0] = m;
		marr[1] = m2;
		marr[2] = new Member();   //Member m3 = new Member();
		
	}
	
	public static void testFunc(int[] arr) {
		arr[0]--;
		System.out.println("testFunc kuk(arr[0]): " + arr[0]);
		System.out.println(arr.length);
	}
	
//	public static void testFunc(int k) {
//		k--;
//		System.out.println("testFunc kuk: " + k);
//	}

}
