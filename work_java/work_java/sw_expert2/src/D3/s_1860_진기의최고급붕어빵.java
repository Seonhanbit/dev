package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class s_1860_진기의최고급붕어빵 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String st1 = br.readLine();
			StringTokenizer st = new StringTokenizer(st1);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<>();
			String st2 = br.readLine();
			st = new StringTokenizer(st2);
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			System.out.print("#" + tc + " ");
			int list_end = list.get(list.size() - 1), bbang = -K;
			boolean ck = true;
			for (int i = 0; i <= list_end; i++) {
				if (i % M == 0)
					bbang += K;
				if (i == list.get(0)) {
					bbang -= 1;
					list.remove(0);
				}
				if (bbang < 0) {
					ck = false;
					break;
				}
			}
			if (ck) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
			
			
//            String msg = "Possible";
//            int idx = 0; // 현재 검사하는 고객님의 번호.
//            int fish = 0; // 현재 붕어빵의 갯수
//            // 가장 늦게 온 친구가 올 때까지 시간을 탐색
//            for(int i =0; i<=customers[N-1]; i++) {
//                if(i >0 && i%M == 0)
//                    fish += k;
//                // 현재 시간이 현재 검사하는 고객님의 도착시간과 같다면
//                // 붕어 하나 소비, 다음을 검사. 이것을 반복
//                while(idx < N && i == customers[idx]) {
//                    // 붕어빵 하나 주고
//                    fish--;
//                    // 다음 고객 검사
//                    idx++;
//                    // 하고나서도 다음 고객도 같은 시간일 수 있으니 반복적으로 현재 시간이 고객 도착 시간인지를 검사
//                    // 붕어가 음수로 빠지면 못준거네요
//                    if(fish < 0) {
//                        msg = "Impossible";
//                        break;
//                    }
//                }
//            }
			
			
			
			
			
			
			
		}
	}

}
