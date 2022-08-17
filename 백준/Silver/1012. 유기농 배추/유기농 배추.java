import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int graph[][];
		boolean check[][];
		int x , y , napacabbage , count;
		
		for(int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			napacabbage = Integer.parseInt(st.nextToken());
			count = 0;
			
			graph = new int[y][x];
			check = new boolean[y][x];
			for(int j = 0; j < napacabbage ; j++) {
				st = new StringTokenizer(br.readLine() , " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				graph[y1][x1] = 1;
			}
			
			
			Queue<int []> queue = new LinkedList<int []>();
			int coorX[] = { -1 , 1 , 0 , 0 };
			int coorY[] = {0 , 0 , -1 , 1};
			
			for(int j = 0; j < y; j++) {
				for(int z = 0; z < x; z++) {
					if(graph[j][z] == 1 && !check[j][z]) {
						queue.add(new int[] {j , z});
						count++;
						check[j][z] = true;
						
						while(!queue.isEmpty()) {
							int []data = queue.poll();
							int y1 = data[0];
							int x1 = data[1];
							
							for(int n = 0; n < 4; n++) {
								if(x1 + coorX[n] < 0 || x1 + coorX[n] >= x || y1 + coorY[n] < 0 || y1 + coorY[n] >= y) continue;
								if(graph[y1 + coorY[n]][x1 + coorX[n]] == 1 && !check[y1 + coorY[n]][x1 + coorX[n]]) {
									check[y1 + coorY[n]][x1 + coorX[n]] = true;
									queue.add(new int [] {y1 + coorY[n] , x1 + coorX[n]});
								}
							}
						}
					}
				}
			}
			
			
			System.out.println(count);
		}
	}

}