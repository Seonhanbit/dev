import java.io.*;
import java.util.*;

public class Baek_16234 {
	static int N, L, R, sum;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<XY> queue;
	
	static class XY{
		int x;
		int y;
		int sum;
		XY(int x, int y, int sum){
			this.x =x;
			this.y =y;
			this.sum = sum;
		}
	}

	static boolean range(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bw.append(sum + "\n");
		bw.flush();
		bw.close();
	}

	static void bfs() {
		
	}
}
