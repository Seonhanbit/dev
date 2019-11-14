package AD;

import java.io.*;
import java.util.*;

public class s15683_감시 {
	static class Location{
		int row;
		int col;
		int num;
		public Location(int row, int col, int num) {
			super();
			this.row = row;
			this.col = col;
			this.num = num;
		}
	}
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] pos = {{0,-1},{0,1},{-1,0},{1,0}};
	static int[][][][] cameraPos = {
			{},
			{
				{{-1,0}},
				{{1,0}},
				{{0,-1}},
				{{0,1}}
			},
			{
				{{-1,0},{1,0}},
				{{0,1},{0,-1}}
			},
			{
				{{-1,0},{0,1}},
				{{0,1},{1,0}},
				{{1,0},{0,-1}},
				{{0,-1},{-1,0}}
			},
			{
				{{0,-1},{-1,0},{0,1}},
				{{-1,0},{0,1},{1,0}},
				{{0,-1},{1,0},{0,1}},
				{{-1,0},{0,-1},{1,0}}
			}
	};
	static List<Location> cameraList = new ArrayList<Location>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 5) {
					cameraList.add(new Location(i, j, map[i][j]));
				}
			}
		}
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 5) {
					for (int k = 0; k < 4; k++) {
						int nr = i;
						int nc = j;
						
						while (true) {
							nr += pos[k][0];
							nc += pos[k][1];
							
							if(!posCheck(nr, nc)) break;
							if(map[nr][nc] == 6) break;
							if(map[nr][nc] > 0) continue;
							
							map[nr][nc] = -1;
						}
					}
				}
			}
		}
		
		perm_re(new int[cameraList.size()], 0);
		
		System.out.println(ans);
	}
	
	private static void perm_re(int[] sel, int idx) {
		if(sel.length == idx) {
			int[][] copyMap = deepCopyMap();
			
			for (int i = 0; i < cameraList.size(); i++) {
				Location camera = cameraList.get(i);

				for (int j = 0; j < cameraPos[camera.num][sel[i]].length; j++) {
					int nr = camera.row;
					int nc = camera.col;
					while (true) {
						nr += cameraPos[camera.num][sel[i]][j][0];
						nc += cameraPos[camera.num][sel[i]][j][1];
						
						if(!posCheck(nr, nc)) break;
						if(copyMap[nr][nc] == 6) break;
						if(copyMap[nr][nc] > 0) continue;
						
						copyMap[nr][nc] = -1;
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copyMap[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			ans = Math.min(ans, cnt);
			
			return;
		}
		
		for (int i = 0; i < cameraPos[cameraList.get(idx).num].length; i++) {
			sel[idx] = i;
			//
			perm_re(sel, idx+1);
			//
		}
	}

	static int[][] deepCopyMap() {
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}
		
		return copyMap;
	}

	static boolean posCheck(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < M;
	}
}
