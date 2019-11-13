package AD;

import java.io.*;
import java.util.*;

public class s1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static boolean[][][] check;
	static Data start;
	static int result = Integer.MAX_VALUE;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		//a~f까지 키가지고 가는 방향이 2가지 따라서 2의 6승
		check = new boolean[N][M][1<<6]; // 열쇠가지고 방문했던적이 있는지 검사도 해야함
		String s = "";
		for(int i = 0; i < N; i++) {
			s = sc.next();
			for(int j = 0 ; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					start = new Data(i,j,0);
				}
			}
		}
		result = bfs();
		System.out.println(result);
		
		
	}
	private static int bfs() {
		Queue<Data> q = new LinkedList<>();
		q.offer(start);
		check[q.peek().y][q.peek().x][0] = true;
		int cnt = 0;
		int qSize = 0;
//		key 숫자로 표시하면서 비트마스트로 중복 key 체크
		Data d;
		int currentKey;
		while(!q.isEmpty()) {
			qSize = q.size();
			for(int s = 0; s < qSize; s++) {
				d = q.poll();
				currentKey = d.key; // 현재 키
				if(map[d.y][d.x] == '1') { // 문을 찾았으면 나가기
					return cnt;
				}

				//그렇지 않으면 4방향 탐색
				for(int i = 0 ; i < 4; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];
					int key = currentKey;
					//범위 벗어나면 다음것
					if(nx <0 || nx >=M|| ny <0||ny >=N) {
						continue;
					}
					//벽은 만나면 패스
					if(map[ny][nx] == '#') {
						continue;
					}
//					키를 찾은 경우 키 값을 비트마스트로 변경한다
					//a-'a' = 0이고 0을 왼쪽으로 1칸 미루면 000001
					if('a' <=map[ny][nx] && map[ny][nx] <= 'f') {
						//key랑 or 연산자
						key |= (1 << (map[ny][nx] -'a'));
					}
//					A ~ F 이면 기존 키를 가지고 있는지 확인한 후 없으면 통과
//					System.out.println(nx + ", " + ny + ", " + map[ny][nx]  + " , " + key);
					if('A' <=map[ny][nx] && map[ny][nx] <= 'F') {
						//and 연산자
						//키가 맞는걸 확인하는 연산
						//맞는 키가 있으면 통과(continue)
						if((key & (1 << (map[ny][nx] - 'A'))) == 0) {
//							System.out.println("통과하나");
							continue;
						}
					}
					
					
					
					//기존의 키를 가지고 방문했던적이 있으면 통과
					if(check[ny][nx][key]) {
						continue;
					}
					// 같은 키를 가지고 방문했던적이 있었는지 체크 배열 채우기
					check[ny][nx][key] = true;

					q.offer(new Data(ny,nx,(char)key));
				}				
			}
			cnt++;
		}
		
		return -1;
		
	}
	static class Data{
		int x,y;
		int key;
		public Data(int y, int x, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
		
	}
}
