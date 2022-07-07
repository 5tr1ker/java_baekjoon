import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		int dp[] = new int[input + 1];
		
		dp[0] = -1;
		for(int i = 1; i <= input; i++) {
			dp[i] = i - 1;
			
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i] , dp[i / 3] + 1);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i] , dp[i / 2] + 1);
			}
			dp[i] = Math.min(dp[i] , dp[i - 1] + 1);
		}
		
		System.out.println(dp[input]);
	}

}