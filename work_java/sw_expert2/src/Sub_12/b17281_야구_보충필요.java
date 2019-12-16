package Sub_12;

import java.io.*;
import java.util.*;

//순열을 구하기
//4번쨰 방문을 true

//1,2,3,4번째 
//1루타면 1씩 미뤄주기(1번째는 0을 넣어줌)
//2루타면 1루타를 2번해주기
//배열을 만들고 1,2,3번쨰는 한칸씩 미루고
//4번칸에 있는 숫자만큼 점수를 늘려주기(3번쨰에서 4번쨰는 누적합)

public class b17281_야구_보충필요 {
	static int N, res;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		visited = new boolean[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			int na = arr[i][0];
			arr[i][0] = arr[i][3];
			arr[i][3] = na;
			visited[i][3] = true;
		}

	}
	static void perm() {
		
	}
}
