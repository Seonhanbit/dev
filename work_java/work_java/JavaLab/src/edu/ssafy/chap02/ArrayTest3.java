package edu.ssafy.chap02;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[2][3];
		arr[0][0] = 1;
		arr[0][1] = 13;
		arr[0][2] = 23;
		arr[1][0] = 33;
		arr[1][1] = 44;
		arr[1][2] = 55;
		
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[0][2]);
		System.out.println(arr[1][0]);
		System.out.println(arr[1][1]);
		
		System.out.println("----------------------");
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		
		System.out.println("----------------------");
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				System.out.println(arr[i][j]);
			}
		}		
		System.out.println("----------------------");
		
		//처음 주소값만 바라보고 있어서 괜찮음
		int[][]arr2= new int[3][];
		arr2[0] = new int[2];
		arr2[1] = new int[10];
		arr2[2] = new int[11];
		
		int[][] arr3 = {{3,5,7}, {12,25,66}};
		
		for(int i=0; i<arr3.length; i++)
		{
			for(int j=0; j<arr3[0].length; j++)
			{
				System.out.println(arr3[i][j]);
			}
		}
	}

}
