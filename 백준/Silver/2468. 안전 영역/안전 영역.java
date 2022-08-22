import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int arr[][];
	private static int N;
	
	public static int bfs(int index) {
		boolean arr2[][] = new boolean[N][N];
		
		int count = 0;
		Queue<int []> queue = new LinkedList<int[]>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] <= index) { // 침수 여부
					arr2[i][j] = true;
				}
			}
		}
		
		int coorX[] = {-1,1,0,0};
		int coorY[] = {0,0,-1,1};
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!arr2[i][j]) {
					count++;
					queue.add(new int[] {i , j});
					arr2[i][j] = true; // 확인 여부
				}
				
				while(!queue.isEmpty()) {
					int data[] = queue.poll();
					int X = data[1];
					int Y = data[0];
					
					for(int z = 0; z<4; z++) {
						if(X + coorX[z] < 0 || X + coorX[z] >= N || Y + coorY[z] < 0 || Y + coorY[z] >= N) continue;
						
						if(!arr2[Y + coorY[z]][X + coorX[z]]) {
							arr2[Y + coorY[z]][X + coorX[z]] = true;
							queue.add(new int[] {Y + coorY[z] , X + coorX[z]});
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		StringTokenizer st;
		int maxValue = 0 , index = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(index < arr[i][j]) index = arr[i][j];
			}
		}
		
		int result;
		for(int i = index; i >= 0; i--) {
			result = bfs(i);
			if(result > maxValue) maxValue = result;
		}
		
		System.out.println(maxValue);
	}

}