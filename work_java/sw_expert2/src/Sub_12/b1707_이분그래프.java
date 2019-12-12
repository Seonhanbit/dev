package Sub_12;

import java.io.*;
import java.util.*;

public class b1707_이분그래프 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out:for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] color = new int[N+1];
            List<Integer> adj[] = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= N; i++) {
                if( color[i] == 0 ) {
                    queue.add(i);
                    color[i] = 1;
                    while(!queue.isEmpty()) {
                        int n = queue.poll();
                        for(int j = 0; j < adj[n].size(); j++) {
                            int tmp = adj[n].get(j);
                            if( color[tmp] != 0 ) {
                                if(color[tmp] == color[n]) {
                                    System.out.println("NO");
                                    continue out;
                                }
                            }
                            else {
                                color[tmp] = -color[n];
                                queue.add(tmp);
                            }
                        }
                    }
                }
            }
            System.out.println("YES");
        }
    }
}
