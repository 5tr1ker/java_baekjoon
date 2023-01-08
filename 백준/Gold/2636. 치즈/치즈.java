import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	static boolean check[][];
	static int N , M;
	static int coorX[] = {-1,1,0,0};
	static int coorY[] = {0,0,-1,1};
	static int prev = 0;
	static int meltamount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) meltamount++;
			}
		}
		
		prev = meltamount;
		int time = 0;
		while(true) {
			meltamount = 0;
			melting();
			
			if(meltamount == 0) break;
			time++;
			prev = meltamount;
		}
		
		System.out.println(time + "\n" + prev);
		
	}
	
	public static void melting() {
		Queue<int []> queue = new LinkedList<int[]>();
		check = new boolean[N][M];
		queue.add(new int[] {0 , 0});
		check[0][0] = true;
		
		while(!queue.isEmpty()) {
			int data[] = queue.poll();
			
			for(int z = 0; z < 4 ;z++) {
				int dx = data[1] + coorX[z];
				int dy = data[0] + coorY[z];
				if(dy >= N || dy < 0 || dx >= M || dx < 0 || check[dy][dx]) continue;
				
				if(arr[dy][dx] == 1) {
					check[dy][dx] = true;
					meltamount++;
					arr[dy][dx] = 0;
				} else {
					check[dy][dx] = true;
					queue.add(new int[] {dy , dx});
				}
			}
		}
	}
}