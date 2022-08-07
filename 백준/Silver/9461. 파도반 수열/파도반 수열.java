import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[101];
		int input , j = 5;
		
		dp[1] = 1; dp[2] = 1; dp[3] = 1;
		dp[4] = 2; dp[5] = 2;
		
		for(int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());
			
			if(input >= j) {
				for( ; j <= input; j++) {
					dp[j] = dp[j - 1] + dp[j - 5];
				}
			}
			System.out.println(dp[input]);
		}
	}

}
