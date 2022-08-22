import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int arr[][][] = new int[H][Y][X];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < Y; j++) {
				st = new StringTokenizer(br.readLine());
				for(int z = 0; z < X; z++) {
					arr[i][j][z] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		Queue<int []> queue = new LinkedList<int []>();
		int coorX[] = {-1,1,0,0,0,0};
		int coorY[] = {0,0,-1,1,0,0};
		int coorH[] = {0,0,0,0,-1,1};
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < Y; j++) {
				for(int z = 0; z < X; z++) {
					if(arr[i][j][z] == 1) {
						queue.add(new int[] {i , j , z});
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int index[] = queue.poll();
			int X2 = index[2];
			int Y2 = index[1];
			int H2 = index[0];
			
			for(int m = 0; m < 6; m++) {
				
				if(X2 + coorX[m] < 0 || X2 + coorX[m] >= X || Y2 + coorY[m] < 0 || Y2 + coorY[m] >= Y || H2 + coorH[m] < 0 || H2 + coorH[m] >= H) continue;

				if(arr[H2 + coorH[m]][Y2 + coorY[m]][X2 + coorX[m]] == 0) {
					queue.add(new int[] {H2 + coorH[m] , Y2 + coorY[m] , X2 + coorX[m]});
					arr[H2 + coorH[m]][Y2 + coorY[m]][X2 + coorX[m]] += arr[H2][Y2][X2] + 1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < Y; j++) {
				for(int z = 0; z < X; z++) {
					if(arr[i][j][z] == 0) {
						System.out.println(-1); return;
					}
					if(arr[i][j][z] > count) count = arr[i][j][z];
				}
			}
		}
		System.out.println(count - 1);
	}

}