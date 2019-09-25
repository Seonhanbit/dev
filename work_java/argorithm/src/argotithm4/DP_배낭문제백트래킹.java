package argotithm4;
import java.util.Arrays;
import java.util.Scanner;

public class DP_배낭문제백트래킹 {
	static class Item implements Comparable<Item>{
		int volume;
		int value;
		double score;
		Item(int volume, int value){
			this.volume = volume;
			this.value =value;
			this.score = value/(double)volume;
		}
		@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			return Double.compare(o.score, this.score);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 아이템의 갯수 1≤N100
			int K = sc.nextInt(); // 배낭의 최대부피 1≤K≤1000
//			int[][] items = new int[N + 1][3]; // 각행의 0번칸은 부피, 1번칸은 가치, 2번칸은 가성비ㅋ
			Item[] items = new Item[N];
			for (int i = 0; i < N; i++) {
				items[i] = new Item(sc.nextInt(), sc.nextInt());
			}
			//items배열을 score내림차순으로 정렬하시오.
			Arrays.sort(items);
			ans = 0;
			backtrack(items, 0,0,0,K);
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int ans = 0;
	//각 아이템을 선택/안선택 두가지 경우를 재귀호출하는 함수를 작성하시오.
	static void backtrack(Item[] items, int idx, int volume, int value,int K) {
		if( items.length == idx) {
			if(ans < value)
				ans = value;
			return;
		}
		//아래의 방식으로 bound를 계산
		//현재 idx부터 남은 아이템들을 무게가 안꽉차면 계속 줏어담아나가고
		//배낭 남은 부피가 아이템을 못담으면 쪼개서 담기
		
		//지금까지의 value로 부터 시작해서 위에처럼 계산해나가면 됨
		double bound = value;//현재까지 획득 가치
		int curr_volume = volume; //현재 까지 배낭의 무게
		for(int i = idx; i < items.length; i++) {
			if( curr_volume + items[i].volume <= K ) {
				bound += items[i].value;
				curr_volume += items[i].volume;
			}
			else {
				int remain = K - curr_volume;
				bound += (remain * items[i].score);
				break;
			}
		}
		if (bound < ans)
			return;

		if (volume + items[idx].volume <= K)
			backtrack(items, idx + 1, volume + items[idx].volume, value + items[idx].value, K);
		backtrack(items, idx + 1, volume, value, K);
	}
}
