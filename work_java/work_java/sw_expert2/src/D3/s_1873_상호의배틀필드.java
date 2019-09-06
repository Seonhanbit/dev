package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1873_상호의배틀필드 {
	static boolean range(int x, int y) {
		if (x > h-1 || y > w-1 || x < 0 || y < 0)
			return true;
		else
			return false;
	}

	static int h = 0;
	static int w = 0;

	public static void main(String[] args) throws Exception {
		char[] UDLR = { 'U', 'D', 'L', 'R' };
		char[] UDLR_c = { '^', 'v', '<', '>' };
		int[] UDLR_dr = { -1, 1, 0, 0 };
		int[] UDLR_dc = { 0, 0, -1, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			char[][] arr = new char[h][w];
			int x = 0, y = 0;
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
//				arr[i] = str.toCharArray();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (str.charAt(j) == '<' || str.charAt(j) == '>' || str.charAt(j) == '^' || str.charAt(j) == 'v') {
						x = i;
						y = j;
					}
				}
			}
			int n = Integer.parseInt(br.readLine());
			String ss = br.readLine();

			for (int k = 0; k < n; k++) {
				if (ss.charAt(k) == 'S') {
					for (int i = 0; i < UDLR_c.length; i++) {
						if (arr[x][y] == UDLR_c[i]) {
							int next_x = x, next_y = y; // 원본값은 바뀌면 안돼(상하좌우 다 볼떄)
							while (true) {
								next_x += UDLR_dr[i];
								next_y += UDLR_dc[i];
//								if (!(next_x < h && next_y < w && next_x >= 0 && next_y >= 0))
								if(range(next_x, next_y))
									break;
								if (arr[next_x][next_y] == '#')
									break;
								if (arr[next_x][next_y] == '*') {
									arr[next_x][next_y] = '.';
									break;
								}
							}
							break;
						}
					}
				} else {
					for (int i = 0; i < UDLR.length; i++)
						if (ss.charAt(k) == UDLR[i]) {
							arr[x][y] = UDLR_c[i]; //탱크 방향 바꿔줘
							int next_x = x + UDLR_dr[i], next_y = y + UDLR_dc[i];
//							if (!(next_x < h && next_y < w && next_x >= 0 && next_y >= 0))
							if(range(next_x, next_y))
								break;
							if (arr[next_x][next_y] == '.') {
								arr[x][y] = '.';
								x = next_x;
								y = next_y;
								arr[x][y] = UDLR_c[i];
							}
							break;
						}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < h; i++) {
				sb.append(arr[i]).append("\n");
			}
			System.out.print(sb.toString());
		}
	}

}
