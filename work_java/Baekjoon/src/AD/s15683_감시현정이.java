package AD;

import java.io.*;
import java.util.*;

public class s15683_감시현정이 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] map = null;
	static int[] cam = new int[10];
	static int[] camy = new int[10];
	static int[] camx = new int[10];
	static int N=0, M=0, count=0, result =0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ArrayList<int[]> list_cam5 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==5) {
					int[] tmplist = new int[2];
					tmplist[0] = i;
					tmplist[1] = j;
					list_cam5.add(tmplist);
				}
				else if(map[i][j]<5 && map[i][j]>0) {
					cam[count] = map[i][j];
					camy[count] = i;
					camx[count] = j;
					count++;
				}				
			}
		}
		int cam5tmp = 91;
		for (int i = 0; i < list_cam5.size(); i++) {
			for (int j = 0; j < 4; j++) {
				set(list_cam5.get(i)[0], list_cam5.get(i)[1], j, cam5tmp, false);
			}
			cam5tmp++;
		}
		result = count0();
		
		if(count != 0) dfs(0);
		System.out.println(result);
	}
	
	static int count0(){
		int tmp=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) tmp++;
			}
		}
		return tmp;
	}
	static void set(int y, int x, int dr, int num, boolean isback) {
		
		int dy = y + delta[dr][0];
		int dx = x + delta[dr][1];
		
		if(dy<0||dy>=N||dx<0||dx>=M) return;
		else if(map[dy][dx]==6) return;
		
		if(!isback && map[dy][dx]==0) map[dy][dx] = num;			
		
		else if(isback && map[dy][dx]==num) map[dy][dx] = 0;
		
		set(dy, dx, dr, num, isback);
	}
	static void dfs(int cnt) {
		
		if(cnt == count) {
			int tmp = count0();

			if(tmp<result) result = tmp;
			return;
		}
		if(cam[cnt]==1) {
			for (int i = 0; i < 4; i++) {
				set(camy[cnt], camx[cnt], i, cnt+10, false);
				dfs(cnt+1);
				set(camy[cnt], camx[cnt], i, cnt+10, true);
			}
		}
		else if(cam[cnt]==2) {
			for (int i = 0; i < 3; i+=2) {
				set(camy[cnt], camx[cnt], i, cnt+10, false);
				set(camy[cnt], camx[cnt], i+1, cnt+10, false);
				dfs(cnt+1);
				set(camy[cnt], camx[cnt], i, cnt+10, true);
				set(camy[cnt], camx[cnt], i+1, cnt+10, true);
			}
		}
		else if(cam[cnt]==3) { 
			for (int i = 0; i < 4; i++) {
				int ii = 0;
				
				if(i == 0) ii = 3;
				else if(i == 1) ii = 2;
				else if(i == 2) ii = 0;
				else ii = 1;
				
				set(camy[cnt], camx[cnt], i, cnt+10, false);
				set(camy[cnt], camx[cnt], ii, cnt+10, false);
				dfs(cnt+1);
				set(camy[cnt], camx[cnt], i, cnt+10, true);
				set(camy[cnt], camx[cnt], ii, cnt+10, true);
			}
		}
		else if(cam[cnt]==4) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(j==i) continue;
					set(camy[cnt], camx[cnt], j, cnt+10, false);
				}
				dfs(cnt+1);
				for (int j = 0; j < 4; j++) {
					if(j==i) continue;
					set(camy[cnt], camx[cnt], j, cnt+10, true);
				}
			}
		}	
	}
}
