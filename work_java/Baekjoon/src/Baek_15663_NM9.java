
import java.io.*;
import java.util.*;

public class Baek_15663_NM9 {
	static int n, m;
	static HashSet<String> set;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		set = new HashSet();
		func(new int[m], 0, 0);

		System.out.print(sb.toString());
	}

	static void func(int[] sel, int idx, int n) {
		if (idx == m) {
			String str = "";
			for (int i = 0; i < sel.length; i++) {
				str += sel[i] + " ";
			}
			// System.out.println(str);
			if (set.add(str)) {
				for (int i = 0; i < sel.length; i++) {
					sb.append(sel[i]).append(" ");
				}
				sb.append('\n');
			}

			return;
		}
		if (n == arr.length)
			return;
		sel[idx] = arr[n];
		func(sel, idx + 1, n);
		func(sel, idx, n+1);
	}
}
