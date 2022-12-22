import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
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
	
	public static String itos(int i) { return Integer.toString(i); }
	public static int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		ArrayList<ArrayList<Point>> list = new ArrayList<ArrayList<Point>>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Point>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(x).add(new Point(y , weight));
		}
		
		st = new StringTokenizer(br.readLine() , " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.weight - o2.weight;
			}
		});
		
		int weight[] = new int[N + 1];
		int prev[] = new int[N + 1];
		for(int i = 1; i <= N; i++)
			weight[i] = INF;
		
		weight[start] = 0;
		queue.offer(new Point(start , 0));
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			if(point.weight > weight[point.vertex]) continue;
			for(Point data : list.get(point.vertex)) {
				if(weight[data.vertex] > weight[point.vertex] + data.weight) {
					weight[data.vertex] = weight[point.vertex] + data.weight;
					prev[data.vertex] = point.vertex;
					queue.offer(new Point(data.vertex , weight[data.vertex]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(end);
		int idx = end;
		while(weight[idx] != 0) {
			stack.push(prev[idx]);
			idx = prev[idx];
		}
		
		sb.append(weight[end]).append("\n").append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}