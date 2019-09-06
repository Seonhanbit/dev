package sw_expert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s_1247_최적경로 {
	static class ref {
		public int x;
		public int y;

		public ref(int a, int b) {
			this.x = a;
			this.y = b;
		}

		@Override
		public String toString() {
			return "ref [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			ref[] arr = new ref[n+2];
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
//			System.out.println(Arrays.toString(arr));

			perm(arr, 2);
			System.out.println("#" + tc + " " + min);
		}
	}

	static int min;

	static void perm(ref[] arr, int k) {
		if (k == arr.length) {
			int sum=0;
			sum += Math.abs(arr[0].x - arr[2].x) + Math.abs(arr[0].y - arr[2].y);
			for (int i = 2; i < arr.length-1; i++) {
				sum += Math.abs(arr[i].x - arr[i + 1].x) + Math.abs(arr[i].y - arr[i + 1].y);
			}
			sum += Math.abs(arr[arr.length - 1].x - arr[1].x) + Math.abs(arr[arr.length - 1].y - arr[1].y);

			if (min > sum)
				min = sum;
			return;
		}
		for (int i = k; i < arr.length; i++) {
			swap(arr, i, k);
			perm(arr, k + 1);
			swap(arr, i, k);
		}
	}

	static void swap(ref[] arr, int a, int b) {
		ref tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	/*
	 * static void perm(ref[] arr, int idx, ref[] result, boolean[] visited){
	 * if(idx == arr.length){
	 * return;}
	 * for(int i=0; i<arr.length; i++){
	 * if(!visited[i]){
	 * result[idx] = arr[i];
	 * visited[i] = true;
	 * perm(ref[] arr, int idx+1, ref[] result, boolean[] visited);
	 * visited[i] = false;
	 */

}
