package edu.ssafy.chap02;

public class ArrayTest {
	// Array
	// ���� : ���� ������ Ÿ���� ������ ���� (�ڷᱸ�� �� ���� ���� �˻� ����)
	// Ư¡ : ����� ���ÿ� ũ�Ⱑ �����Ǿ�����, �ѹ� ������ ũ��� ���� �Ұ�
	// �迭�� �����ϸ� Ÿ�Կ� ���� �⺻������ �ʱ�ȭ
	// ���� 0, �Ǽ� 0.0, ���� \u0000, �� false, ����(reference) null
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
