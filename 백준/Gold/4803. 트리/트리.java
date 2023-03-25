import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static boolean arr[][] , check[];
	static int N , M , ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) {
				break;
			}
			
			arr = new boolean[N + 1][N + 1];
			check = new boolean[N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = arr[x][y] = true;
			}
			
			ans = 0;
			for(int i = 1; i <= N; i++) {
				if(!check[i]) {
					check[i] = true;
					if(dfs(0 , i)) ans++;
				}
			}
			
			if(ans == 0) {
				sb.append("Case ").append(cnt++).append(": No trees.").append("\n");
			} else if (ans == 1) {
				sb.append("Case ").append(cnt++).append(": There is one tree.").append("\n");
			} else {
				sb.append("Case ").append(cnt++).append(": A forest of ").append(ans).append(" trees.\n");
			}
			
		}
		System.out.println(sb);
	}
	
	public static boolean dfs(int root , int idx) {
		for(int i = 1; i <= N; i++) {
			if(arr[idx][i]) {
				if(root == i) {
					continue;
				}
				
				if(check[i]) {
					return false;
				}
				check[i] = true;
				if(!dfs(idx , i)) return false;
			}
		}
		
		return true;
	}
	
}