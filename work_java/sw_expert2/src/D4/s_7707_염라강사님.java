package D4;

import java.io.*;
import java.util.*;

public class s_7707_염라강사님 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 이름 갯수
			TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length())
						return o1.compareTo(o2);
					return Integer.compare(o1.length(), o2.length());
				}
			});

			for (int i = 0; i < N; i++) {
				ts.add(br.readLine());
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + "\n");
			for(String s : ts)
				sb.append(s).append("\n");

			//iterator는 하나씩 꺼내주기
/*			Iterator<String> itr = ts.iterator();
            while (itr.hasNext())
                bw.write(itr.next() + "\n");*/
			
			bw.write(sb.toString());
			bw.flush();
		}
		bw.close();
	}
}
