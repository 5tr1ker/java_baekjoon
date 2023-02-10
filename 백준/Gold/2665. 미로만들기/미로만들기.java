import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static int coorX[] = {1,0,-1,0};
	public static int coorY[] = {0,-1,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		int ans[][] = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				ans[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<int []> queue = new LinkedList<int []>();
		queue.offer(new int[] {0,0});
		ans[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int[] nd = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = nd[0] + coorX[i];
				int dy = nd[1] + coorY[i];
				
				if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
				
				if(ans[dx][dy] <= ans[nd[0]][nd[1]]) {
					continue;
				}
				
				if(arr[dx][dy] == 1) {
					queue.offer(new int[] {dx , dy});
					ans[dx][dy] = ans[nd[0]][nd[1]];
				} else {
					queue.offer(new int[] {dx , dy});
					ans[dx][dy] = ans[nd[0]][nd[1]] + 1;
				}
			
			}
		}
		
		System.out.println(ans[N - 1][N - 1]);
	}
}