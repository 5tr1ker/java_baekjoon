import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	int end , weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

public class Main {
	
	static int N , M;
	static ArrayList<Node>[] map;
	static final int INF = 999_999_999;
	static long vertexWeight[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			map[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end , weight));
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(bellmanFord()) {
			for(int i = 2; i <= N; i++) {
				if(vertexWeight[i] != INF) sb.append(vertexWeight[i]).append("\n");
				else sb.append("-1").append("\n");
			}
		} else {
			sb.append("-1");
		}
		
		System.out.println(sb);
	}
	
	public static boolean bellmanFord() {
		vertexWeight = new long[N + 1];
		Arrays.fill(vertexWeight , INF);
		vertexWeight[1] = 0L;
		boolean flag = false;
		
		for(int i = 1; i <= N; i++) {
			flag = false;
			for(int j = 1; j <= N; j++) {
				for(Node nd : map[j]) {
					if(vertexWeight[j] != INF && vertexWeight[nd.end] > vertexWeight[j] + nd.weight) {
						vertexWeight[nd.end] = vertexWeight[j] + nd.weight;
						flag = true;
					}
				}
			}
			
			if(!flag) break;
			
		}
		
		if(flag) {
			for(int i = 1; i <= N; i++) {
				for(Node nd : map[i]) {
					if(vertexWeight[i] != INF && vertexWeight[nd.end] > vertexWeight[i] + nd.weight) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}