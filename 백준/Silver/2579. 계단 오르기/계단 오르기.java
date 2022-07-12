import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		int dp[] = new int[testcase + 1];
		int score[] = new int[testcase + 1];
		
		for(int i = 1; i <= testcase; i++) {
			dp[i] = Integer.parseInt(br.readLine());
			score[i] = dp[i] + dp[i - 1];
		}
		
		if(testcase >= 3) score[3] = Math.max(dp[1], dp[2]) + dp[3];
		
		for(int i = 4; i <= testcase; i++) {
			score[i] = Math.max(score[i - 3] + dp[i - 1], score[i - 2]) + dp[i];
		}
		System.out.println(score[testcase]);
	}
}