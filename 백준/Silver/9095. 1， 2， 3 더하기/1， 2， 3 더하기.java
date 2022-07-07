import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int typecase = Integer.parseInt(br.readLine());
		int input , i;
		int dp[] = new int[11];
		int result[] = new int[typecase];

		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(i = 3; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		for(i = 0; i < typecase; i++) {
			input = Integer.parseInt(br.readLine());
			result[i] = dp[input - 1];
		}
		
		for(int j : result) {
			System.out.println(j);
		}
	}

}
