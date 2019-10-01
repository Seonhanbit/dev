package D5;

import java.util.Scanner;

public class s_DP_최장증가_강사님 {
	public static void main(String[] args) {
//		int[] arr = {0,1,3,4,7,9,0,0,0,0,0,0,0};
//		int left = 0;
//		int right = 5;
//		int target = 0;
//		while(left <= right) {
//			int mid = (left+right)/2;
//			if( arr[mid] > target )
//				right = mid - 1;
//			else
//				left = mid + 1;
//		}
//		System.out.println(right);
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] lis = new int[N];
			// 증가수열의 각 자리에 들어갈 수 있는 제일 작은 수를 기억할 배열.
			int[] tmp = new int[N];
			int tmp_idx = 0; //tmp배열의 현재 크기
			int ans = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				//tmp배열에서 나보다 커지는 위치 하나 전을 찾자.
//				int idx = 0;
//				for(int j = 0; j <= tmp_idx; j++) {
//					if( tmp[j] > arr[i] )
//						break;
//					idx = j;
//				}
//				if( idx == tmp_idx ) {
//					tmp_idx++;
//					tmp[tmp_idx] = arr[i];
//					lis[i] = tmp_idx;
//				}
//				else {
//					tmp[idx + 1] = arr[i];
//					lis[i] = idx + 1;
//				}
				int left = 0;
				int right = tmp_idx;
				int target = arr[i];
				while( left <= right ) {
					int mid = (left+right) / 2;
					if(tmp[mid] > target)
						right = mid-1;
					else
						left = mid+1;
				}
				if( tmp_idx == right ) {
					tmp_idx++;
					tmp[tmp_idx] = arr[i];
					lis[i] = tmp_idx;
				}
				else {
					tmp[right + 1] = arr[i];
					lis[i] = right + 1;
				}
				
				
				ans = Math.max(ans, lis[i]);
			}
			System.out.println("#" + tc + " " + ans); 
		}
	}
}
