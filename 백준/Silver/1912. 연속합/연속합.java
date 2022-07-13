import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp[] = new int[input + 1];
		int max = -1001;
		
		dp[0] = 0;
		for(int i = 1 ; i <= input; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
			if(dp[i - 1] + dp[i] >= 0) {
				dp[i] = Math.max(dp[i] , dp[i - 1] + dp[i]);
				max = Math.max(max, dp[i]);
			} else {
				max = Math.max(max, dp[i]);
			}
		}
		System.out.println(max);
	
	}

}
