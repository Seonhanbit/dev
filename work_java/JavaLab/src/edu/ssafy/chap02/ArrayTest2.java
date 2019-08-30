package edu.ssafy.chap02;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5,7};
//		System.out.println(arr.length);
//		System.out.println(arr[2]);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int[] arr2 = new int[arr.length+1];
		//arr2 = arr; 객체의 해시코드 값이 넘어감. 하나의 객체를 두개가 쳐다보고 있음. 얕은 복사
//		arr2 = arr;
//		System.out.println(arr.length);
//		arr[2] =100;
//		System.out.println(arr2[2]);
		
		System.out.println("----------------------");
		
		//깊은 복사
//		arr2[3] = arr[3];
//		arr2[2] = arr[2];
//		arr2[1] = arr[1];
//		arr2[0] = arr[0];
		
//		for(int i=0; i<arr.length; i++) {
//			arr2[i] = arr[i];
//		}
		//for문 알아서 돌려줌 0번째 요소부터 0번째 요소부터 총 4개를 복사하시오.
		System.arraycopy(arr, 0, arr2, 0, 4);
		
		System.out.println(arr2.length);
		arr[2] =100;
		System.out.println(arr2[2]);
		
		//for each 구문 
		//arr2(집합 개념 list, set) 길이만큼 반복문 돌리기 
		//첫번째 요소부터 value값 뽑기 
		for(int val : arr2) {
			System.out.println(val);
		}
		
	}

}
