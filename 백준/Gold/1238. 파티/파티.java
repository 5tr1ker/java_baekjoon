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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
		ArrayList<ArrayList<Edge>> list2 = new ArrayList<ArrayList<Edge>>();
		int result[] = new int[n + 1];
		int result2[] = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Edge>());
			list2.add(new ArrayList<Edge>());
			result[i] = INF;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(dx).add(new Edge(dy, weight));
			list2.get(dy).add(new Edge(dx, weight));
		}
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});

		result[x] = 0;
		queue.offer(new Edge(x, 0));
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();

			if (edge.weight > result[edge.vertex])
				continue;

			for (Edge data : list.get(edge.vertex)) {
				if (result[data.vertex] > result[edge.vertex] + data.weight) {
					result[data.vertex] = result[edge.vertex] + data.weight;
					queue.offer(new Edge(data.vertex, result[data.vertex]));
				}
			}
		}

		int answer = 0;
		for (int j = 1; j <= n; j++)
			result2[j] = INF;

		result2[x] = 0;
		queue.offer(new Edge(x, 0));

		while (!queue.isEmpty()) {
			Edge edge = queue.poll();

			if (result2[edge.vertex] < edge.weight)
				continue;
			for (Edge data : list2.get(edge.vertex)) {
				if (result2[data.vertex] > result2[edge.vertex] + data.weight) {
					result2[data.vertex] = result2[edge.vertex] + data.weight;
					queue.offer(new Edge(data.vertex, result2[data.vertex]));
				}
			}
		}
		
		for(int i = 1; i <= n ; i++)
			answer = Math.max(answer, result[i] + result2[i]);
			
		System.out.println(answer);

	}

}