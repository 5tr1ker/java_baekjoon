import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean arr[][];
	static int N;
	static boolean check[];
	static boolean isFind = false;
	
	public static void dfs(int start , int end , int count) {
		check[start] = true;
		for(int i = 1; i <= N && !isFind ; i++) {
			
			if(arr[start][i] && i == end) {
				System.out.println(count + 1);
				isFind = true;
				return;
			}
			
			if(!check[i] && arr[start][i]) {
				dfs(i , end , count + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		arr = new boolean[N + 1][N + 1];
		check = new boolean[N + 1];
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = arr[y][x] = true;
		}
		
		dfs(start , end , 0);
		if(!isFind) System.out.println(-1);
	}

}