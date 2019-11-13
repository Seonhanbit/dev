package preTest;

import java.io.*;
import java.util.*;

public class s_4013_특이한자석 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int K = sc.nextInt();
            LinkedList<Integer>[] dq = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                dq[i] = new LinkedList<>();
                for (int j = 0; j < 8; j++) {
                    dq[i].add(sc.nextInt());
                }
            }
            for (int k = 0; k < K; k++) {
                int[] ck = new int[4];
                int idx = sc.nextInt() - 1;
                int dir = sc.nextInt(); //방향
                ck[idx] = dir;
                //앞(왼쪽)부분 체크하기
                for (int i = idx; i >= 1; i--) {
                    if (dq[i].get(6) == dq[i - 1].get(2))
                        break;
                    //방향을 바꾸기 위해서 -1을 곱해주기
                    ck[i - 1] = ck[i] * -1;
                }
                //뒷(오른쪽)부분체크하기
                for (int i = idx; i < 3; i++) {
                    if (dq[i].get(2) == dq[i + 1].get(6))
                        break;
                  //방향을 바꾸기 위해서 -1을 곱해주기
                    ck[i + 1] = ck[i] * -1;
                }
                for(int i=0; i<4; i++) {
                    if(ck[i]==-1) {
                    	//반시계 방향으로 돌기
                        dq[i].addLast(dq[i].pollFirst());
                    }
                    else if(ck[i] == 1){
                    	//시계 방향으로 돌기
                        dq[i].addFirst(dq[i].pollLast());
                    }
                }
            }
            
            int sum=0;
            for(int i=0; i<4; i++) {
                if(dq[i].get(0) == 1) {
                    sum+=Math.pow(2, i);
                }
            }
            
            System.out.println("#"+ tc+" "+sum);
        }
    }

}
