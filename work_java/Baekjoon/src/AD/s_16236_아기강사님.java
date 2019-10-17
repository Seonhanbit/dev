package AD;
import java.io.*;
import java.util.*;

public class s_16236_아기강사님 {
	 //맵의 크기
    static int N;
    //맵을 저장할 배열
    static int[][] map;
    //맵의 크기와 같은 방문 배열
    static boolean[][] visited;
    //아기상어의 정보
    static int R, C; //위치
    static int lev = 2;
    static int cnt = 0;
     
    //정답
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if( map[i][j] == 9 ) {
                    R = i; C = j;
                    map[i][j] = 0;
                }
            }
        }
        while(true) {
            PriorityQueue<Point> feed = new PriorityQueue<>();//먹이 큐
            Queue<Point> queue = new LinkedList<>(); //아기상어의 이동 큐
            //한 루프 마다 새로운 이동이므로 새 방문배열을 준비
            visited = new boolean[N][N];
            //현재 아기상어의 위치를 큐에 넣어줌
            queue.add(new Point(R, C, 0));
            visited[R][C] = true;
            int dist = 987654321;
            while( !queue.isEmpty()) {
                Point point = queue.poll();
                //아기상어가 이번에 위치한 자리가, 먹을 수 있는 먹이자리이면, 먹이큐에 추가
                if( map[point.r][point.c] != 0 && map[point.r][point.c] < lev ) {
                    dist = point.dist;
                    feed.add(point);
                }
                //마지막에 먹었던 먹이의 거리보다 더 먼 거리의 먹이가 발견되면 그만 탐색
                if( dist < point.dist )
                    break;
                for(int i = 0; i < 4; i++) {
                    int nr = point.r + dr[i];
                    int nc = point.c + dc[i];
                    if( nr < 0 || nc < 0 || nr >= N || nc >= N)
                        continue;
                    if( !visited[nr][nc] && map[nr][nc] <= lev ) {
                        visited[nr][nc] = true;
                        queue.add(new Point(nr,nc, point.dist+1));
                    }
                }
            }
            Point p = feed.poll();
            //먹이가 없으면 종료
            if( p == null )
                break;
            //먹이를 맵에서 지워주고
            map[p.r][p.c] = 0;
            //아기 상어의 위치를 먹이의 위치로 이동
            R = p.r;
            C = p.c;
            //먹이 카운트 1증가
            cnt++;
            //먹이 카운트가 레벨만큼 찼다면 레벨업 하고 카운트 초기화
            if(cnt == lev) {
                lev++;
                cnt=0;
            }
            //먹이까지 이동한 거리를 정답에 누적합
            ans += p.dist;
        }
        System.out.println(ans);
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Point implements Comparable<Point>{
        int r, c, dist;
        Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            if( this.dist == o.dist ) {
                if( this.r == o.r )
                    return Integer.compare(this.c, o.c);
                return Integer.compare(this.r, o.r);
            }
            return Integer.compare(this.dist, o.dist);
        }
    }
}
