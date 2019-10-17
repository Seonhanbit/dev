import java.io.*;
import java.util.*;

public class Baek_2583 {
	static int M, N, K, res;
	static int[][] arr;
	static ArrayList<Integer> list;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		list = new ArrayList<>(); // 넓이 넣을 리스트
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++)
					arr[i][j] = 1;
			}
		}
		int su = 0; // 영역의 갯수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) { //분리된 곳이 아닐때
					res = 1; //영역의 넓이는 1부터 시작(초기화)
					bfs(i, j);
					list.add(res); //영역을 정렬해야하니까 리스트에 넣어주기
					su++; //영역 갯수 추가
				}
			}
		}
		sb.append(su+"\n");
		Collections.sort(list); //영역은 오름차순으로 정렬
		for (int i = 0; i < list.size(); i++)
			sb.append(list.get(i) + " ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y) {
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(x, y));
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			arr[tmp.x][tmp.y] = 1; //검사한 영역은 1로 바꿔주기 
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] != 0)
					continue;
				arr[nx][ny] = 1;
				queue.add(new XY(nx, ny));
				res++; //영역 넓이 늘려주기
			}
		}
	}

}
