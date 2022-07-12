import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
	 
		int dp[][] = new int[testcase + 1][testcase + 1];
		int tokenData , max = 0;
		
		for(int i = 1; i <= testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				tokenData = Integer.parseInt(st.nextToken());
				dp[i][j] = Math.max(dp[i - 1][j - 1] + tokenData,dp[i - 1][j] + tokenData);
			}
		}
		
		for(int i = 1; i <= testcase; i++) {
			if(dp[testcase][i] > max) {
				max = dp[testcase][i];
			}
		}
		System.out.println(max);
	}

}