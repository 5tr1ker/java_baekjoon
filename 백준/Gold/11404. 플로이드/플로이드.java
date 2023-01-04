import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int INF = 20000000;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int arr[][] = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if(i != j) arr[i][j] = INF;
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(arr[start][end] != 0)
				arr[start][end] = Math.min(weight , arr[start][end]);
			else
				arr[start][end] = weight;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i != j) arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(arr[i][j] != INF) sb.append(arr[i][j]).append(" ");
				else sb.append("0 ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}