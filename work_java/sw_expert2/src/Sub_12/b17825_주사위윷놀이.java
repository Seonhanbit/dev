package Sub_12;

import java.io.*;
import java.util.*;

//출발점 [0][0]
//0번길에 있으면서 10이나 20이나 30을 밟고 있다면 해당 길로 바꿈
//10 -> 1번째 길, 20 -> 2번째 길
//방향을 바꿔야하는가?, 어떤 말을 옮길까?(모든말 옮기고 백트래킹)
//내가 밟고자 하는 말에 다른 말이 있는가?(25부터 1,2,3번째 길을 봐야됨)

public class b17825_주사위윷놀이 {
	static int[] su;
	static List<Integer>[] route = new ArrayList[4];// 4가지의 경로가 있음(맵)
	static int[][] pos = new int[4][2];// 4개의 말이 각각 몇번길 몇번칸에 있는지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < 4; i++) {
			route[i] = new ArrayList<Integer>();
			pos[i][0] = 0; // 0번칸은 몇번 길인지
			pos[i][1] = 0; // 1번칸은 몇번째 칸인지
		}
		// 0번길은 0번칸부터 시작해서 2의 배수로 각 칸이 들어있음
		route[0].add(0);
		for (int i = 2; i <= 40; i += 2)
			route[0].add(i);
		for (int i = 10; i <= 19; i += 3)
			route[1].add(i);
		for (int i = 20; i <= 24; i += 2)
			route[2].add(i);
		route[3].add(30);
		route[3].add(28);
		route[3].add(27);
		route[3].add(26);
		for (int i = 25; i <= 40; i += 5) {
			route[1].add(i);
			route[2].add(i);
			route[3].add(i);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		su = new int[10];
		for (int i = 0; i < 10; i++)
			su[i] = Integer.parseInt(st.nextToken());
		dfs(0,0);
		bw.append(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static int ans = 0;

	//idx -> cnt같은 느낌, score -> 누적 점수
	public static void dfs(int idx, int score) {
		if (idx == 10) {
			ans = Math.max(ans, score);
			return;
		}
		out: for (int i = 0; i < 4; i++) {
			//도착한 말은 이동하지 않는다
			if (pos[i][0] == -1)
				continue;
			
			// pos값 변경
			int r = pos[i][0]; //길
			int n = pos[i][1]; //몇번째
			
			// 0번길에 있으면 10,20,30을 밝고 있다면 방향 변경
			int cur = route[r].get(n);
			if (r == 0) {
				switch (cur) {
				case 10:
					pos[i][0] = 1;
					pos[i][1] = 0;
					break;
				case 20:
					pos[i][0] = 2;
					pos[i][1] = 0;
					break;
				case 30:
					pos[i][0] = 3;
					pos[i][1] = 0;
					break;
				}
			}
			// 내가 가려는 칸(얼마나 갈까?!)
			int tmp = pos[i][1] + su[idx];
			
			// 도착하면 도착으로 변경
			if (tmp >= route[pos[i][0]].size()) {
				pos[i][0] = -1;
				dfs(idx + 1, score); //다음 주사위 호출
				pos[i][0] = r;
				pos[i][1] = n;
				continue;
			}
			// 가려는 곳에 다른 말이 있으면 못 옮김(완전  탐색해보자)
			for (int j = 0; j < 4; j++) {
				if (i == j) // 내가 나랑 검사할 필요 없음
					continue;
				if (pos[j][0] == -1) // 이미 도착점 떠난 애랑 검사할 필요 없음
					continue;
				// j번째 말이 나와 같은 길이면서, 내가 가려는 칸에 j번째 말이 있으면 안됨
				if (pos[j][0] == pos[i][0] && pos[j][1] == tmp) {
					pos[i][0] = r;
					pos[i][1] = n;
					continue out; // 한칸 건너뜀
				}
				// (25부터 1,2,3번째 길을 봐야됨)
				for (int k = 25; k <= 40; k += 5) {
					// i번쨰 말이 있는 길에 가려는 장소인 tmp 값이 k이고,
					// j번째 말이 있는 칸에 있는 값도 k라면 패스
					if (route[pos[i][0]].get(tmp) == k && route[pos[j][0]].get(pos[j][1]) == k) {
						//한놈은 0번째 칸의 30이면 괜찮아~
						if ((pos[i][0] == 0 || pos[j][0] == 0) && k == 30)
							continue; 
						pos[i][0] = r;
						pos[i][1] = n;
						continue out; // 한칸 건너뜀
					}
				}
			}
			//i번 말을 su의 idx번째 값 만큼 이동시키고,
			pos[i][1] = tmp;
			//다음 주사위 호출
			dfs(idx + 1, score+route[pos[i][0]].get(tmp));
			// pos값 복귀
			pos[i][0] = r;
			pos[i][1] = n;
		}
	}
}
