package AD;
import java.util.*;
public class s_17472_다리강사님 {
	 static int N; // 행의 크기
	    static int M; // 열의 크기
	    static int[][] map; //지도ㅎ
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        M = sc.nextInt();
	        map = new int[N][M];
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < M; j++)
	                map[i][j] = sc.nextInt();
	        }
	        int idx = 2;
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < M; j++) {
	                if( map[i][j] == 1 )
	                    dfs(i, j, idx++);
	            }
	        }
	        int[][] adj = new int[idx-2][idx-2];
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < M; j++) {
	                if( map[i][j] != 0 ) {
	                    for( int d = 0; d < 4; d++) {
	                        int nr = i + dr[d];
	                        int nc = j + dc[d];
	                        int cnt = 0;
	                        int start = map[i][j]-2;
	                        int dest = 0;
	                        while( inRange(nr, nc)) {
	                            if(map[nr][nc] != 0) {
	                                dest = map[nr][nc];
	                                break;
	                            }
	                            nr += dr[d];
	                            nc += dc[d];
	                            cnt++;
	                        }
	                        dest -= 2;
	                        if( dest != -2 && cnt > 1) {
	                            if( adj[start][dest] > 0 ) {
	                                adj[start][dest] = Math.min(adj[start][dest], cnt);
	                                adj[dest][start] = adj[start][dest];
	                            }
	                            else {
	                                adj[start][dest] = cnt;
	                                adj[dest][start] = cnt;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        boolean[] visited = new boolean[idx-2];
	        visited[0] = true;
	        List<Integer> sel = new ArrayList<>();
	        sel.add(0);
	        int dist = 0;
	        while(true) {
	            int min = 987654321;
	            int minIdx = -1;
	            for(int node : sel) {
	                for(int i = 0; i < idx-2; i++) {
	                    if( adj[node][i] != 0 && !visited[i] && adj[node][i] < min) {
	                        min = adj[node][i];
	                        minIdx = i;
	                    }
	                }
	            }
	            if( minIdx == -1 ) {
	                dist = -1;
	                break;
	            }
	            dist += min;
	            sel.add(minIdx);
	            visited[minIdx] = true;
	            if( sel.size() == idx - 2 )
	                break;  
	        }
	        System.out.println(dist);
	    }
	    static boolean inRange(int r, int c) {
	        return r >= 0 && c >= 0 && r < N && c < M;
	    }
	    static int[] dr = {-1,1,0,0};
	    static int[] dc = {0,0,-1,1};
	    static void dfs(int r, int c, int idx) {
	        map[r][c] = idx;
	        for(int i = 0; i < 4; i++) {
	            int nr = r + dr[i];
	            int nc = c + dc[i];
	            if( inRange(nr, nc) ) {
	                if( map[nr][nc] == 1 )
	                    dfs(nr, nc, idx);
	            }
	        }
	    }
}
