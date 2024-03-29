import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dp[i] = i;
			if(Math.sqrt(i) % 1.0 == 0.0) dp[i] = 1;
			for(int j = 1; j * j <= i ; j++) {
				dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}