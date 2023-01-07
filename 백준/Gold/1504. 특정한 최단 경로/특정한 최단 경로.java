import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int vertex;
	int weight;

	public Point(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class Main {

	static int N, E;
	static int weight[];
	static int INF = 200000000;
	static ArrayList<ArrayList<Point>> list = new ArrayList<ArrayList<Point>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Point>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(start).add(new Point(end, weight));
			list.get(end).add(new Point(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int result = Math.min(dijkstra(1 , u) + dijkstra(u , v) + dijkstra(v , N) ,
				dijkstra(1 , v) + dijkstra(v , u) + dijkstra(u , N) );
		
		System.out.println((result >= INF) ? -1 : result);
		
	}

	public static int dijkstra(int start, int dest) {
		weight = new int[N + 1];
		boolean check[] = new boolean[N + 1];
		PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.weight - o2.weight;
			}
		});
		Arrays.fill(weight, INF);

		weight[start] = 0;
		queue.add(new Point(start, 0));

		while (!queue.isEmpty()) {
			Point pnt = queue.poll();

			if (check[pnt.vertex])
				continue;

			check[pnt.vertex] = true;
			for (Point data : list.get(pnt.vertex)) {
				if(weight[data.vertex] > weight[pnt.vertex] + data.weight) {
					weight[data.vertex] = weight[pnt.vertex] + data.weight;
					queue.offer(new Point(data.vertex , weight[data.vertex]));
				}
			}
		}

		return weight[dest];
	}
}