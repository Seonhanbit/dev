package AD;

import java.io.*;
import java.util.*;

public class s15683_감시기동이 {
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int[][] ccd = { { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3, 4 } };
    static int N;
    static int M;
    static int[][] map;
    static CCTV[] cctv;
    static int cCount;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        cctv = new CCTV[8];
        cCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv[cCount] = new CCTV(i, j, map[i][j]);
                    cCount++;
                }
            }
        }
        min = Integer.MAX_VALUE;
        perm(new int[cCount], 0);
        System.out.println(min);
    }
    static void perm(int[] arr, int idx) {
        if (idx == cCount) {
            int[][] nmap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    nmap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < cCount; i++) {
                cctv[i].di = arr[i]; //하나의 cctv가 가리키는 방향을 내 씨시티피 방향좌표로 넣어주고.
                color(map, nmap, cctv[i]); //범위를 확인하자.
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (nmap[i][j] == 0) {
                        count++;
                    }
                }
            }
            min = Math.min(min, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[idx] = i;
            perm(arr, idx + 1);
        }
    }
    static void color(int[][] map, int[][] nmap, CCTV cctv) { // 0상1우2하3좌
        for (int i = 0; i < ccd[cctv.kind - 1].length; i++) { // 종류에따른 방향
            int dx = d[(ccd[cctv.kind - 1][i] + cctv.di) % 4][0];
            int dy = d[(ccd[cctv.kind - 1][i] + cctv.di) % 4][1];
            int nx = cctv.x + dx;
            int ny = cctv.y + dy;
            while (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] != 6) {
                if (nmap[nx][ny] == 0) {
                    nmap[nx][ny] = 1;
                }
                nx += dx;
                ny += dy;
            }
        }
    }
}
class CCTV {
    int x;
    int y;
    int kind;
    int di = 0;
    CCTV(int x, int y, int kind) {
        this.x = x;
        this.y = y;
        this.kind = kind;
    }
}
