package algorithm;

import java.util.Arrays;

public class ex_버블정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,5,3,6,4,1,2};
		
		//버블 정렬
		for(int j=0; j<arr.length; j++) {
			int tmp=0;
			//첫번째 요소부터 맨 마지막에서 두번째까지 버블버블
			for(int i=0; i<arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
				}
			}System.out.println(Arrays.toString(arr));
		}

	}

}
