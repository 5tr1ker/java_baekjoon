import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
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
		
		int weight[] = new int[V + 1];
		
		for(int i = 1; i <= V; i++)
			weight[i] = INF;
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});
		queue.add(new Edge(start, 0));
		weight[start] = 0;
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(edge.weight > weight[edge.vertex]) continue;
			for(int i = 0; i < list.get(edge.vertex).size(); i++) {
				Edge data = list.get(edge.vertex).get(i);
				
				if(weight[data.vertex] > data.weight + edge.weight ) {
					weight[data.vertex] = data.weight + edge.weight;
					queue.offer(new Edge(data.vertex , weight[data.vertex]));
				}
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