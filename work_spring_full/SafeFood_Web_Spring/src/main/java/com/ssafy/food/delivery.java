package com.ssafy.food;

import java.util.LinkedList;
import java.util.Queue;

public class delivery {
	 static int[] dx = { -1, 1, 0, 0 };
	    static int[] dy = { 0, 0, -1, 1 };
	    static int c_x = 1; // 회사 x좌표
	    static int c_y = 1; // 회사 y좌표
	    static int cnt = 0;
	    
	    public int execute(int x,int  y) {
	    	
	        int[][] map = new int[21][21];
	        for (int i = 1; i <= 20; i++) {
	            for (int j = 1; j <= 20; j++) {
	                map[i][j] = 1;
	            }
	        }
	        map[c_x][c_y] = 2;
	        map[x][y] = 3;
	        Queue<Point> queue = new LinkedList<>();
	        queue.add(new Point(c_x, c_y, 0));
	        while (!queue.isEmpty()) {
	            Point p = queue.poll();
	            for (int k = 0; k < 4; k++) {
	                int nx = p.r + dx[k];
	                int ny = p.c + dy[k];
	                if(nx<1 || ny<1|| nx>20||ny>20) continue;
	                if (map[nx][ny] == 1) {
	                    queue.add(new Point(nx,ny,p.cnt+1));
	                }
	                else if (map[nx][ny] == 3) {
	                    return p.cnt+1;
	                }
	            }
	        }
	        return 0;
	    }
	    static class Point {
	        int r, c,cnt;
	        Point(int r, int c,int cnt) {
	            this.r = r;
	            this.c = c;
	            this.cnt=cnt;
	        }
	    }
}
