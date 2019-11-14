package AD;

import java.io.*;
import java.util.*;

public class s_2573_빙산 {
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
		q.add(new Huu(r,c,0));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Huu now = q.poll();
			for(int d=0; d<4; d++) {
				int nr = now.r+dr[d], nc = now.c + dc[d];
				if(map[nr][nc]==0)
					continue;
				if(visited[nr][nc])
					continue;
				
				q.add(new Huu(nr,nc,0));
				visited[nr][nc] = true;
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
				if (map[r][c] > 0)
					list.add(new Huu(r, c, 0));
			}
		}
		
		for(int loop = 0; list.size()>0; loop++) {
			visited = new boolean[R][C];
			int re = 0;
			for (int r = 1; r < R - 1; r++) {
				for (int c = 1; c < C - 1; c++) {
					if (map[r][c] != 0 && visited[r][c] == false) {
						bfs(r, c);
						re++;
					}
				}
			}
			
			if (re >= 2) {
				System.out.println(loop);
				return;
			}
			
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
				if (map[p.r][p.c] <= 0) {
					map[p.r][p.c] = 0;
					del_list.add(i);
				}
				p.k = 0;
			}
			
			Collections.sort(del_list);
			for (int i = del_list.size() - 1; i >= 0; i--) {
				int del_idx = del_list.get(i);
				list.remove(del_idx);
			}
			
		}
//		for (int r = 0; r < R; r++) {
//		System.out.println(Arrays.toString(map[r]));
//	}
//	System.out.println();
		System.out.println(0);
	}
}