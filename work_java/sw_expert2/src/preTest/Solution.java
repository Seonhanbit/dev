package preTest;

import java.io.*;
import java.util.*;

public class Solution {
	static int N, res;
	static int[][] arr;
	static ArrayList<Person> person;
	static ArrayList<Stair> stair;

	// 거리 구하는 함수
	static int ck(int x, int x1, int y, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}

	static class Person implements Comparable<Person> {
		// 행,열,선택(0,1), 배열(1계단거리, 2계단거리)
		int x, y;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
			dist = new int[2];
		}

		int[] dist;
		int sel;

		@Override
		public int compareTo(Person o) {
			return this.dist[sel] - o.dist[o.sel];
		}

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", dist=" + dist + ", sel=" + sel + "]";
		}

	}

	static class Stair {
		int x, y, cnt;

		Stair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			person = new ArrayList<>();
			stair = new ArrayList<>();
			res = Integer.MAX_VALUE;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1)
						person.add(new Person(i, j));
					if (arr[i][j] != 1 && arr[i][j] != 0)
						stair.add(new Stair(i, j, arr[i][j]));
				}
			}
			
			
		}
	}
}
