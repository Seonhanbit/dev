package devsis;

import java.util.*;

public class p3 {
	static public int solution(int K, int[] A) {
		int answer = 0;

		int stdTrack = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
			if (stdTrack > A[i])
				stdTrack = A[i];
		}

		while (!list.isEmpty()) {
			boolean endNowTrack = true;
			int nowTrack = stdTrack;

			for (int i = 0; i < list.size(); i++) {
				if (nowTrack == list.get(i)) {
					list.remove(i--);
					nowTrack++;
					endNowTrack = false;
				}
			}

			if (endNowTrack)
				stdTrack++; //1번트랙 끝난 후 아무것도 안 들어가면 2번으로
			else
				answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		int ans = solution(5, new int[] { 1, 3, 4, 2, 5 });
//      int ans = solution(10, new int[] { 2, 2, 2, 1, 4 });
//      int ans = solution(10, new int[] { 5, 6, 7, 8, 9 });
		System.out.println(ans);
	}
}