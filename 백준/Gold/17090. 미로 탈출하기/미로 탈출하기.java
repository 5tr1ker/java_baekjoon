import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static public int N , M;
	static public String arr[][];
	static public Integer dp[][]; // 2 확인중 1 가능 0 불가능
	static public int count = 0;
	
	public static Integer dfs(int x , int y) {
		if(x >= M || y >= N || x < 0 || y < 0) return 1;
		if(dp[y][x] != null && dp[y][x] == 2) return 0;
		if(dp[y][x] != null) return dp[y][x];
		
		count++;
		dp[y][x] = 2;
		if(arr[y][x].equals("R")) { // 오른쪽
			dp[y][x] = dfs(x + 1 , y);
		}
		else if(arr[y][x].equals("D")) { // 아래
			dp[y][x] = dfs(x , y + 1);
		}
		else if(arr[y][x].equals("L")) { // 왼쪽
			dp[y][x] = dfs(x - 1 , y);
		}
		else if(arr[y][x].equals("U")) { // 위
			dp[y][x] = dfs(x , y - 1);
		}
		
		return dp[y][x];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N][M];
		dp = new Integer[N][M];
		
		for(int i = 0; i < N; i++) {
			String []input = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				arr[i][j] = input[j];
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(dfs(j , i) == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}