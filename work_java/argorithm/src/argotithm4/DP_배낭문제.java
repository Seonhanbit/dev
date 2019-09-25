package argotithm4;
import java.util.Scanner;

//1
//4 5
//1 2
//3 2
//4 4
//2 3
public class DP_배낭문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //아이템의 갯수 1≤N100
			int K = sc.nextInt(); //배낭의 최대부피 1≤K≤1000
			int[][] items = new int[N+1][2];
			for(int i = 1; i <= N; i++) {
				items[i][0] = sc.nextInt(); //0번칸은 부피
				items[i][1] = sc.nextInt(); //1번칸은 가치
			}
			//최대무게 K까지 담을 수 있는 열. 아이템의 갯수 + 1개 만큼의 행
			int[][] dp = new int[N+1][K+1];
			for(int i = 1; i <= N; i++) {
				//dp테이블을 1번행부터 N번행까지 채워나갑시다.
				//1번행은 첫번째 아이템 한개만 고려해서 배낭을 채워나감.
				//2번행은 첫번째와 두번째 아이템을 고려해서 배낭을 채워나감.
				//N번행은 첫번째 + .. + N번째 아이템을 꼬려해서 배낭을 채워나감.
				
				//i번째 아이템을 이용해 배낭을 채울때.
				//배낭의 부피가 i번째 아이템을 담을 수 없는 경우... 위에 칸의 가치를 그냥 복사.
				//담을 수 있다면. 위에 줄에서 i번째 아이템의 부피만큼 제외했을때의 최적가치 + 해당아이템의 가치와
				//위에칸의 가치 중에서 큰 가치를 선택
				for(int j = 0; j <= K; j++) {
					if( j < items[i][0] ) 
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - items[i][0]] + items[i][1]);
				}
			}
			System.out.println("#" + tc + " " + dp[N][K]);
		}
	}
}






