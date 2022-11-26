import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int data;
		int cnt;
		int prev;
		
		public Point(int data , int cnt , int prev) {
			this.data = data;
			this.cnt = cnt;
			this.prev = prev;
		}
	}
	
	static Point arr[][];
	static int N , M;
	static LinkedList<Point> list;
	static int count = 0;
	static int coorX[] = {1,-1,0,0};
	static int coorY[] = {0,0,-1,1};
	static Queue<int []> queue;
	
	public static void BFS() {
		boolean check[][] = new boolean[N][M];
		queue.add(new int[] {0,0});
		check[0][0] = true;
		
		while(!queue.isEmpty()) {
			int data[] = queue.poll();
			
			for(int k = 0; k < 4; k++) {
				int dx = data[0] + coorX[k];
				int dy = data[1] + coorY[k];
				
				if(dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
				
				if(arr[dy][dx].data == 1 && arr[data[1]][data[0]].data == 0) {
					if(arr[dy][dx].prev != count) {
						arr[dy][dx].prev = count;
						arr[dy][dx].cnt = 1;
					} else {
						arr[dy][dx].cnt += 1;
					}
					
					if(arr[dy][dx].cnt >= 2) {
						list.add(arr[dy][dx]);
					}
				}
				
				if(arr[dy][dx].data == 0 && !check[dy][dx]) {
					queue.add(new int[] {dx , dy});
					check[dy][dx] = true;
				}
			}
		}
		
		if(list.isEmpty()) {
			return;
		}
		
		while(!list.isEmpty()) {
			Point pnt = list.poll();
			pnt.data = 0;
		}
		count++;
		BFS();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new LinkedList<Point>();
		arr = new Point[N][M];
		queue = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				int index = Integer.parseInt(st.nextToken());
				arr[i][j] = new Point(index , 0 , 0);
			}
		}
		BFS();
		System.out.println(count);
	}

}