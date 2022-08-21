import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char arr[][] = new char[N][N];
		boolean check[][] = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0;  j<str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int coorX[] = {-1 , 1 , 0 , 0};
		int coorY[] = {0 , 0 , -1 , 1};
		Queue<int []> queue = new LinkedList<int []>();
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!check[i][j]) {
					count++;
					queue.add(new int[] {i , j});
				}
				
				while(!queue.isEmpty()) {
					int index[] = queue.poll();
					int X = index[1];
					int Y = index[0];
					char chr = arr[Y][X];
					
					if(arr[Y][X] == 'G') {
						arr[Y][X] = 'R';
					}
					
					for(int z = 0; z<4; z++) {
						if(X + coorX[z] < 0 || X + coorX[z] >= N || Y + coorY[z] < 0 || Y + coorY[z] >= N) continue;
						
						if(arr[Y + coorY[z]][X + coorX[z]] == chr && !check[Y + coorY[z]][X + coorX[z]]) {
							check[Y + coorY[z]][X + coorX[z]] = true;
							queue.add(new int[] {Y + coorY[z] , X + coorX[z]});
						}
					}
				}
			}
		}
		
		System.out.printf("%d " , count);
		check = new boolean[N][N];
		count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!check[i][j]) {
					count++;
					queue.add(new int[] {i , j});
				}
				
				while(!queue.isEmpty()) {
					int index[] = queue.poll();
					int X = index[1];
					int Y = index[0];
					char chr = arr[Y][X];
					
					for(int z = 0; z<4; z++) {
						if(X + coorX[z] < 0 || X + coorX[z] >= N || Y + coorY[z] < 0 || Y + coorY[z] >= N) continue;
						
						if(arr[Y + coorY[z]][X + coorX[z]] == chr && !check[Y + coorY[z]][X + coorX[z]]) {
							check[Y + coorY[z]][X + coorX[z]] = true;
							queue.add(new int[] {Y + coorY[z] , X + coorX[z]});
						}
					}
				}
			}
		}
		System.out.printf("%d" , count);
	}

}
