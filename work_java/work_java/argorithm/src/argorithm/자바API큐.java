package argorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 자바API큐 {

	public static void main(String[] args) {
//		Queue<String> queue = new LinkedList<>();
//		queue.add("삽입");
//		//빼기
//		System.out.println(queue.poll());
//		//안뺴고 다음 빠질거 확인만
//		System.out.println(queue.peek());
		
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int n = sc.nextInt();
		
//		for(int i=n; i>=1; i--) {
//			queue.add(i);
//		}
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		while(true) {
			if(queue.size()==1)break;
			queue.poll();
			queue.add(queue.peek());
			queue.poll();
		}
		System.out.println(queue.poll());
		
	}
}
