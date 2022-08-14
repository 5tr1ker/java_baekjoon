import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int vertex;
	public static int graph[][];
	public static boolean check[];
	public static StringBuilder sb;
	
	public static void dfs(int start) {
		sb.append(start + " ");
		check[start] = true;
		
		for(int i = 1; i <= vertex; i++) {
			if(!check[i] && graph[start][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		int Q;
		
		while(!queue.isEmpty()) {
			Q = queue.poll();
			sb.append(Q + " ");
			check[Q] = true;
			
			for(int i = 1; i <= vertex; i++) {
				if(!check[i] && graph[Q][i] == 1) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		vertex = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		int N , M;
		graph = new int[vertex + 1][vertex + 1];
		
		
		for(int i = 1; i <= line; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph[M][N] = graph[N][M] = 1;
		}
		
		check = new boolean[vertex + 1];
		sb = new StringBuilder();
		dfs(start);
		System.out.println(sb);
		check = new boolean[vertex + 1];
		sb = new StringBuilder();
		bfs(start);
		System.out.println(sb);
	}
}
