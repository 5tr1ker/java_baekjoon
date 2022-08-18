import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N , M;
	private static int graph[][];
	private static boolean check[][];
	private static int count = 0;
	
	public static void bfs(Queue<int []> queue) {
		
		int coorX[] = {-1 , 1 , 0 , 0};
		int coorY[] = {0 , 0 , -1 , 1};
		count++;
		
		Queue<int []> queue2 = new LinkedList<int[]>();
		while(!queue.isEmpty()) {
			int arr[] = queue.poll();
			int x = arr[1];
			int y = arr[0];
			for(int i = 0; i < 4; i++) {
				if(x + coorX[i] < 0 || x + coorX[i] >= M || y + coorY[i] < 0 || y + coorY[i] >= N) continue;
				
				if(graph[y + coorY[i]][x + coorX[i]] != -1 && !check[y + coorY[i]][x + coorX[i]]) {
					check[y + coorY[i]][x + coorX[i]] = true;
					queue2.add(new int[] {y + coorY[i] , x + coorX[i]});
					graph[y + coorY[i]][x + coorX[i]] = 1;
				}
			}
		}
		
		if(queue2.isEmpty()) {
			return;
		} else {
			bfs(queue2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int []> queue = new LinkedList<int []>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 1 && !check[i][j]) {
					queue.add(new int[] {i , j});
					check[i][j] = true;
				}
			}
		}
		
		bfs(queue);
		
		boolean checking = true;
		for(int i = 0; i < N && checking; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 0) {
					checking = false;
					break;
				}
			}
		}
		
		if(checking) System.out.println(count - 1); 
		else System.out.println(-1);
	}

}
