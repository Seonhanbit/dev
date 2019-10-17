package argorithm4;

import java.util.Arrays;

public class 플로이드워샬 {
    static final int INF = 99;
    public static void main(String[] args) {
        int[][] adj = {
                {0,4,2,5,INF},
                {INF,0,1,INF,4},
                {1,3,0,1,2},
                {-2,INF,INF,0,2},
                {INF,-3,3,1,0}
        };
        for(int i = 0; i < adj.length; i++)
            System.out.println(Arrays.toString(adj[i]));
        System.out.println();
         
        //플로이드 워샬 ㄲ
         
         
        for(int k = 0; k < 5; k++) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if( adj[i][k] != INF && adj[k][j] != INF)
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]); 
                }
            }
//          System.out.println("k=" + k);
//          System.out.println();
            for (int i = 0; i < adj.length; i++)
                System.out.println(Arrays.toString(adj[i]));
            System.out.println();
        }
         
    }
}
