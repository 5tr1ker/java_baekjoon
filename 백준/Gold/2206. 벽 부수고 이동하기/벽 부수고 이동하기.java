import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class point {
		int x;
		int y;
		int cnt;
		boolean destroy;
		
		public point(int x , int y , int cnt , boolean destroy) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroy = destroy;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		boolean check[][][] = new boolean[N][M][2]; // 0은 부순 벽이 없을 때 / 1은 부순 벽이 있을 때
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		Queue<point> queue = new LinkedList<>();
		queue.add(new point(0,0,1,false));
		
		int coorX[] = {-1,1,0,0};
		int coorY[] = {0,0,-1,1};
		
		while(!queue.isEmpty()) {
			point point = queue.poll();
			if(point.y == N - 1 && point.x == M - 1) {
				System.out.println(point.cnt);
				return;
			}
			
			
			for(int i = 0; i < 4 ; i++) {
				int cnt = point.cnt + 1;
				int Y = point.y + coorY[i];
				int X = point.x + coorX[i];
				if(X < 0 || X >= M || Y >= N || Y < 0) continue;
				
				if(arr[Y][X] == 0) { // 벽이 아님
					if(!point.destroy && !check[Y][X][0]) { // 벽을 부순적이 없을 때
						check[Y][X][0] = true;
						queue.add(new point(X , Y , cnt , false));
					} 
					else if (point.destroy && !check[Y][X][1]) { // 벽을 부순적이 있을 때
						check[Y][X][1] = true;
						queue.add(new point(X , Y , cnt , true));
					}
				} else if(arr[Y][X] == 1) { // 벽일 때
					if(!point.destroy) { // 벽을 부순적이 없을 때
						queue.add(new point(X , Y , cnt , true)); // 벽을 부순다.
						check[Y][X][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}