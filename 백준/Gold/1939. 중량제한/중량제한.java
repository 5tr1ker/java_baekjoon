import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int n , weight;

	public Node(int n, int weight) {
		this.n = n;
		this.weight = weight;
	}
}

public class Main {
	
	static ArrayList<Node> arr[];
	static int N , start , end;
	static boolean check[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N + 1];
		for(int i = 0; i <= N ; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			min = Math.min(min, weight);
			max = Math.max(max, weight);
			arr[start].add(new Node(end , weight));
			arr[end].add(new Node(start , weight));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int result = 0;
		while(min <= max) {
			check = new boolean[N + 1];
			check[start] = true;
			
			int half = (min + max) / 2;
			if(bfs(half)) {
				min = half + 1;
				result = half;
			} else {
				max = half - 1;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean bfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
			if(data == end) return true;
			for(Node nd : arr[data]) {
				if(!check[nd.n] && nd.weight >= idx) {
					queue.offer(nd.n);
					check[nd.n] = true;
				}
			}
		}
		
		return false;
	}
	
}