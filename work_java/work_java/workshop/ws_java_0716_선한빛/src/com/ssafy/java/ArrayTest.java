package com.ssafy.java;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {34, 23, 64, 25, 12, 75, 22, 88, 53, 37};
		int total = 0, average = 0, min =999;
		
		for (int i : arr) {
			System.out.print(i);
		}
		
		for (int i=0; i<arr.length; i++) {
			total += arr[i];
		}
		
		average = total/10;
		
		for (int i=0; i<arr.length; i++) {
			if(arr[i]<min)
			min = arr[i];
		}
		System.out.println();
		System.out.println("배열의 합 : " + total);
		System.out.println("배열의 평균 : " + average);
		System.out.println("배열의 최소값 : " + min);
	}

}
