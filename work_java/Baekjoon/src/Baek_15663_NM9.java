
import java.io.*;
import java.util.*;

public class Baek_15663_NM9 {
	static TreeSet<String> set;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		set = new TreeSet();
		func(new int[m], 0, new boolean[n]);
/*		for(int i=0; i<set.size(); i++) {
			int[] tmp = set.;
			for(int j=0; j<set.get(i).length; j++) {
				System.out.print(tmp[j]+" ");
			}System.out.println();
		}*/
	}

	static void func(int[] sel, int idx, boolean[] visited) {
		if (idx == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx] = arr[i];
				func(sel, idx + 1, visited);
				visited[i] = false;
			}
		}
	}
}
