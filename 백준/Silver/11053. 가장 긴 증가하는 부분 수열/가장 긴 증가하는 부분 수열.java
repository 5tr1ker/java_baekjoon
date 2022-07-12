import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int data[] = new int[testcase + 1];
		int dp[] = new int[testcase + 1];
		int max = 0;
		
		dp[0] = 0;
		data[0] = 0;
		for(int i = 1; i <= testcase; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			for(int j = 0; j < i; j++) {
				if(data[i] > data[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					if(max < dp[i]) max = dp[i];
				}
			}
		}
		System.out.println(max);
	}
}