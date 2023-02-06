import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y, cnt, k;

	public Point(int x, int y, int cnt, int k) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.k = k;
	}
}

public class Main {

	// 4
	public static int coorX[] = { 0, 1, -1, 0 };
	public static int coorY[] = { 1, 0, 0, -1 };
	// 8
	public static int coorHX[] = { -2, -2, -1, 1, -1, 1, 2, 2 };
	public static int coorHY[] = { -1, 1, 2, 2, -2, -2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int arr[][] = new int[H][W];
		boolean check[][][] = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0, K));
		check[0][0][K] = true;
		int ans = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point data = queue.poll();
			if(data.x == H - 1 && data.y == W - 1) {
				ans = data.cnt;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = data.x + coorX[i];
				int dy = data.y + coorY[i];

				if (dx < 0 || dy < 0 || dx >= H || dy >= W || check[dx][dy][data.k])
					continue;

				if(arr[dx][dy] == 0) {
					queue.offer(new Point(dx, dy, data.cnt + 1, data.k));
					check[dx][dy][data.k] = true;					
				}
			}
			
			if(data.k > 0) {
				for(int i = 0; i < 8; i++) {
					int dx = data.x + coorHX[i];
					int dy = data.y + coorHY[i];
					
					if (dx < 0 || dy < 0 || dx >= H || dy >= W || check[dx][dy][data.k - 1])
						continue;
					
					if(arr[dx][dy] == 0) {
						queue.offer(new Point(dx , dy , data.cnt + 1 , data.k - 1));
						check[dx][dy][data.k - 1] = true;
					}
				}
			}
		}

		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
}