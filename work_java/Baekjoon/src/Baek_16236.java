
import java.io.*;
import java.util.*;

public class Baek_16236 {
	static int N, time, shark, eat; //가는 시간, 상어 크기, 먹은 횟수
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static ArrayList<XY> list; //먹을 수 있는 먹이 리스트
	static Queue<XY> queue;

	static class XY implements Comparable<XY> {
		int x;
		int y;
		int cnt;

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		// cnt로 정렬하고, cnt 같으면 위부터니까 x로, 그다음은 y로 
		@Override
		public int compareTo(XY o) {
			if (this.cnt == o.cnt) {
				if (this.x == o.x)
					return Integer.compare(this.y, o.y);
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.cnt, o.cnt);
		}

		@Override
		public String toString() {
			return "XY [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
	}

	static boolean range(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		queue = new LinkedList<>();
		// 현재 상어의 크기
		shark = 2;
		// 상어가 먹은 갯수
		eat = 0;
		list = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// bfs를 바로 들어가기 쉽게 상어 위치를 저장해두자!
				if (arr[i][j] == 9) {
					x = i;
					y = j;
				}
			}
		}
		time = 0;
		bfs(x, y, 0);
		bw.write(time + "\n");
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y, int cnt) {
		queue.add(new XY(x, y, cnt));
		// bfs를 재귀로 돌기때문에 재귀를 돌때마다 초기화해주기
		visited = new boolean[N][N];
		int dist = 987654321;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			visited[tmp.x][tmp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] > shark) //상어보다 크면 빠이
					continue;
				if (visited[nx][ny]) //방문했으면 빠이
					continue;
				if (arr[nx][ny] !=0 && arr[nx][ny] < shark) { 
					dist = tmp.cnt+1;
					//0이 아니고, 상어보다 작으면 먹이리스트에 추가(먹이까지의 거리니까 cnt+1) 
					list.add(new XY(nx, ny, tmp.cnt+1));
					continue; //먹이 리스트에 추가했으면 그만~
				}
				// 마지막에 먹었던 먹이의 거리보다 더 먼거리의 먹이가 발견되면 그만 탐색
				if(dist<tmp.cnt+1) {
					queue.clear();
					break;
				}
				visited[nx][ny] = true;
				queue.add(new XY(nx, ny, tmp.cnt + 1));
			}
		}
		// 리스트가 0이면 끝내고 아니면 아래로
		if (list.size() == 0)
			return;
		// 리스트 정렬(가장 가까운순, 위, 왼쪽)
		Collections.sort(list);
		// 상어 위치 바꾸기
		int nx = list.get(0).x, ny = list.get(0).y;
		arr[nx][ny] = arr[x][y];
		arr[x][y] = 0; //원래 상어 위치에는 0 넣어주기
		// 바뀐 위치만큼 cnt값 더해주기
		time += list.get(0).cnt;
		eat++; // 먹었으니 한입 꿀꺽~
		if (shark == eat) { 
			//만약 상어크기랑 먹은 횟수가 같으면 상어 크기 1추가, 먹은 횟수는 0
			shark++;
			eat = 0;
		}
		list.clear(); // 한번 바꿨으니 끝~!
		// 재귀로 bfs소환하기
		bfs(nx, ny, 0);
	}

}
