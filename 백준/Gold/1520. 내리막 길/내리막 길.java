import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static public int n, m;
	static public int arr[][];
	static public int dp[][];
	static public int coorX[] = { 1, -1, 0, 0 };
	static public int coorY[] = { 0, 0, -1, 1 };

	public static int dfs(int y, int x) {

		if (x == m - 1 && y == n - 1) {
			return 1;
		}
		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		dp[y][x] = 0;
		for (int z = 0; z < 4; z++) {
			int dx = x + coorX[z];
			int dy = y + coorY[z];

			if (dx >= m || dy >= n || dx < 0 || dy < 0)
				continue;

			if (arr[y][x] > arr[dy][dx]) {
				dp[y][x] += dfs(dy, dx);
			}
		}
		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		

		System.out.println(dfs(0, 0));
	}

}