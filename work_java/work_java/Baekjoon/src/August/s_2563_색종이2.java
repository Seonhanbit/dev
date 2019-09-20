package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_2563_색종이2 {
	static class XY {
		int x;
		int y;

		public XY(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static boolean range(int x, int y) {
		if(x>=0&&x<100&y>=0&&y<100) {
			return true;
		}else {
			return false;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100];
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		for (int k = 0; k < n; k++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int rr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			for (int i = rr; i < rr+10; i++) {
				for (int j = cc; j < cc+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1) {
					for(int k=0; k<4; k++) {
						int ni = i+dr[k], nj = j+dc[k];
						if(range(ni,nj)&&map[ni][nj] ==0) {
							cnt++;
						}else if(!range(ni,nj)){
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
