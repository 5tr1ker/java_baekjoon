import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N + 1];
		int dp2[] = new int[N + 1];
		int i;
		for(i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(br.readLine());
		}
		
		dp2[1] = dp[1];
		if(N > 1) {
			dp2[2] = dp[1] + dp[2];
		}
		
		for(i = 3; i <= N; i++ ) {
			dp2[i] = Math.max(Math.max(dp2[i - 2] + dp[i] , dp2[i - 3] + dp[i - 1] + dp[i]) , dp2[i - 1]);
		}
		
		System.out.println(dp2[N]);
	}

}
