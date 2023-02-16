import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		int dp[][] = new int[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = 1;
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 범위 2
		for(int i = 1; i < N; i++) {
			if(arr[i] == arr[i + 1]) {
				dp[i][i + 1] = 1;
			}
		}
		
		// 범위 3 ~
		for(int i = 2; i < N; i++) {
			for(int j = 1; j <= N - i; j++) {
				if(arr[j] == arr[i + j] && dp[j + 1][i + j - 1] == 1) {
					dp[j][j + i] = 1;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(dp[start][end]).append("\n");
		}
		
		System.out.println(sb);
	}
	
}