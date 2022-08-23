import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x , y , cnt;
		Point(int y , int x , int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int coorX[] = {-2 , -2 , 2 , 2 , -1 , 1 , -1 , 1};
	static int coorY[] = {-1 , 1 , -1 , 1 , -2 , -2 , 2 , 2};
	static boolean check[][];
	static int size;
	
	public static int bfs(int startY , int startX , int endY , int endX) {
		ArrayDeque<Point> q = new ArrayDeque<>();
		
		q.add(new Point(startY , startX , 0));
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			int Y = point.y;
			int X = point.x;
			int cnt = point.cnt + 1;
			
			for(int j = 0; j < 8; j++) {
				if(X + coorX[j] < 0 || X + coorX[j] >= size || Y + coorY[j] < 0 || Y + coorY[j] >= size) continue;
				
				if(endY == Y + coorY[j] && endX == X + coorX[j]) {
					return cnt;
				}
				
				if(!check[Y + coorY[j]][X + coorX[j]]) {
					check[Y + coorY[j]][X + coorX[j]] = true;
					q.add(new Point(Y + coorY[j] , X + coorX[j] , cnt));
				}
				
			}
		}
		
		return 0;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		
		for(int i = 0; i < testCase; i++) {
			size = Integer.parseInt(br.readLine());

			check = new boolean[size][size];
			st = new StringTokenizer(br.readLine(), " ");
			
			int start[] = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())};
			
			st = new StringTokenizer(br.readLine() , " ");
			int end[] = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())};
			if(start[0] == end[0] && start[1] == end[1]) {
				System.out.println(0);
				continue;
			}
			
			System.out.println(bfs(start[0] , start[1] , end[0] , end[1]));
		}
	}
}