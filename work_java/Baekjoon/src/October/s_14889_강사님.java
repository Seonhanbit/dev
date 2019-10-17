package October;
import java.io.*;
import java.util.*;

public class s_14889_강사님 {
	static int[][] map;
    static int N;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                sum += map[i][j];
            }
        }
        comb(0, new boolean[N], 0);
        System.out.println(ans);
    }
    static int ans = 987654321;
    static void comb(int idx, boolean[] sel, int s_idx) {
        if( s_idx == N/2 ) {
            int s_sum = 0;
            int l_sum = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(sel[i] && sel[j])
                        s_sum += map[i][j];
                    else if( !sel[i] && !sel[j])
                        l_sum += map[i][j];
                }
            }
            ans = Math.min(ans,  Math.abs(s_sum - l_sum));
            return;
        }
        if( idx == N )
            return;
        sel[idx] = true;
        comb(idx+1, sel, s_idx+1);
        sel[idx] = false;
        comb(idx+1, sel, s_idx);
    }
}
