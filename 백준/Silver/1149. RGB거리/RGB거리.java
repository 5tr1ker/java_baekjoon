import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		int dp[][] = new int[testcase][3];
		String[] input;
		
		for(int i = 0; i < testcase; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(input[j]);
				if(i >= 1) {
					dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3] + dp[i][j], dp[i - 1][(j + 2) % 3] + dp[i][j]);
				}
			}
		}
		
		System.out.println(Math.min(Math.min(dp[testcase - 1][0],dp[testcase - 1][1]),dp[testcase - 1][2]));
	}
}