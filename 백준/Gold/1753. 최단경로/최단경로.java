import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
	int vertex;
	int weight;
	
	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class Main {
	
	public static int INF = 99999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Edge(v , w));
		}
		
		boolean[] check = new boolean[V + 1];
		int weight[] = new int[V + 1];
		
		for(int i = 1; i <= V; i++)
			weight[i] = INF;
		
		weight[start] = 0;
	
		for(int i = 1; i <= V; i++) {
			int findVertex = 0;
			int findWeight = Integer.MAX_VALUE;
			
			for(int j = 1; j <= V; j++) {
				if(weight[j] < findWeight && !check[j]) {
					findVertex = j;
					findWeight = weight[j];
				}
			}
			check[findVertex] = true;
			// 가장 작은값 찾기
			
			for(Edge edge : list.get(findVertex)) {
				weight[edge.vertex] = Math.min(weight[edge.vertex], weight[findVertex] + edge.weight);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(weight[i] == INF) sb.append("INF").append("\n");
			else sb.append(weight[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}