package D4;

import java.io.*;
import java.util.*;

public class s_8567_약수의개수가많은수 {
	static int[] max_idx = new int[100001];
	static int[] arr = new int[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		calc(arr);
		max_idx[1] = 1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			bw.write("#" + tc + " " + max_idx[N] + "\n");
			bw.flush();
		}
		bw.close();
	}

	private static void calc(int[] arr2) {
		int temp = 1;
		for (int i = 2; i < arr.length; i++) {
			for (int j = i; j < arr.length; j += i) {
				arr[j]++;
				if (arr[i] > arr[temp])
					temp = i;
				else if (arr[i] == arr[temp]) {
					if (i > temp)
						temp = i;
				}
			}
			max_idx[i] = temp;
		}
		
/*		int max = 0;
		int maxIdx = 0;		
		for(int i=1; i<arr.length; i++) {
			if(max <=arr[i]) {
				max = arr[i];
				maxIdx
			}
		}*/
	}
}

/*public class 약수의개수가많은수 {
    static final int MAX = 100001;
    public static void main(String[] args) {
        int[] cnt = new int[MAX];
        for(int i = 1; i < MAX; i++) {
            for(int j = i; j < MAX; j += i )
                cnt[j]++;
        }
        int max = 0;
        int maxIdx = 0;
        for(int i = 1; i < MAX; i++) {
            if( max <= cnt[i] ) {
                max = cnt[i];
                maxIdx = i;
            }
            cnt[i] = maxIdx;
        }
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            System.out.println("#" + tc + " " + cnt[n]);
        }
    }
}*/