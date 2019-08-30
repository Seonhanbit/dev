package argorithm2;

public class LinkedQueueTest {
	Node front;
	Node rear;

	void enQueue(int data) {
		Node newNode = new Node();
		newNode.data = data;
		// front가 null이면 빈큐
		// 빈큐이면 새로운 노드 객체를 front와 rear가 참조
		if (front == null) {
			front = newNode; // 객체는 주소를 가리킴
			rear = newNode;
		}
		// 빈큐가 아니면 새로운 노드 객체를 현재 rear의 link에 지정 후 rear도 새로운 놈을 참조
		else {
			rear.link = newNode;
			rear = newNode;
		}
	}

	int deQueue() {
		// front가 null이면 빈 큐라서 인출 못함 (-1리턴)
		if (front == null) {
			return -1;
		}
		// front의 데이터를 인출하고 front의 link에 있는 놈을 front에 연결
		// front가 null이 되면 rear도 null로 변경
		int data = front.data;
		front = front.link;
		if (front == null) {
			rear = null;
		}
		return data;
	}

	static class Node {
		int data;
		Node link;
	}

	public static void main(String[] args) {
		LinkedQueueTest lq = new LinkedQueueTest();
		lq.enQueue(10);
		lq.enQueue(20);
		
		System.out.println(lq.deQueue());
		System.out.println(lq.deQueue());
		System.out.println(lq.deQueue());

	}

}
