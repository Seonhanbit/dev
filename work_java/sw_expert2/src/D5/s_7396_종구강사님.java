package D5;

import java.io.*;
import java.util.*;

public class s_7396_종구강사님 {
	static class Node {
		int r, c;
		char ch;

		Node(int r, int c, char ch) {
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
	}

	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] map = new char[N][M];
			for(int i=0; i<N; i++)
				map[i] = sc.next().toCharArray();
			
			boolean[][] visited = new boolean[N][M];
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(0,0,map[0][0]));
			visited[0][0]=true;
			char ch = map[0][0];
			StringBuilder sb = new StringBuilder();
			while(!queue.isEmpty()) {
				sb.append(ch);
				char next = 'z'; // 최소값을 구하기 위해
				int size = queue.size();
				for(int i=0; i<size; i++) {
					Node current = queue.poll();
					if(ch==current.ch) {
						for(int d=0; d<2; d++) {
							int nr = current.r + dx[d];
							int nc = current.c + dy[d];
							if(nr>=N || nc>=M)
								continue;
							if(visited[nr][nc])
								continue;
							
							visited[nr][nc] = true;
							queue.add(new Node(nr,nc,map[nr][nc]));
							if(next>= map[nr][nc])
								next = map[nr][nc];
						}
					}
				}
				ch = next;
			}
			System.out.println("#"+tc+" "+sb.toString());
		}
	}

}
