import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x , y , cnt , k;

	public Point(int x, int y, int cnt, int k) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.k = k;
	}
}

public class Main {

	public static int coorX[] = { -1, 1, 0, 0 };
	public static int coorY[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		boolean check[][][] = new boolean[N][M][K + 1];
		
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		check[0][0][0] = true;
		queue.offer(new Point(0 , 0 , 1 , K));
		
		int ans = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Point pnt = queue.poll();
			if(pnt.x == N - 1 && pnt.y == M - 1) {
				ans = pnt.cnt;
				break;
			}
			
			for(int i = 0 ; i < 4; i++) {
				int dx = pnt.x + coorX[i];
				int dy = pnt.y + coorY[i];
				
				if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
				
				if(arr[dx][dy] == 0 && !check[dx][dy][pnt.k]) {
					queue.offer(new Point(dx , dy , pnt.cnt + 1 , pnt.k));
					check[dx][dy][pnt.k] = true;
				}
				
				if(pnt.k > 0) {
					if(arr[dx][dy] == 1 && !check[dx][dy][pnt.k - 1]) {
						queue.offer(new Point(dx , dy , pnt.cnt + 1 , pnt.k - 1));
						check[dx][dy][pnt.k - 1] = true;
					}
				}
			}
		}
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
}