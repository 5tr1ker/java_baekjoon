import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int map[][];
	static int count = 0;
	// 0 가로
	// 1 세로
	// 2 대각
	public static void dfs(int x , int y , int direct) {
		if(x == N - 1 && y == N - 1) {
			count++;
			return;
		}
		
		if(direct == 0) { // 가로
			if(y + 1 < N && map[x][y + 1] != 1) { // 가로
				dfs(x , y + 1 , 0);
			}
		}
		else if (direct == 1) { // 세로
			if(x + 1 < N && map[x + 1][y] != 1) {
				dfs(x + 1 , y , 1);
			}
		}
		else { // 대각
			if(y + 1 < N && map[x][y + 1] != 1) { // 가로
				dfs(x , y + 1 , 0);
			}
			
			if(x + 1 < N && map[x + 1][y] != 1) {
				dfs(x + 1 , y , 1);
			}
		}
		
		if(x + 1 < N && y + 1 < N && map[x + 1][y + 1] != 1 && map[x + 1][y] != 1 && map[x][y + 1] != 1) {
			dfs(x + 1 , y + 1 , 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0 , 1 , 0);
		System.out.println(count);
	}
	
}