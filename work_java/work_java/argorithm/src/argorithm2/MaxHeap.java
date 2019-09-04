package argorithm2;

public class MaxHeap {
	private int[] tree;
	int size = 0;
	int max_depth;
	
	public MaxHeap(int max_depth) {
		this.max_depth = max_depth;
		tree = new int[1<<max_depth];
		tree[0] = 9999999;
	}

	public void add(int data) {
		tree[++size] = data;
		
		//부모가 나보다 더 큰지 검사
		int current = size;//지금 들어가 노드
//		int parent = parent(current);
		//while(나와 나의 부모가 더 큰지 비교, 내가 크면 참 )
		//나와 부모의 자리를 교환/ 나를 이동한 자리로 인덱스 변경
		while(tree[current] > tree[parent(current)]) {
			int tmp = tree[current];
			tree[current] = tree[parent(current)];
			tree[parent(current)] = tmp;
			current = parent(current);
		}
	}
	public int poll() {
		int data = tree[1];
		tree[1] = tree[size--];
		changeChild(1);
		return data;
	}
	
	public void changeChild(int node) {
		//완전 이진트리는 사이즈 나누기 2부터 말단 -- 기저파트
		if(node >= size/2 && node <= size) {
			return;
		}
		if(tree[leftChild(node)] > tree[rightChild(node)] ) {
			//왼쪽이 더 큼 > 그 왼쪽이 나보다 더 크면 바꿔
			if(tree[node] <tree[leftChild(node)]) {
				int tmp = tree[node];
				tree[node] = tree[leftChild(node)];
				tree[leftChild(node)] = tmp;
				changeChild(leftChild(node));
			}
		}else {
			//오른쪽이 더 큼
			if(tree[node] <tree[rightChild(node)]) {
				int tmp = tree[node];
				tree[node] = tree[rightChild(node)];
				tree[rightChild(node)] = tmp;
				changeChild(rightChild(node));
			}
		}
	}
	
	
	
	public int parent(int node) {
		System.out.println(tree[node/2]);
		return node/2; 
	}
	public int leftChild(int node) {
		System.out.println(tree[node*2]);
		return 2*node;
	}
	public int rightChild(int node) {
		System.out.println(tree[node*2+1]);
		return 2*node+1;
	}
	public String toString() {
		//이쁘게
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<max_depth; i++) {
			//1 << i : 1 2 4 8
			for(int j=0; j<(1<<i); j++) {
				//tree[(1<<i) + j]
//				System.out.print(tree[(1<<i) + j]);
				sb.append(tree[(1<<i) + j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(4);
		heap.add(13);
		heap.add(10);
		heap.add(12);
		heap.add(18);
		heap.add(20);
		heap.add(29);
//		
//		heap.parent(6);
//		heap.leftChild(2);
		System.out.println(heap);
	}

}
