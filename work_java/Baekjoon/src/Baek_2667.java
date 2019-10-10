import java.io.*;
import java.util.Arrays;

public class Baek_2667 {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	//범위 검사하기
	static boolean range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}
	
	//카운트 세면서 해당 단시 번호를 배열 안에 매겨주기
	//방문 체크 : 검사한 값 다시 검사하지 않기
	static void dfs(int x, int y) {
		check[x][y] = true;
		arr[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!range(nx, ny))
				continue;
			if (arr[nx][ny] == 0)
				continue;
			if (check[nx][ny])
				continue;
			arr[nx][ny] = cnt;
			dfs(nx, ny);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		//카운트 초기화
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0 && !check[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		//먼저 총 단지수 출력하기
		System.out.println(cnt);
		
		//각 단지내 집의 수를 담을 배열을 준비하자
		int[] res = new int[cnt + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 1; k < res.length; k++) {
					//단지 내에 있는 값은 1부터니까 인덱스 값이랑 똑같음
					if (arr[i][j] == k) {
						res[k]++;
					}
				}
			}
		}
		//오름차순으로 정렬하여 뽑자
		Arrays.sort(res);
		for (int i = 1; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
