import java.io.*;
import java.util.*;

public class hw_ct_1023 {
	static int N, res;
	static int[][] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		res = (1+(N*N))*N/2;

		obb(0, N / 2);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println(check());
		bw.write(res + "\n");
		bw.flush();
		bw.close();
	}
	//홀수
	static void obb(int x, int y) {
		/*
		 * 마방진 순서 1. 첫 순서는 첫행 가운데에 넣기 
		 * 2. i가 N의 배수이면 바로 아래의 행으로 이동하여 다음 수 넣기 
		 * 3. 배수가 아니면, 왼쪽 위로 이동하여 다음 수 넣기 
		 * 3-1. 행이 0을 벗어나면 마지막 행으로 이동 
		 * 3-2. 열이 0을 벗어나면 마지막 열로 이동
		 */
		arr[x][y] = 1;
		for (int i = 2; i <= N * N; i++) {
			if (i % N == 1) {
				x++;
				if (x == N)
					x = 0;
				arr[x][y] = i;
			} else {
				x--;
				y--;
				if (x == -1)
					x = N - 1;
				if (y == -1)
					y = N - 1;
				arr[x][y] = i;
			}
		}
	}
	//짝수
	static void even() {
/*		4로 나눌때 
		행이 1,4지점이면 열이 같은 지점은 그대로, 
			열이 2,3 지점은 반대(N*N부터 점점 작아짐)
		행이 2,3지점이면 열이 같은 지점은 그대로,
			열이 1,4 지점은 반대로*/
	}

	static boolean check() {
		boolean ck = true;
		int idx = 0;
		int sum=0;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < N; j++) {
				sum += arr[i][j];
			}
			if(sum!=res)
				ck=false;
		}
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < N; j++) {
				sum += arr[j][i];
			}
			if(sum!=res)
				ck=false;
		}
		
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < N; j++) {
				sum += arr[j][i];
			}
			if(sum!=res)
				ck=false;
		}
		sum=0;
		for(int i=0; i<N; i++) {
			sum+=arr[i][i];
		}
		if(sum!=res)
			ck=false;
		
		sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i+j==N-1)
					sum+=arr[i][j];
			}
		}
		if(sum!=res)
			ck=false;
		
		if (ck)
			return true;
		else
			return false;
	}
}
