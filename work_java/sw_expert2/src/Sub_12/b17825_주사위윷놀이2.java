package Sub_12;

import java.io.*;
import java.util.*;

//맵에 각 칸에 아이디를 만들어주자.
//말의 현재 위치는 칸의 아이디를 기억하면 됨
//(1번라인: 1~20, 2번라인 : 21~26, 3번라인 : 27~28, 4번라인 : 29~31)

//맵의 각 아이디를 배열의 인덱스라고 하자.
//칸의 각 아이디에 해당하는 인덱스에 
//1차원 배열을 할당해서,
//첫번째 칸에는 칸의 값, 
//2~6번째 칸에는 각 주사위가 1~5가 나왔을때 이동해야 될 칸의 인덱스를 저장
// 0 : 0 1 2 3 4 5
// 1 : 2 2 3 4 5 6
// 2 : 4
//... 5 : 10 21 22 23 24 25
//...21 : 13
//...24 : 25
//...28 : 22 29 24 25 26

public class b17825_주사위윷놀이2 {
	static int[] su;
	static int ans = 0;
    static boolean[] visited;
    static int[] hores; //현재 말의 인덱스
    
	static int[][] map = {
            {0,1,2,3,4,5},
            {2,2,3,4,5,6},
            {4,3,4,5,6,7},
            {6,4,5,6,7,8},
            {8,5,6,7,8,9},
            {10,21,22,23,24,25},
            {12,7,8,9,10,11},
            {14,8,9,10,11,12},
            {16,9,10,11,12,13},
            {18,10,11,12,13,14},
            {20,27,28,24,25,26},
            {22,12,13,14,15,16},
            {24,13,14,15,16,17},
            {26,14,15,16,17,18},
            {28,15,16,17,18,19},
            {30,29,30,31,24,25},
            {32,17,18,19,20,-1},
            {34,18,19,20,-1,-1},
            {36,19,20,-1,-1,-1},
            {38,20,-1,-1,-1,-1},
            {40,-1,-1,-1,-1,-1},
            {13,22,23,24,25,26},
            {16,23,24,25,26,20},
            {19,24,25,26,20,-1},
            {25,25,26,20,-1,-1},
            {30,26,20,-1,-1,-1},
            {35,20,-1,-1,-1,-1},
            {22,28,24,25,26,20},
            {24,24,25,26,20,-1},
            {28,30,31,24,25,26},
            {27,31,24,25,26,20},
            {26,24,25,26,20,-1}
            }; // [][0]은 실제 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		su = new int[10];
		visited = new boolean[32];
		hores = new int[4]; // -1이면 끝난거
		for (int i = 0; i < 10; i++)
			su[i] = Integer.parseInt(st.nextToken());

		permutation(0, 0);
		bw.append(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	 private static void permutation(int idx, int semiResult) {
	        if (idx == su.length) {
	            ans = Math.max(ans, semiResult);
	            return;
	        }
	 
	        for (int i = 0; i < hores.length; i++) {
	            int jmp = su[idx];
	            // i가 jmp만큼 점프한다
	            int now = hores[i]; // 현 인덱스
	            if (now == -1)
	                continue; // 끝난 말이 또 주사위 던지는 경우
	            else {
	                if(map[now][jmp]==-1) {
	                    visited[now]=false;
	                    hores[i]=map[now][jmp];
	                    permutation(idx + 1, semiResult); //추가 없이 끝나버려
	                    visited[now]=true;
	                    hores[i]=now;
	                }
	                else if (visited[map[now][jmp]]) //이미 다른 말이 있는 경우
	                    continue;
	                else { // 살아있는 말이고 이동할 수 있는 칸인 경우
	                    visited[now] = false; // 빈칸으로 만들기
	                    visited[map[now][jmp]] = true;
	                    hores[i] = map[now][jmp];
	                    permutation(idx + 1, semiResult + map[map[now][jmp]][0]);
	                    visited[now] = true;
	                    visited[map[now][jmp]] = false;
	                    hores[i] = now;
	                }
	            }
	        }
	    }


}
