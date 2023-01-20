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
        int arr[][] = new int[N + 1][M + 1];
        int dp[][] = new int[N + 1][M + 1];
        int max = 0;
        
        for(int i = 1; i <= N; i++) {
        	String str[] = br.readLine().split("");
        	for(int j = 1; j <= M; j++) {
        		dp[i][j] = arr[i][j] = Integer.parseInt(str[j - 1]);
        	}
        }
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= M; j++) {
        		if(arr[i][j] == 1) {
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        
        System.out.println(max * max);
	}
}