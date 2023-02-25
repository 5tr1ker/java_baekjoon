import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	int idx;
	Node left , right;
	
	public Node(int idx) {
		this.idx = idx;
		right = left = null;
	}
}

public class Main {
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rootIdx = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		Node root = new Node(rootIdx);
		while(true) {
			String str = br.readLine();
			if(str == null || str == "")
				break;
			
			int idx = Integer.parseInt(str);
			insert(idx , root);
		}
		
		prefixSearch(root);
		System.out.println(sb);
		
	}
	
	public static void insert(int idx , Node node) {
		if(node.idx > idx) { // 만약 루트 노드보다 작을 경우!?
			if(node.left == null) { // 만약 노드가 빈값일 경우..
				node.left = new Node(idx);
				return;
			}
			
			insert(idx , node.left); // 탐색을 더 합니다..
		}
		else if(node.idx < idx) { // 만약 루트 노드보다 클 경우!?
			if(node.right == null) { // 해당 노드가 비어있을 경우..
				node.right = new Node(idx);
				return;
			}
			
			insert(idx , node.right); // 탐색을 더 합니다..
			
		}
	}
	
	public static void prefixSearch(Node node) { // 후위 순회
		if(node.left != null) {
			prefixSearch(node.left);
		}
		if(node.right != null) {
			prefixSearch(node.right);
		}
		
		sb.append(node.idx).append("\n");
		
	}
	
}