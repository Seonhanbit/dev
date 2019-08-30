package argorithm2;

class MyLinkedList{
	Node head; 
	int size;
	
	void add(int idx, int data) {
		//idx번쨰 다음에 데이터 값을 갖는 새로운 노드를 연결
		Node node = new Node();
		node.data = data;
		//idx 친구를 찾아와서 그놈이 갖는 다음위치를 새로운 노드의 다음 위치로 지정, 그 놈의 다음 위치를 새로운 노드로 지정
		Node ideNode = getNode(idx);

		node.link = ideNode.link;
		ideNode.link = node;
		size++;
	}
	
	void addToFirst(int data) {
		//새로운 노드 객체를 생성해서 data(매개변수)를 data영역에 저장
		Node node = new Node();
		node.data = data;
		//head가 null이라면 첫 데이터이므로 헤드에 연결
		if(head == null) {
			head = node;
		}
		//아니라면 새로 만들어진 놈의 link를 헤드로 연결, 헤드를 새로운 놈으로 지정
		else {
			node.link = head;
			head = node;
		}
		size++;
	}
	
	void addToLast(int data) {
		//데이터를 담는 새로운 노드 객체 생성
		Node node = new Node();
		node.data = data;
		//head가 null이면 첫 데이터이므로 head에 연결
		if(head == null) {
			head = node;
		}
		//아니라면 head로부터 출발해서 맨 마지막 놈을 찾아서 마지막놈의 link에 연결
		else {
			Node tmp = head;
			while(tmp.link != null) {
				tmp = tmp.link;
			}
			tmp.link = node;
		}
		size++;
	}
	Node getNode(int idx) {
		//idx번째 위치의 data를 리턴
		//사이즈 없어도 되지만 null포인트 피하기 위해서 만듦
		if(size <=0|| size <=idx) {
			return null;
		}else {
			//head로부터 idx번 만큼 다음으로 이동시킨 후 그 위치의 객체를 리턴
			Node tmp = head;
			for(int i=0; i<idx; i++) {
				tmp = tmp.link;
			}
			return tmp;
		}
	}
	
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while(tmp != null) {
			sb.append(tmp.data).append(" ");
			tmp = tmp.link;
		}
		return sb.toString();
	}
	
	static class Node{
		int data;
		Node link;
	}
}

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList.Node n1 = new MyLinkedList.Node();
		n1.data = 10;
		
		MyLinkedList.Node n2 = new MyLinkedList.Node();
		n2.data = 20;
		n1.link = n2;
		
		MyLinkedList.Node n3 = new MyLinkedList.Node();
		n3.data = 30;
		n2.link = n3;
		
		MyLinkedList.Node n4 = new MyLinkedList.Node();
		n4.data = 40;
		n3.link = n4;
		
		n2 = n3 = n4 = null;
//		System.out.println(n1.link.link.link.data);
		//n4까지 있다는 모르는 상태에서 ..n1부터 출발해서 모든  친구들을 출력.
		
//		System.out.println(n1.data);
//		System.out.println(n1.link.data);
//		System.out.println(n1.link.link.data);
//		
//		MyLinkedList.Node tmp = n1;
//		
//		while(tmp != null) {
//			System.out.println(tmp.data);
//			tmp = tmp.link;
//		}
		
		MyLinkedList list = new MyLinkedList();
		list.addToFirst(10);
		list.addToFirst(20);
		list.addToFirst(30);
		list.addToLast(50);
		System.out.println(list);
//		System.out.println(list.getNode(3).data);
		list.add(3, 40);
		System.out.println(list);
	}

}
