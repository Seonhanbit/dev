package preTest;

import java.io.*;
import java.util.*;

public class s_2112_보호필름 {
	static int T, D, W, K, res, res1;
	static int[][] arr;
	static int[][] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			res = Integer.MAX_VALUE;
			res1 = Integer.MAX_VALUE;
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			tmp = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < D; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}
			int cnt = check();

			if (cnt != W) {
				int[] narr = new int[D];
				for (int i = 0; i < D; i++)
					narr[i] = i;
				powerset(narr, 0, new boolean[D]);
			} else {
				res = 0;
			}

			bw.append("#" + String.valueOf(tc) + " " + String.valueOf(res) + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void powerset(int[] narr, int idx, boolean[] sel) {
		if (idx == narr.length) {
			for (int i = 0; i < D; i++) {
				tmp[i] = Arrays.copyOfRange(arr[i], 0, arr[i].length);
			}
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < D; i++) {
				if (sel[i])
					list.add(narr[i]);
			}
			// System.out.println(list);
			if (list.size() != 0 && list.size() < res) {
				int cnt = func(list);
				res = Math.min(res, cnt);
			}
			list.clear();
			return;
		}
		sel[idx] = false;
		powerset(narr, idx + 1, sel);
		sel[idx] = true;
		powerset(narr, idx + 1, sel);
	}

	static void dfs() {
		
	}
	
	static int func(ArrayList<Integer> list1) {
		if (list1.size() == 1) {
			int cnt = func2(list1, list1);
			return cnt;
		} else {
			combi(list1, 0, new boolean[list1.size()]);
			return res1;
		}
	}

	static void combi(ArrayList<Integer> list, int idx, boolean[] sel) {
		if (idx == list.size()) {
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (sel[i])
					list1.add(list.get(i));
				else
					list2.add(list.get(i));
			}
			if (list.size() != 0 && list.size() < res) {
				int cnt = func2(list1, list2);
				res1 = Math.min(res1, cnt);
			}

			list1.clear();
			list2.clear();
			return;
		}
		sel[idx] = false;
		combi(list, idx + 1, sel);
		sel[idx] = true;
	}

	static int func2(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int k = 0; k < list1.size(); k++) {
			for (int j = 0; j < W; j++) {
				tmp[list1.get(k)][j] = 0;
			}
		}
		int cnt = check();

		for (int k = 0; k < list2.size(); k++) {
			for (int j = 0; j < W; j++) {
				tmp[list2.get(k)][j] = 1;
			}
		}
		int cnt1 = check();
		if (cnt < cnt1)
			return cnt;
		else
			return cnt1;
	}

	static int check() {
		int cnt = 0;
		for (int j = 0; j < W; j++) {
			boolean ck = true;
			ArrayList<Integer> list = new ArrayList<>();
			loof: for (int i = 0; i < D; i++) {
				list.add(tmp[i][j]);
				for (int k = 0; k < list.size(); k++) {
					if (tmp[i][j] != list.get(k)) {
						ck = false;
						int a = list.get(k);
						if (list.size() >= K) {
							ck = true;
							break loof;
						}
						list.clear();
						list.add(a);
					}
					if (list.size() >= K) {
						ck = true;
						break loof;
					}
				}
			}
			if (ck) {
				cnt++;
			}
		}
		return cnt;
	}

}
