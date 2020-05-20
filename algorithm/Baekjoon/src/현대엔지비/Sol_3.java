package 현대엔지비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_3 {
	   public static void main(String[] args) throws IOException {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		      StringTokenizer st = new StringTokenizer(br.readLine());
		      N = Integer.parseInt(st.nextToken());
		      M = Integer.parseInt(st.nextToken());

		      st = new StringTokenizer(br.readLine());

		      childs = new ArrayList[N + 1];
		      for (int i = 0; i < childs.length; i++)
		         childs[i] = new ArrayList<>();

		      for (int i = 1; i <= N; i++)
		         childs[Integer.parseInt(st.nextToken())].add(i);

		      int sum = 0;
		      for (int i = 0; i < M; i++) {
		         st = new StringTokenizer(br.readLine());
		         a = Integer.parseInt(st.nextToken());
		         b = Integer.parseInt(st.nextToken());
		         sel = cut = 0;
		         dfs(0, false, false);
		         sum += sel - cut;
		      }
		      System.out.println(sum);
		   }

		   static int N, M, sel, cut, a, b;
		   static ArrayList<Integer>[] childs;

		   static void dfs(int idx, boolean flag1, boolean flag2) {
		      if (idx > childs.length)
		         return;

		      for (int i = 0; i < childs[idx].size(); i++) {
		         int nNode = childs[idx].get(i);
		         if (flag1 && flag2) {
		            sel++;
		            cut++;
		            dfs(nNode, true, true);
		         } else if (flag1 && nNode == b) {
		            sel++;
		            cut++;
		            dfs(nNode, true, true);
		         } else if (flag1) {
		            sel++;
		            dfs(nNode, true, flag2);
		         } else if (!flag1 && nNode == a) {
		            sel++;
		            dfs(nNode, true, flag2);
		         } else {
		            dfs(nNode, flag1, flag2);
		         }
		      }
		   }
}