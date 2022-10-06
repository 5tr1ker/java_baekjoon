import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int dp[] = new int[N];
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			dp[i] = arr[i];
			for(int j = i; j >= 0 ; j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i] , arr[i] + dp[j]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}