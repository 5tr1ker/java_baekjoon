import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static int[] coorX = {-1,1,0,0};
	public static int[] coorY = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int number = 1; ; number++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			int arr[][] = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Integer bfs[][] = new Integer[N][N];
			Queue<int []> queue = new LinkedList<int []>();
			queue.offer(new int[] {0 , 0});
			bfs[0][0] = arr[0][0];
			
			while(!queue.isEmpty()) {
				int data[] = queue.poll();
				
				for(int i = 0; i < 4; i++) {
					int dx = data[0] + coorX[i];
					int dy = data[1] + coorY[i];
					
					if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
					
					if(bfs[dx][dy] == null || bfs[dx][dy] > bfs[data[0]][data[1]] + arr[dx][dy]) {
						bfs[dx][dy] = bfs[data[0]][data[1]] + arr[dx][dy];
						queue.offer(new int[] {dx , dy});
					}
				}
			}
			sb.append("Problem ").append(number).append(": ").append(bfs[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(sb);
	}
}