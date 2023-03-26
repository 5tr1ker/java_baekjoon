import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char root;
	
	Node left;
	Node right;
	
	public Node(char root, Node left, Node right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [root=" + root + ", left=" + left + ", right=" + right + "]";
	}
}

public class Main {
	
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Node rootNode = new Node('A', null, null);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			insert(rootNode, root, left, right);
		}
		
		preOrder(rootNode);
		sb.append("\n");
		inOrder(rootNode);
		sb.append("\n");
		postOrder(rootNode);
		System.out.println(sb);
		
	}
	
	public static void insert(Node node , char root , char left , char right) {
		
		if(node.root == root) {
			node.left = (left == '.') ? null : new Node(left, null, null);
			node.right = (right == '.') ? null : new Node(right, null, null);
			return;
		}
		
		if(node.left != null) {
			insert(node.left , root , left , right);
		} 
		if (node.right != null) {
			insert(node.right , root , left , right);
		}
	}
	
	public static void preOrder(Node root) {
		sb.append(root.root);
		if(root.left != null) preOrder(root.left);
		if(root.right != null) preOrder(root.right);
	}
	
	public static void inOrder(Node root) {
		if(root.left != null) inOrder(root.left);
		sb.append(root.root);
		if(root.right != null) inOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		sb.append(root.root);
	}
	
}