import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N , M;
	static int arr[][];
	static boolean check[];
	
	public static void dfs(int j) {
		for(int n = 1; n <= N; n++) {
			if(arr[j][n] == 1 && !check[n]) {
				check[n] = true;
				dfs(n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		check = new boolean[N + 1];
		int count = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[y][x] = arr[x][y] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!check[i]) {
				count++;
				dfs(i);
			}
		}
		
		System.out.println(count);
	}
}
