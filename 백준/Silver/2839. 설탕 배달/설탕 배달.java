import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int dp[];
 
		dp = new int[input + 1];
		
		for(int i = 1; i <= input && i <= 6; i++) {
			if(i == 3 || i == 5) {
				dp[i] = 1;
			} else {
				dp[i] = -1;
			}
		}
		
		for(int i = 6; i <= input; i++) {
			dp[i] = -1;
			if(dp[i - 5] == -1 && dp[i - 3] == -1) {
				dp[i] = -1;
			} else {
				dp[i] = Math.min(dp[i - 5] != -1 ? dp[i - 5] + 1 : Integer.MAX_VALUE , dp[i - 3] != -1 ? dp[i - 3] + 1 : Integer.MAX_VALUE);				
			}
		}
		
		System.out.println(dp[input]);
	}

}