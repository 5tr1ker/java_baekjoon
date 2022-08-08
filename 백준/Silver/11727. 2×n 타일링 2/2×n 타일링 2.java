import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[N];
		dp[0] = 1L;
		
		if(N >= 2) dp[1] = 3L;
		
		for(int i = 2; i < N; i++) {
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}
		
		System.out.println(dp[N - 1] % 10007);
	}

}
