
import java.io.*;
import java.util.*;

public class Baek_2573 {
	//빙산의 좌표와 빙하 값을 입력해줄 class
	static class Huu {
		int r, c, k;

		public Huu(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static void bfs(int r, int c) {
		//큐에 먼저 더해주기
		q.add(new Huu(r,c,0));
		visited[r][c] = true; // 방문체크
		while(!q.isEmpty()) { //연결된 것이 없어질때까지 도는거야
			Huu now = q.poll(); //큐 먼저 빼고
			for(int d=0; d<4; d++) { //네바퀴를 돌고
				int nr = now.r+dr[d], nc = now.c + dc[d];
				if(map[nr][nc]==0) //0일땐 빙하니까 패스
					continue;
				if(visited[nr][nc]) //방문 했을때는 패스
					continue;
				
				q.add(new Huu(nr,nc,0)); //사방으로 빙하를 만나면 큐에 더해주기
				visited[nr][nc] = true; //방문한곳 방문 체크
			}
		}
	}
	
	static Queue<Huu> q = new LinkedList<>();
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		map = new int[R][C];
		ArrayList<Huu> list = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			stk = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(stk.nextToken());
				if (map[r][c] > 0) //0보다 크면 빙하가 있는 곳이니까 리스트에 넣어주기
					list.add(new Huu(r, c, 0));
			}
		}
		//빙하가 계속 없어질때까지 도는거야 loop는 시간(년)
		for(int loop = 0; list.size()>0; loop++) {
			visited = new boolean[R][C]; 
			int re = 0;
			for (int r = 1; r < R - 1; r++) { //사이드는 0으로 둘려쌓여있어서 검사할 필요 없음
				for (int c = 1; c < C - 1; c++) {
					if (map[r][c] != 0 && visited[r][c] == false) {
						bfs(r, c);
						re++; //빙하가 나눠지면 re값이 2보다 커져
					}
				}
			}
			
			if (re >= 2) {
				System.out.println(loop);
				return;
			}
			//양옆을 돌아보면서 0갯수를 세기 > 해당 값만큼 빙하가 깎임
			for (int i = 0; i < list.size(); i++) {
				Huu p = list.get(i);
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d], nc = p.c + dc[d];
					if (map[nr][nc] == 0)
						p.k++;
				}
			}
			
			ArrayList<Integer> del_list = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Huu p = list.get(i);
				map[p.r][p.c] -= p.k;
				if (map[p.r][p.c] <= 0) { //빙하깎기
					map[p.r][p.c] = 0;
					del_list.add(i);
				}
				p.k = 0;
			}
			//빙하가 다 깎인 것은 리스트에서 빼줘야해 
			Collections.sort(del_list); //리스트는 뒤에서부터 삭제해줘야지 안꼬임
			for (int i = del_list.size() - 1; i >= 0; i--) {
				int del_idx = del_list.get(i);
				list.remove(del_idx);
			}
			
		}
		//다 돌았는데도 리턴되지 않았다면 0을 출력
		System.out.println(0);
	}
}