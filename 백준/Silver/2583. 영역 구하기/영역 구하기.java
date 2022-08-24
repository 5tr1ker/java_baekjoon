import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean arr[][] = new boolean[N][M];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int X_1 = Integer.parseInt(st.nextToken());
			int Y_1 = Integer.parseInt(st.nextToken());
			int X_2 = Integer.parseInt(st.nextToken());
			int Y_2 = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < Y_2 - Y_1; j++) {
				for(int z = 0; z < X_2 - X_1; z++) {
					arr[j + Y_1][z + X_1] = true;
				}
			}
		}
		
		
		
		Queue<int []> queue = new LinkedList<int[]>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		int coorX[] = {-1,1,0,0};
		int coorY[] = {0,0,-1,1};
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!arr[i][j]) {
					queue.add(new int[] {i , j});
					arr[i][j] = true;
					int count = 1;
					
					while(!queue.isEmpty()) {
						int index[] = queue.poll();
						int Y = index[0];
						int X = index[1];
						
						for(int z = 0; z < 4; z++) {
							if(X + coorX[z] < 0 || X + coorX[z] >= M || Y + coorY[z] >= N || Y + coorY[z] < 0) continue;
							
							if(!arr[Y + coorY[z]][X + coorX[z]]) {
								arr[Y + coorY[z]][X + coorX[z]] = true;
								queue.add(new int[] {Y + coorY[z] , X + coorX[z]});
								count++;
							}
						}
					}
					result.add(count);
				}
			}
		}
		
		Collections.sort(result , new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 >= o2) return 1;
				else return -1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		System.out.println(result.size());
		for(int a : result) sb.append(a + " ");
		System.out.println(sb);
	}

}