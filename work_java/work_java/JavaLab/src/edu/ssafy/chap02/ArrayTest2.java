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
		//arr2 = arr; ��ü�� �ؽ��ڵ� ���� �Ѿ. �ϳ��� ��ü�� �ΰ��� �Ĵٺ��� ����. ���� ����
//		arr2 = arr;
//		System.out.println(arr.length);
//		arr[2] =100;
//		System.out.println(arr2[2]);
		
		System.out.println("----------------------");
		
		//���� ����
//		arr2[3] = arr[3];
//		arr2[2] = arr[2];
//		arr2[1] = arr[1];
//		arr2[0] = arr[0];
		
//		for(int i=0; i<arr.length; i++) {
//			arr2[i] = arr[i];
//		}
		//for�� �˾Ƽ� ������ 0��° ��Һ��� 0��° ��Һ��� �� 4���� �����Ͻÿ�.
		System.arraycopy(arr, 0, arr2, 0, 4);
		
		System.out.println(arr2.length);
		arr[2] =100;
		System.out.println(arr2[2]);
		
		//for each ���� 
		//arr2(���� ���� list, set) ���̸�ŭ �ݺ��� ������ 
		//ù��° ��Һ��� value�� �̱� 
		for(int val : arr2) {
			System.out.println(val);
		}
		
	}

}
