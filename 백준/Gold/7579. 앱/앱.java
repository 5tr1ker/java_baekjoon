import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int dp[][] = new int[N][10001];
		int costArr[] = new int[N];
		int memoryArr[] = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine() , " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N; i++) {
			memoryArr[i] = Integer.parseInt(st1.nextToken());
			costArr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int memory = memoryArr[i];
			int cost = costArr[i];
			
			for(int j = 0; j <= 10000; j++) {
				if(i == 0) {
					if(j >= cost) dp[i][j] = memory;
				} else {
					if(j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + memory , dp[i - 1][j]);
					else dp[i][j] = dp[i - 1][j];
				}
				
				if(dp[i][j] >= M) answer = Math.min(answer, j);
			}
		}
		
		System.out.println(answer);
	}

}