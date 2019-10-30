package preTest;

import java.io.*;
import java.util.*;

public class s_5672_올해의조련사 {
	static int N, T;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 앵무새갯수
			arr = new char[N]; // 앵무새 이름 넣을 배열
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().charAt(0);
			}
			StringBuilder sb = new StringBuilder();
			// 처음 검사할 값과 마지막 검사할 값
			int front = 0;
			int back = N - 1;
			// 처음 값과 마지막 값이 같을 때까지 돌거야
			while (front <= back) {
				if (front == back) {
					sb.append(arr[back]);
					break;
				}
				if (arr[front] < arr[back]) {
					// 앞에 것이 작을때
					sb.append(arr[front]);
					front++;
				} else if (arr[front] > arr[back]) {
					// 마지막 것이 작을때
					sb.append(arr[back]);
					back--;
				} else {
					// 둘다 같을때 새로운 변수에 담아주기. 계속 검사할꺼니까!
					int nf = front;
					int nb = back;

					while (true) {

						if (nf >= nb) {
							// 결국 서로가 만날때 뒤에 것 넣어주고 하나 줄여주기
							sb.append(arr[back]);
							back--;
							break;
						}
						// 서로가 다를때
						if (arr[nf] != arr[nb]) {
							if (arr[nf] < arr[nb]) {
								// 앞에 것이 작을때 결과적으로 front를 넣어줌! 
								sb.append(arr[front]);
								front++;
							} else {
								//뒤에 것이 작을때는 결과적으로 back을 넣어줌!
								sb.append(arr[back]);
								back--;
							}
							break;
						}
						// 같을때는 앞에거 줄여주고, 뒤에꺼 빼주고
						nf++;
						nb--;
					}
				}
			}

			bw.append("#").append(String.valueOf(tc)).append(" ").append(sb + "\n");
			bw.flush();
		}
		bw.close();
	}
}
