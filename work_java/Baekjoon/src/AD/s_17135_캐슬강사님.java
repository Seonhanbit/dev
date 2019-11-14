package AD;

import java.io.*;
import java.util.*;

public class s_17135_캐슬강사님 {
	static int N, M, D;

	static class Enemy {
		int r, c;

		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		// 적 리스트 담아주고 적이 내려올때는 좌표에 +1씩 해주면됨
		List<Enemy> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sc.nextInt() == 1)
					list.add(new Enemy(i, j));
			}
		}
		int ans = 0;
		// 조합 필요 없고 3중 포문하면 돼
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					// 궁수가 i,j,k에 있다고 생각하면 됨
					List<Enemy> tmp = new ArrayList<>();
					for (Enemy e : list)
						tmp.add(new Enemy(e.r, e.c));
					int cnt = 0;
					// 사수 위치 기억
					int[] pos = { i, j, k };
					// 게임을 시작ㅎ
					// 적군이 모두 사라질때까지
					while (!tmp.isEmpty()) {
						
						// 사수별로 가장 가까운 적을 찾아서, 죽일놈 리스트에 추가
						Set<Enemy> deathNode = new HashSet<>();						
						for (int p : pos) {
							int target = find(tmp, p);
							if (target != -1)
								deathNode.add(tmp.get(target));
						}
						// 데스노트에 적힌애들 모두 지우기
						cnt+=deathNode.size();
						tmp.removeAll(deathNode);
						
						// 적군이 한칸 하강
						for (int n = tmp.size() - 1; n >= 0; n--) {
							Enemy e = tmp.get(n);
							e.r++;
							if (e.r == N)
								tmp.remove(n);
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
		}
		System.out.println(ans);
	}

	static int find(List<Enemy> list, int p) {
		int dist = 987654321;
		int res = -1; // 못찾으면 -1리턴하기
		int minC = 100; // 가장 왼쪽에 있는 애를 기억할 변수

		for (int i = 0; i < list.size(); i++) {
			Enemy e = list.get(i);
			int tmpDist = N - e.r + Math.abs(p - e.c);
			if (tmpDist > D) // 거리가 사정거리 밖이라 무시
				continue;
			if (tmpDist < dist) {
				dist = tmpDist;
				res = i;
				minC = e.c;
			}
			// 거리가 알고있던 최단거리보다 더 가까운 적이 발견되면 그놈을 기억
			// 나중에 더 왼쪽에 있는 놈을 얻기위해 그 놈의 열 위치 기억
			else if (tmpDist == dist) {
				if (minC > e.c) {
					minC = e.c;
					res = i;
				}
			}
		}
		return res;
	}
}
