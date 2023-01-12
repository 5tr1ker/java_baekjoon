import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		int max = 1;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(arr[i] < arr[j]) {
					dp[j] = Math.max(dp[i] + 1 , dp[j]);
					max = Math.max(max, dp[j]);
				}
			}
		}
		
		System.out.println(N - max);
		
	}
	
}