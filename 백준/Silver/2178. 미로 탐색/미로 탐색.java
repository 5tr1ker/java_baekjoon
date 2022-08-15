import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean check[][] = new boolean[N][M];
		int graph[][] = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				graph[i][j] = str.charAt(j) - 48;
			}
		}
		
		// BFS
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {0,0});
		check[0][0] = true;
		
		int coorX[] = {-1 , 1 , 0 , 0};
		int coorY[] = {0 , 0 , -1 , 1};
		
		while(!queue.isEmpty()) {
			int target[] = queue.poll();
			int currentX = target[1];
			int currentY = target[0];
			
			if(currentX >= M || currentY >= N) {
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				if(currentY + coorY[i] >= N || currentY + coorY[i] < 0 || currentX + coorX[i] >= M || currentX + coorX[i] < 0) {
					continue;
				}
				
				if(!check[currentY + coorY[i]][currentX + coorX[i]] && graph[currentY + coorY[i]][currentX + coorX[i]] != 0) {
					graph[currentY + coorY[i]][currentX + coorX[i]] = graph[currentY][currentX] + 1;
					queue.add(new int[] { currentY + coorY[i] , currentX + coorX[i]});
					check[currentY + coorY[i]][currentX + coorX[i]] = true;
				}
			}
		}

		System.out.println(graph[N - 1][M - 1]);
		
	}

}