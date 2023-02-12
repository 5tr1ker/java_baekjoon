import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	int vertex , weight;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", weight=" + weight + "]";
	}
	
	
}

public class Main {
	static final int INF = 987654321;
	static int N , M , W;
	static ArrayList<ArrayList<Node>> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int itc = 0 ; itc < TC; itc++) {
			st = new StringTokenizer(br.readLine() , " ");
			map = new ArrayList<>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			for(int i = 0; i <= N; i++)
				map.add(new ArrayList<Node>());
				
			// 순방향
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				map.get(start).add(new Node(end , weight));
				map.get(end).add(new Node(start , weight));
			}
			
			// 웜홀
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				map.get(start).add(new Node(end , -weight));
			}
			
			boolean flag = false;
			
			for(int i = 1; i <= N ; i++) {
				if(belmanFord(i)) {
					flag = true;
					break;
				}
			}
			
			if(flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean belmanFord(int start) {
		int vertexWeight[] = new int[N + 1];
		Arrays.fill(vertexWeight, INF);
		vertexWeight[start] = 0;
		boolean flag = false;
		
		for(int i = 1; i < N; i++) {
			flag = false;
			
			for(int j = 1; j <= N; j++) {
				for(Node nd : map.get(j)) {
					if(vertexWeight[j] != INF && vertexWeight[nd.vertex] > vertexWeight[j] + nd.weight) {
						vertexWeight[nd.vertex] = vertexWeight[j] + nd.weight;
						flag = true;
					}					
				}
			}
			
			if(!flag) {
				break;
			}
		}
		
		if(flag) {
			for(int i = 1; i <= N; i++) {
				for(Node nd : map.get(i)) {
					if(vertexWeight[i] != INF && vertexWeight[nd.vertex] > vertexWeight[i] + nd.weight) {
						return true;
					}
				}
			}
		}
		return false;
	}
}