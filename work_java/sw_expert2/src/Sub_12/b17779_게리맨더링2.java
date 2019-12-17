package Sub_12;

import java.io.*;
import java.util.*;

public class b17779_게리맨더링2 {
	static int N, min;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = 987654321;
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int ii = 1; ii <= N-j; ii++) {
                    for (int jj = 1; jj < N - j; jj++) {
                        if (j - ii >= 0 && j + jj < N && i + ii+jj < N) {
                            min = Math.min(min, cal(i, j, ii, jj));
                        }
                    }
                }
            }
        }
		bw.append(String.valueOf(min));
		bw.flush();
		bw.close();
	}
	static int cal(int r, int c, int d1, int d2) {
        boolean[][] isArea5 = new boolean[arr.length][arr.length];
        int nr = r;
        int nc = c;
        int end = 1;
        for(int i = 0; i <= d1 + d2; i++) {
            for(int j = 0; j < end; j++) {
                isArea5[nr][nc+j] = true;
            }
            nr++;
            if( i < d1 ) 
                nc--;
            else
                nc++;
            if( i < d1 && i < d2)
                end+=2;
            else if( i >= d1 && i >= d2)
                end-=2;
        }
        int[] sum = new int[5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i >= 0 && i < r + d1 && j >= 0 && j <= c && !isArea5[i][j]) {
                    sum[0] += arr[i][j];
                } else if (i >= 0 && i <= r + d2 && j > c && j < arr.length&& !isArea5[i][j]) {
                    sum[1] += arr[i][j];
                } else if (i >= r + d1 && i < arr.length && j >= 0 && j < c - d1 + d2&& !isArea5[i][j]) {
                    sum[2] += arr[i][j];
                } else if (i > r + d2 && i < arr.length && j >= c - d1 + d2 && j < arr.length&& !isArea5[i][j]) {
                    sum[3] += arr[i][j];
                }
                else
                    sum[4] += arr[i][j];
            }
        }
        Arrays.sort(sum);
        return sum[4] - sum[0];
    }
}
