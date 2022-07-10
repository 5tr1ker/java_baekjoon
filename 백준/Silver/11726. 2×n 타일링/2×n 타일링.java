import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int dp[] = new int[input + 1];
		
		
		for(int i = 1; i <= input; i++) {
			if(i <= 3) {
				dp[i] = i;
			} else {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}
		}
		
		System.out.println(dp[input]);
		
	}

}
