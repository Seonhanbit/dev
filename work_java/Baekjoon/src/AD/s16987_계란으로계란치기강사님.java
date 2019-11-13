package AD;

import java.io.*;
import java.util.*;

public class s16987_계란으로계란치기강사님 {
	 static class Egg{
	        int dur;
	        int weight;
	        public Egg(int dur, int weight) {
	            this.dur = dur;
	            this.weight = weight;
	        }
	    }
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        eggs = new Egg[N];
	        for (int i = 0; i < N; i++)
	            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
	        dfs(0, 0);
	        System.out.println(ans);
	    }
	    static int N;
	    static Egg[] eggs;
	    static int ans = 0;
	    static void dfs(int idx, int cnt) {
	        ans = Math.max(ans, cnt);
	        //더 이상 집을 계란이 없다.
	        if(idx == N)
	            return;
	        //더 이상 깰 계란이 없다.
	        if(cnt == N-1)
	            return;
	        if( eggs[idx].dur <= 0 )
	        {
	            dfs(idx+1, cnt);
	            return;
	        }
	        for(int i = 0; i < N; i++) {
	            if( i != idx && eggs[i].dur > 0) {
	                eggs[i].dur -= eggs[idx].weight;
	                eggs[idx].dur -= eggs[i].weight;
	                int nextCnt = cnt;
	                if( eggs[i].dur <= 0 )
	                    nextCnt++;
	                if( eggs[idx].dur <= 0)
	                    nextCnt++;
	                dfs(idx+1, nextCnt);
	                eggs[i].dur += eggs[idx].weight;
	                eggs[idx].dur += eggs[i].weight;
	            }
	        }
	    }
}
