import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int W , H;
		StringTokenizer st;
		int arr[][];

		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0) break;
			arr = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// BFS
			Queue<int []> queue = new LinkedList<int []>();
			int coorX[] = {-1 , 1 , 0 , 0};
			int coorY[] = {0 , 0 , -1 , 1};
			int diag[] = {1 , -1 , -1 , 1};
			int count = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(arr[i][j] == 1) {
						count++;
						queue.add(new int[] {i , j});
					}
					while(!queue.isEmpty()) {
						int index[] = queue.poll();
						int index_X = index[1];
						int index_Y = index[0];
						for(int z = 0; z < 4; z++) {
							// 가로 세로
							if(index_X + coorX[z] < 0 || index_X + coorX[z] >= W || index_Y + coorY[z] < 0 || index_Y + coorY[z] >= H) continue;
							if(arr[index_Y + coorY[z]][index_X + coorX[z]] == 1) { 
								arr[index_Y + coorY[z]][index_X + coorX[z]] = 0;
								queue.add(new int[] {index_Y + coorY[z] , index_X+coorX[z]});
							}
							
							// 대각
							
							if(diag[(z + 1) % 4] + index_X < 0 || diag[z] + index_Y < 0 || diag[(z + 1) % 4] + index_X >= W || diag[z] + index_Y >= H) {
								continue;
							}
							if(arr[index_Y + diag[z]][index_X + diag[(z + 1) % 4]] == 1) {
								arr[index_Y + diag[z]][index_X + diag[(z + 1) % 4]] = 0;
								queue.add(new int[] {index_Y + diag[z] , index_X + diag[(z + 1) % 4] });
							}
						}
						
					}
				}
			}
			
			System.out.println(count);
		}
	}

}
