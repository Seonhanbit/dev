package September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class s_16918_봄버맨 {
	static int R, C, N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] arr;
	static Queue<XY> queue;

	static boolean range(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C)
			return true;
		else
			return false;
	}

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		queue = new LinkedList<XY>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}
		if (N == 0 || N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} else if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (arr[i][j] == 'O')
						queue.add(new XY(i, j));
				}
			}		
			boom(2);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void boom(int sec) {
		if(sec==N+1)
			return;
		if (sec % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(arr[i][j] == 'O')
						queue.add(new XY(i,j));
					else
						arr[i][j] = 'O';
				}
			}
			sec++;
			boom(sec);
		}else {
			while(!queue.isEmpty()) {
				XY temp = queue.poll();
				arr[temp.x][temp.y] = '.';
				for(int j=0; j<4; j++) {
					int nx = temp.x+dx[j];
					int ny = temp.y+dy[j];
					if(!range(nx,ny))
						continue;
					arr[nx][ny] = '.';
				}
			}
			sec++;
			boom(sec);
		}
	}
	

}
