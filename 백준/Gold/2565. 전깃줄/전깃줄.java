import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Bridge {
	int start;
	int end;
	
	public Bridge(int start , int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	static int N;
	static int dp[];
	static Bridge arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		arr = new Bridge[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[i] = new Bridge(start, end);
		}
		
		Arrays.sort(arr , new Comparator<Bridge>() {
			@Override
			public int compare(Bridge o1, Bridge o2) {
				return o1.start - o2.start;
			}
		});
		
		int max = 0;
		for(int i = 0; i < N; i++)
			max = Math.max(max, solution(i));
		
		
		System.out.println(N - max);
	}
	
	 static int solution(int n) {
	        if (dp[n] < 1) {
	            dp[n] = 1;

	            for (int i = n + 1; i < N; i++) {
	                if (arr[n].end < arr[i].end) {
	                    dp[n] = Math.max(dp[n], solution(i) + 1);
	                }
	            }
	        }

	        return dp[n];
	    }
}