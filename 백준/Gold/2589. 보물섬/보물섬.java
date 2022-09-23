import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static public int map[][];
	static public int N , M;
	static public int maxValue = 0;
	static public int coorX[] = {-1,1,0,0};
	static public int coorY[] = {0,0,-1,1};
	
	public static void bfs(int x , int y , int arr[][]) {
		
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {y , x});
		
		while(!queue.isEmpty()) {
			int data[] = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = data[1] + coorX[i];
				int dy = data[0] + coorY[i];
				
				if(dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
				
				if(arr[dy][dx] == 0) {
					arr[dy][dx] = arr[data[0]][data[1]] + 1;
					queue.add(new int[] {dy , dx});
				}
				
			}
			arr[y][x] = 0;
		}
		
		findMaxValue(arr);
		
	}
	
	public static void findMaxValue(int arr[][]) {
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				maxValue = Math.max(maxValue, arr[i][j]);
			}
		}
	}
	
	public static void bruthForce() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					
					int copy[][] = new int[N][M];
					for(int z = 0; z < N; z++)
						copy[z] = map[z].clone();
					
					bfs(j,i,copy);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				if(str[j].equals("W")) {
					map[i][j] = -1;
				} else {
					map[i][j] = 0;
				}
			}
		}
		
		bruthForce();
		
		System.out.println(maxValue);
		
	}

}