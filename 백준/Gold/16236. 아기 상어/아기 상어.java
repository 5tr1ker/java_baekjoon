import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	static boolean check[][];
	static int size = 2;
	static int eatting = 0;
	static int N;
	
	static class Coordinate {
		int x;
		int y;
		int cnt;
		public Coordinate(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static Coordinate bfs(int startX , int startY) {
		int coorX[] = {-1,0,1 , 0};
		int coorY[] = {0,1,0 , -1};
		
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(startX, startY, 0));

		Coordinate finded = null;
		boolean isFind = false;
		
		while(!queue.isEmpty()) {
			Coordinate data = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int X = coorX[i] + data.x;
				int Y = coorY[i] + data.y;
				int CNT = data.cnt + 1;
				if(X < 0 || X >= N || Y < 0 || Y >= N) continue;

				if(arr[Y][X] < size && arr[Y][X] >= 1 && arr[Y][X] <= 6 && !check[Y][X]) { // 먹기
					if(isFind) { // 값이 정해졌을 때
						if(finded.cnt < CNT && arr[Y][X] <= size) continue; // 거리가 길면 패스
						if(finded.cnt > CNT) { // 거리가 더 짧다?
							finded = new Coordinate(X, Y, CNT);
						} else if(finded.y > Y) {
							finded = new Coordinate(X, Y, CNT); // 더 높은것 찾기
						} else if (finded.x > X) {
							finded = new Coordinate(X, Y, CNT); // 더 왼쪽에 있는것 찾기
						}
					} else {
						finded = new Coordinate(X, Y, CNT);
						isFind = true;
						check[Y][X] = true;
					}
				}
				
				if(arr[Y][X] <= size && !check[Y][X]) { // 확산
					check[Y][X] = true;
					queue.add(new Coordinate(X, Y, CNT));
				}
			}
			
		}
		
		return finded;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[N][N];
		check = new boolean[N][N];
		int startX = 0 , startY = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					startX = j;
					startY = i;
					arr[startY][startX] = 0;
				}
			}
		}
		
		int resultCnt = 0;
		check = new boolean[N][N];
		
		Coordinate result = new Coordinate(startX , startY , 0);
		
		while(true) {
			result = bfs(result.x , result.y);
			if(result == null) break;
			resultCnt += result.cnt;
			
			arr[result.y][result.x] = 0;
			eatting++;
			if(size <= eatting) {
				eatting = 0;
				size++;
			}
			
			check = new boolean[N][N];
		}
		System.out.println(resultCnt);
	}

}