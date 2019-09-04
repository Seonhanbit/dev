package algorithm;

public class ex_상하절대값 {
//배열2연습문제1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, -1 };

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 랜덤한 수 뽑는 방법?
				arr[i][j] = (int) (Math.random() * 45) + 1;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int sum =0;
				// 상하좌우 값이
				for (int k = 0; k < 4; k++) {
					int ni = i + dx[k];
					int nj = j + dy[k];
					// 배열 안에 있다면
					if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5) {
						// 해당 값과 나와의 절대값 계산
						int dif = Math.abs(arr[i][j] - arr[ni][nj]);
						sum += dif;
					}

				}
				System.out.println(sum+ " ");
			}
		}
	}

}
