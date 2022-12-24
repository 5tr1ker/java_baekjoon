
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TS = Integer.parseInt(br.readLine());
		int arr[][];
		int dp[][];
		StringTokenizer st;
		
		for(int ts = 0; ts < TS; ts++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[2][N + 1];
			dp = new int[2][N + 1];
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				for(int j = 1; j <= N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			
				dp[0][1] = arr[0][1];
				dp[1][1] = arr[1][1];
				
				for(int j = 2; j <= N; j++) {
					dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
					dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
				}
				
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));			
		}
	}
}