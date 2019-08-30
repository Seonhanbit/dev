package sw_expert;

import java.util.Arrays;

public class ex_선택정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {7,4,2,8,9,6,3,5,0,1};
		
		//아래 주석 내용을 한 for문으로 돌리면
		for(int j =0; j <arr.length; j++)
		{
			int max = arr[j]; //첫번째 애가 제일 크다고 가정 
			int max_index = j;
			for(int i=j; i<arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
					max_index =i;
				}		
			}
			int tmp = arr[j];
			arr[j] = arr[max_index];
			arr[max_index] = tmp;
		}
		System.out.println(Arrays.toString(arr));
		//대충 배열 출력하기 
		
//		for(int i =0; i <arr.length; i++)
//		{
//			if (max < arr[i]) {
//				max = arr[i];
//				max_index =i;
//			}
//		}
//		System.out.println("제일 큰 놈 : "+max);
//		//0번째와 제일 큰 놈 자리를 바꾸자
//		int tmp = arr[0];
//		arr[0] = arr[max_index];
//		arr[max_index] = tmp;
//		
//		//두번째가 제일 크다고 가정 
//		max= arr[1];
//		max_index = 1;
//		for(int i =1; i <arr.length; i++)
//		{
//			if (max < arr[i]) {
//				max = arr[i];
//				max_index =i;
//			}
//		}
//		//1번째와 제일 큰 놈 자리를 바꾸자
//		tmp = arr[1];
//		arr[1] = arr[max_index];
//		arr[max_index] = tmp;
	}

}
