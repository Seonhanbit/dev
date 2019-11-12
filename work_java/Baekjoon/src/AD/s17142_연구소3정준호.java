package AD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//좌표 저장을 위한 클래스
class Location {
	int r;
	int c;
	
	Location(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class s17142_연구소3정준호 {
	//사방탐색용 좌표조정배열
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	//연구소
	static int[][] arr;
	//방 방문여부
	static boolean[][] check;
	//활성화 바이러스를 선택할 배열
	static boolean[] useVirus;
	//연구소 크기, 바이러스 수, 빈방의 수, 감염된 방수, 답
	static int n, m, room, infec, ans = Integer.MAX_VALUE;
	//비활성화 바이러스 좌표 리스트
	static List<Location> virusList = new ArrayList<Location>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//연구소의 크기
		n = Integer.parseInt(st.nextToken());
		//활성화 갯수
		m = Integer.parseInt(st.nextToken());
		//연구소 생성
		arr = new int[n][n];
		
		//연구소 채우기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				//빈방이라면
				if(tmp == 0) {
					room++;
				//바이러스라면 리스트에 저장
				}else if(tmp == 2) {
					virusList.add(new Location(i, j));
				}
				arr[i][j] = tmp;
			}
		}
		
		//바이러스 수 만큼의 배열 생성
		useVirus = new boolean[virusList.size()];
		//조합 생성
		comb(0, 0);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void comb(int idx, int cnt) {
		//cnt만큼 활성화 되었다면
		if(cnt == m) {
			//너비우선탐색 시작
			bfs();
			return;
		}
		//다 고르지 못하고 끝날 경우
		if(idx == useVirus.length) {
			return;
		}
		
		useVirus[idx] = true;
		comb(idx+1, cnt+1);
		useVirus[idx] = false;
		comb(idx+1, cnt);
	}
	
	static void bfs() {
		//너비탐색을 위한 큐를 준비한다.
		Queue<Location> q = new LinkedList<Location>();
		//연구소 방문체크를 위해 초기화해준다.
		check = new boolean[n][n];

		//비활성화 바이러스 리스트를 순회하며 현재 활성화할 자리의 좌표를 큐에 삽입하고 방문한 곳으로 체크해준다.
		for (int i = 0; i < virusList.size(); i++) {
			if(useVirus[i]) {
				Location loc = virusList.get(i);
				q.add(loc);
				check[loc.r][loc.c] = true;
			}
		}
		
		//감염 수
		infec = 0;
		int sec = 0;
		//바이러스가 모두 퍼지거나 큐가 빌때까지
		while (room != infec && !q.isEmpty()) {
			//1초동안 감염을 진행할 현재 바이러스 수
			int size = q.size();
			//현재의 바이러스만 감염 진행
			for (int i = 0; i < size; i++) {
				//바이러스의 좌표
				Location loc = q.poll();
				
				//4방탐색을 진행한다.
				for (int j = 0; j < 4; j++) {
					//상하좌우의 새로운 좌표
					int nr = loc.r + pos[j][0];
					int nc = loc.c + pos[j][1];
					
					//범위안이면서 방문하지 않은 빈방
					if(posCheck(nr, nc) && arr[nr][nc] != 1 && !check[nr][nc]) {
						//방문 체크
						check[nr][nc] = true;
						//큐에 삽입
						q.add(new Location(nr, nc));
						if(arr[nr][nc] == 0) {
							//감염 +1
							infec++;
						}
					}
				}
			}
			sec++;
			//1초가 지났다.
		}
		
		//초기의 빈방 수와 감염수가 같다면
		if(room == infec) {
			//최소로 걸린 초와 비교하여 현재가 더 짧았다면 치환
			ans = Math.min(ans, sec);
		}
	}
	
	//범위체크
	static boolean posCheck(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
}