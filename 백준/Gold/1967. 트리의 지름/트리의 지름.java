import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static ArrayList<ArrayList<Point>> list = new ArrayList<ArrayList<Point>>();
	static boolean check[];
	static int N;
	static int max = 0;
	static int maxVertex = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<=N; i++)
			list.add(new ArrayList<Point>());
		
		StringTokenizer st;
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Point(end , weight));
			list.get(end).add(new Point(start , weight));
		}
		
		check = new boolean[N + 1];
		check[1] = true;
		dfs(1 , 0);
		
		check = new boolean[N + 1];
		check[maxVertex] = true;
		dfs(maxVertex , 0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int idx , int weight) {
		if(max <= weight) {
			max = weight;
			maxVertex = idx;
		}
		
		for(Point pnt : list.get(idx)) {
			if(!check[pnt.vertex]) {
				check[pnt.vertex] = true;
				dfs(pnt.vertex , weight + pnt.weight);
			}
		}
		
	}
	
}