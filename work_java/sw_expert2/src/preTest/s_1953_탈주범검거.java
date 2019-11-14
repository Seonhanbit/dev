package preTest;

import java.io.*;
import java.util.*;

public class s_1953_탈주범검거 {
	static int T, N, M, res, R, C, L;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			func();
			res = check();
			bw.append("#" + String.valueOf(tc) + " " + String.valueOf(res) + "\n");
			bw.flush();
		}
		bw.close();
	}

	// 터널 구조물
	static int[][][] dir = { {}, 
			{ { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, 
			{ { -1, 0 }, { 1, 0 } },
			{ { 0, -1 }, { 0, 1 } }, 
			{ { -1, 0 }, { 0, 1 } }, 
			{ { 1, 0 }, { 0, 1 } }, 
			{ { 1, 0 }, { 0, -1 } },
			{ { -1, 0 }, { 0, -1 } } 
			};

	static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	static class XY {
		int x;
		int y;
		int cnt;

		XY(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	// int[][][] dir
	// 가장 첫번째 인자 값은 터널 숫자
	// 두번째 인자값은 길이
	// 가장 마지막 인자 값이 x,y 좌표 > for문 도는거고
	static void func() {
		Queue<XY> queue = new LinkedList<>();
		queue.add(new XY(R, C, 1));
		visited[R][C] = true;
		while (!queue.isEmpty()) {
			XY tmp = queue.poll();
			if (tmp.cnt == L) {
				break;
			}
			int dic = arr[tmp.x][tmp.y];
			for (int j = 0; j < dir[dic].length; j++) {
				// 0이 x좌표
				// 1이 y좌표
				int nx = tmp.x + dir[dic][j][0];
				int ny = tmp.y + dir[dic][j][1];
				if (!range(nx, ny))
					continue;
				if (arr[nx][ny] == 0)
					continue;
				if (visited[nx][ny])
					continue;
				// 연결 되었는지 안되었는지 체크하기
				int n = arr[nx][ny];
				if (dic == 1) {
					//상
					if (j == 0) {
						if (n == 1 || n == 2 || n == 5 || n == 6) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//하
					if(j==1) {
						if (n == 1 || n == 2 || n == 4 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//좌
					if(j==2) {
						if (n == 1 || n == 3 || n == 4 || n == 5) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//우
					if(j==3) {
						if (n == 1 || n == 3 || n == 6 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
				if (dic == 2) {
					//상
					if (j == 0) {
						if (n == 1 || n == 2 || n == 5 || n == 6) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//하
					if(j==1) {
						if (n == 1 || n == 2 || n == 4 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
				if (dic == 3) {
					//좌
					if(j==0) {
						if (n == 1 || n == 3 || n == 4 || n == 5) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//우
					if(j==1) {
						if (n == 1 || n == 3 || n == 6 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
				if (dic == 4) {
					//상
					if (j == 0) {
						if (n == 1 || n == 2 || n == 5 || n == 6) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//우
					if(j==1) {
						if (n == 1 || n == 3 || n == 6 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
				if (dic == 5) {
					//우
					if(j==1) {
						if (n == 1 || n == 3 || n == 6 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//하
					if(j==0) {
						if (n == 1 || n == 2 || n == 4 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
				if (dic == 6) {
					//하
					if(j==0) {
						if (n == 1 || n == 2 || n == 4 || n == 7) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//좌
					if(j==1) {
						if (n == 1 || n == 3 || n == 4 || n == 5) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
				if (dic == 7) {
					//좌
					if(j==1) {
						if (n == 1 || n == 3 || n == 4 || n == 5) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
					//상
					if (j == 0) {
						if (n == 1 || n == 2 || n == 5 || n == 6) {
							visited[nx][ny] = true;
							queue.add(new XY(nx, ny, tmp.cnt + 1));
						}
					}
				}
			}
		}
	}

	static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					cnt++;
			}
		}
		return cnt;
	}
}
