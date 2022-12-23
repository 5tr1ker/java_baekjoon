import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int vertex;
	int weight;
	
	public Point(int vertex , int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Point>> list = new ArrayList<ArrayList<Point>>();
		for(int i = 0 ; i <= N ; i++)
			list.add(new ArrayList<Point>());
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(s).add(new Point(e , weight));
		}
		
		int weight[] = new int[N + 1];
		PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});
		
		st = new StringTokenizer(br.readLine() , " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N ; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		weight[start] = 0;
		queue.add(new Point(start , 0));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			if(point.weight > weight[point.vertex]) continue;
			for(Point data : list.get(point.vertex)) {
				if(weight[data.vertex] > weight[point.vertex] + data.weight) {
					weight[data.vertex] = weight[point.vertex] + data.weight;
					queue.offer(new Point(data.vertex , weight[data.vertex]));
				}
			}
		}
		
		System.out.println(weight[end]);
	}
}