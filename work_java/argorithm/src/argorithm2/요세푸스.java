package argorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스 {
	public static void main(String[] args) {
		// 1차원 배열 이용 -> 배열 0부터 끝까지 반복..반복..하는 과정에서
		// k번째일때 해당 원소의 값을 -1로 변경, -1인건 쿵쿵따 횟수로 치지않음

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		int idx = 0;
		int cnt = 0;
		int outputCnt = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (true) {
			if (arr[idx % n] != -1) {
				cnt++;
			}
			if (cnt == k) {
//				System.out.println(arr[idx%n]);
				sb.append(arr[idx % n]).append(",");
				cnt = 0;
				outputCnt++;
				arr[idx % n] = -1;
				if (outputCnt == n)
					break;
			}
			idx++;
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append(">");
		System.out.println(sb.toString());

		
		
		
		
		
		Queue<Integer> queue = LinkedeList();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int cn = 0;
		while (!queue.isEmpty()) {
			for (int i = 0; i < n-1; i++) {
				cnt++;
				if (cnt < k) {
					queue.add(i);
					queue.poll();
				}else {
					System.out.print("<" + queue.poll()+",");
				}
			}
			System.out.print(">");
		}

//		ArrayList<Integer> list = new ArrayList<Integer>();
//
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//
//		for (int i = 1; i <= n; i++) {
//			list.add(i);
//		}
//
//		int cnk = 0;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) % k == 0) {
//				list.remove(i);
//				cnk = list.size() - i;
//			}
//		}
//		System.out.println(list);
//		System.out.println(cnk);
//
//		if (cnk > 0) {
//			int nk = k - cnk;
//			System.out.println(nk);
//			for (int i = 0; i <= list.size(); i++) {
//				if (i == nk) {
//					list.remove(i);
//				} else if (i % k == 0) {
//					list.remove(i);
//					cnk = list.size() - i;
//				}
//			}
//		}
//		System.out.println(list);

	}

	private static Queue<Integer> LinkedeList() {
		// TODO Auto-generated method stub
		return null;
	}

}
