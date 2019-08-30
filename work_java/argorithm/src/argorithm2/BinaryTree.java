package argorithm2;

public class BinaryTree {
	private char[] tree;
	int max_depth;
	public BinaryTree(int max_depth) {
		//깊이가 4이면 배열의 크기는 15, 16칸 짜리 배열 만들어주기
		tree=new char[1<<max_depth];
		this.max_depth = max_depth;
	}
	
	public void preorder(int node) {
		//전위순회 : 부모 > 좌 > 우
		System.out.print(tree[node]); //부모방문
		if(node *2 < tree.length && tree[node*2] != '\0') {
			// 왼쪽 노드가 존재를 하면 ! tree 안에 있으면서 0이 아닌 값 
			preorder(node*2);
		}
		if(node *2 +1< tree.length && tree[node*2+1] != '\0') {
			preorder(node*2+1);
		}	
//		if(node>=tree.length || tree[node] == '\0') {
//			return;
//		}
//		System.out.print(tree[node]);
//		preorder(node*2);
//		preorder(node*2+1);

	}
	public void inorder(int node) {
		if (node>=tree.length || tree[node] == '\0') {
			return;
		}
		inorder(node * 2);
		System.out.print(tree[node]);
		inorder(node * 2 + 1);
	}
	public void postorder(int node) {
		if (node>=tree.length || tree[node] == '\0') {
			return;
		}
		postorder(node * 2);
		postorder(node * 2 + 1);
		System.out.print(tree[node]);
		
	}
	public void levelorder(int node) {
		
	}
	
	
	public void setRoot(char data) {
		tree[1] = data;
	}
	public void setLeft(int parent, char data) {
		tree[parent *2]= data;
	}
	public void setRight(int parent, char data) {
		tree[parent *2 +1]= data;
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
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(4);
		tree.setRoot('+');
		tree.setLeft(1, '*');
		tree.setRight(1, '/');
		tree.setLeft(2, '+');
		tree.setRight(2, '*');
		tree.setLeft(3, '-');
		tree.setRight(3, '3');
		tree.setLeft(4, '1');
		tree.setRight(4, '2');
		tree.setLeft(5, '3');
		tree.setRight(5, '5');
		tree.setLeft(6, '4');
		tree.setRight(6, '2');
		System.out.println(tree);
		
		tree.preorder(1);
		System.out.println();
		tree.inorder(1);
		//1번 노드(루트)로부터 전체 트리를 전위순회방식으로 노드 방문 출력
	}

}
