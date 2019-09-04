package algorithm;

import java.util.Arrays;

public class ex_카운팅정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 5, 6, 3, 4, 1, 2 };
		int[] srr = new int[8]; //최대값 +1, 최대값이 알려져 있다고 봄

		//각 자료들의 빈도 수 계산
		for (int i = 0; i < arr.length; i++) {
			srr[arr[i]]++;
		}
		//각 자료의 빈도수를 누적 빈도로 변경
		for (int i = 1; i < srr.length; i++) {
			srr[i] += srr[i-1];
		}
		//정렬된 자료를 저장할 배열 준비
		int[] sorted_arr = new int[arr.length];
		//각 자료를 빈도수배열을 참조하여 적절한 위치에 배치
		for(int i=0; i<arr.length; i++) {
			//배치를 하기 전에 해당 숫자의 카운트 하나 감소, 자기 자신을 카운터해줬기 때문에
			srr[arr[i]]--;
			//자료값 > arr[i]에 해당하는 카운팅 배열에서의 인덱스의 값(미리빼줌)에 배치
			int my_idx = srr[arr[i]];
			sorted_arr[my_idx] = arr[i];
			//축약 >> sorted_arr[--srr[arr[i]]] =arr[i];
		}
		System.out.println(Arrays.toString(sorted_arr));
		
//		int sum =0;
//		int tmp =0;
//		//각 자료의 빈도수를 누적 빈도로 변경
//		for(int i=0; i<srr.length; i++) {
//			sum+=srr[i];
//			tmp = sum;
//			srr[i] = tmp;
//		}		
	}

}
