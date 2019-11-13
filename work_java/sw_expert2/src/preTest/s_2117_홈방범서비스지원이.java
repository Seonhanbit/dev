package preTest;

import java.io.*;
import java.util.*;

public class s_2117_홈방범서비스지원이 {
    static int house;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int testCase = sc.nextInt();
         
        for(int tc=1; tc<=testCase; tc++){
            int n = sc.nextInt();// 도시의 크기 5 <= n <= 20
            int m = sc.nextInt();// 하나의 집이 지불할 수 있는 비용 M
            house = 0;
            int [][] map = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    search(i, j, new boolean [n][n], map, n, m);
                }
            }
             
            System.out.println("#" + tc + " " + house);
        }
    }
    static void search(int y, int x, boolean [][] visited, int[][] map, int n, int m){
        Queue<pos> que = new LinkedList<>();
        int [][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        que.add(new pos(y, x));
        visited[y][x] = true;
        int range = 2, houseNum = 0;
        if(map[y][x] == 1){
            houseNum = 1;
            if(house<1)
                house = 1;
        }
         
        while(!que.isEmpty()){
             
            int size = que.size();
            int cost = range*range + (range-1)*(range-1);
             
            for(int s=0; s<size; s++){
                pos p = que.poll();
                 
                for(int i=0; i<4; i++){
                    int ny = p.y + dir[i][0];
                    int nx = p.x + dir[i][1];
                     
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                     
                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;
                        que.add(new pos(ny, nx));
                        if(map[ny][nx] == 1){
                            houseNum++;
                        }
                    }
                }
                 
            }
            if(houseNum*m-cost >= 0 && house < houseNum) house = houseNum;
            range++;
        }
    }
     
    static class pos {
        int y, x;
 
        public pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
         
    }
}