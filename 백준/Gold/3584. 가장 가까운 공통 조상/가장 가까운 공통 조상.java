import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	public static ArrayList<Integer>[] arr;
	public static boolean check[];
	public static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(TC-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new ArrayList[N + 1];
			check = new boolean[N + 1];
			for(int i = 0; i <= N; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				arr[child].add(parent);
			}
			
			st = new StringTokenizer(br.readLine() , " ");
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			
			dfs(idx1);
			dfs(idx2);
			sb.append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int idx) {
		if(check[idx]) { // 이미 방문한 노드가 있다면?
			ans = idx;
			return;
		}
		
		check[idx] = true;
		
		for(int node : arr[idx]) {
			dfs(node);
		}
		
	}

}