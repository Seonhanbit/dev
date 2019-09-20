package D4;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_1251_하나로 {
	 static int[] parents;
	    static Ele[] eles, vals;
	    static class Ele implements Comparable<Ele> {
	        int x, y;
	        long val;
	        public Ele(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	        public int compareTo(Ele o) {
	            return Long.compare(this.val, o.val);
	        }
	    }
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	        for (int t = 1; t <= T; t++) {
	            int N = Integer.parseInt(br.readLine());
	            parents = new int[N];
	            eles = new Ele[N];
	            vals = new Ele[N * N];
	            StringTokenizer stk_x = new StringTokenizer(br.readLine());
	            StringTokenizer stk_y = new StringTokenizer(br.readLine());
	            double E = Double.parseDouble(br.readLine());
	            for (int n = 0; n < N; n++)
	                eles[n] = new Ele(Integer.parseInt(stk_x.nextToken()), Integer.parseInt(stk_y.nextToken()));
	            for (int i = 0; i < N; i++)
	                for (int j = 0; j < N; j++) {
	                    vals[i * N + j] = new Ele(i, j);
	                    vals[i * N + j].val = (long) Math.pow((long) eles[i].x - eles[j].x, 2)
	                            + (long) Math.pow((long) eles[i].y - eles[j].y, 2);
	                }
	            Arrays.sort(vals);
	            for (int i = 0; i < N; i++)
	                parents[i] = i;
	            double sum = 0;
	            for (int i = 0, cnt = 0; cnt != N - 1; i++) {
	                int rootX = find(vals[i].x), rootY = find(vals[i].y);
	                if (vals[i].val != 0 && rootX != rootY) {
	                    parents[rootY] = rootX;
	                    sum += vals[i].val;
	                    cnt++;
	                }
	            }
	            System.out.println("#" + t + " " + Math.round(sum * E));
	        }
	    }
	    static int find(int i) {
	        if (i == parents[i])
	            return i;
	        return parents[i] = find(parents[i]);
	    }
}
