import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int arr[][];
	public static Integer dp[][];
	public static int max = 0;
	public static int coorX[] = { -1, 1, 0, 0 };
	public static int coorY[] = { 0, 0, -1, 1 };

	public static int dfs(int x, int y) {
		if(dp[y][x] != null) {
			return dp[y][x];
		}
		
		dp[y][x] = 1;
		for (int i = 0; i < 4; i++) {
			int dx = coorX[i] + x;
			int dy = coorY[i] + y;

			if (dx >= N || dx < 0 || dy >= N || dy < 0)
				continue;

			if(arr[y][x] < arr[dy][dx]) {
				dp[y][x] = Math.max(dp[y][x], 1 + dfs(dx, dy));
			}
		}
		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		dp = new Integer[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dfs(j, i));
			}
		}
		
		System.out.println(max);
	}

}
