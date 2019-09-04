package argorithm2;

public class PowerSet_Bitmap {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		// 부분 집합 구하기
		// {},{1},{3},{5},{1,3],{1,5},{3,5},{1,3,5}
		// 000,100,010,001,110,...111(0~7) 0부터 8까지 반복 원소가 3개이기때문에 2의 3제곱

		for (int i = 0; i < (1 << arr.length); i++) {
			// i는 0,1,2,3,4,5,6,7
			// i를 2진수로 표현했을떄 맨 뒤에 0번째 비트가 1이면 배열의 0번째 원소 포함
			// i를 2진수로 표현했을때 맨 뒤에 1번째 비트가 1이면 배열의 1번째 원소 포함
			// i를 2진수로 표현했을때 맨 뒤에 2번째 비트가 1이면 배열의 2번째 원소 포함
			// 위 반복은 원소의 갯수만큼 반복
			for (int j = 0; j < arr.length; j++) {
				// j는 0,1,2
				// i를 2진수로 표현했을떄 맨 뒤에 j번째 비트가 1이면 배열의 j번째 원소 포함
				if ((i & (1 << j)) != 0) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}

	}

}
