package AD;

import java.io.*;
import java.util.*;
public class s1194_달이차오른다효진이 {
    static int N, M;
    static char map[][];
    static int check[][][];
    static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
    static boolean range(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
            return false;
        else
            return true;
    }
    static class Point {
        int x, y, cnt, key;
        public Point(int x, int y, int cnt, int key) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
    static Queue<Point> q = new LinkedList<>();
    public static int bfs(int x, int y) {
        q.add(new Point(x, y, 0, 0));
        check[0][x][y] = 1;
        while (!q.isEmpty()) {
            int qx = q.peek().x;
            int qy = q.peek().y;
            int qcnt = q.peek().cnt;
            int qkey = q.peek().key;
            q.poll();
            // 종료조건
            if (map[qx][qy] == '1')
                return qcnt;
            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                // 범위가 참일때만 들어가자
                if (range(nx, ny)) {
                    if (map[nx][ny] == '#')
                        continue;
                    if (check[qkey][nx][ny] == 0) {
                        if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                            int a = map[nx][ny] - 'a';
                            int k = qkey | (1 << a);
                            if (check[k][nx][ny] == 1)
                                continue;
                            check[k][nx][ny] = 1;
                            q.add(new Point(nx, ny, qcnt + 1, k));
                            continue;
                        } else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                            int a = map[nx][ny] - 'A';
                            if ((qkey & (1 << a)) == (1 << a)) {
                                check[qkey][nx][ny] = 1;
                                q.add(new Point(nx, ny, qcnt + 1, qkey));
                            }
                            continue;
                        }
                        check[qkey][nx][ny] = 1;
                        q.add(new Point(nx, ny, qcnt + 1, qkey));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        check = new int[1 << 6][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    System.out.println(bfs(i, j));
                }
            }
        }
    }
}