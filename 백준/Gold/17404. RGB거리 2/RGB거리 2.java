import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int INF = 1000001;
		int arr[][] = new int[N][3];
		int dp[][] = new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int minimal = Integer.MAX_VALUE;
		for(int z = 0; z < 3; z++) {
			
			for(int i = 0; i < 3; i++) {
				if(z == i) dp[0][i] = arr[0][i];
				else dp[0][i] = INF;
			}
			
			for(int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + arr[i][2];
			}
			
			for(int i = 0; i < 3; i++)
				if (i != z) minimal = Math.min(minimal, dp[N - 1][i]);
		}
		
		System.out.println(minimal);
	}
}