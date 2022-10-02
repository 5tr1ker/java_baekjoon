import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int dp[] = new int[M + 1];
		int index[] = new int[N];
		
		for(int i = 0; i < N; i++)
			index[i] = Integer.parseInt(br.readLine());

		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			for(int j = 1; j <= M; j++) {
				if(j >= index[i]) {
					dp[j] = dp[j] + dp[j - index[i]];
				}
			}
		}
		System.out.println(dp[M]);
	}
}
