package argorithm;

import java.util.Scanner;

public class 원형큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 5칸 이용할 수 있음
		int[] queue = new int[6];
		int front = 0;
		int rear = 0;

		while (true) {
			System.out.println("1. enQueue \n2. deQueue \n0. End");
			int sel = sc.nextInt();
			if (sel == 1) {
				int num = sc.nextInt();
				if (front == (rear + 1) % 6) {
					System.out.println("풀이야");
				} else {
					rear = (rear + 1) % 6;
					queue[rear] = num;
				}
			} else if (sel == 2) {
				if (front == rear) {
					System.out.println("Empty!!!!!!!!!!!");
				} else {
					front =(front + 1) % 6;
					System.out.println(queue[front]);
				}
			} else if (sel == 0) {
				break;
			}
		}
	}
}
