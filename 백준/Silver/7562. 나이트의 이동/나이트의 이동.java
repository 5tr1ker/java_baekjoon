import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x , y;
		Point(int y , int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][];
		int testCase = Integer.parseInt(br.readLine());
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		
		StringTokenizer st;
		int coorX[] = {-2 , -2 , 2 , 2 , -1 , 1 , -1 , 1};
		int coorY[] = {-1 , 1 , -1 , 1 , -2 , -2 , 2 , 2};
		
		for(int i = 0; i < testCase; i++) {
			int size = Integer.parseInt(br.readLine());
			
			arr = new int[size][size];
			st = new StringTokenizer(br.readLine(), " ");
			
			int start[] = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())};
			q.add(new Point(start[0] , start[1]));
			
			st = new StringTokenizer(br.readLine() , " ");
			int end[] = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())};
			if(start[0] == end[0] && start[1] == end[1]) {
				System.out.println(0);
				continue;
			}
			
			while(!q.isEmpty()) {
				Point point = q.poll();
				int Y = point.y;
				int X = point.x;
				
				for(int j = 0; j < 8; j++) {
					if(X + coorX[j] < 0 || X + coorX[j] >= size || Y + coorY[j] < 0 || Y + coorY[j] >= size) continue;
					
					if(arr[Y + coorY[j]][X + coorX[j]] == 0) {
						arr[Y + coorY[j]][X + coorX[j]] += arr[Y][X] + 1;
						q.add(new Point(Y + coorY[j] , X + coorX[j]));
					}
				}
			}
			
			System.out.println(arr[end[0]][end[1]]);
		}
	}
}