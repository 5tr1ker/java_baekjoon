import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[y][x];
		int index[][] = new int[y][x];
		
		Queue<int []> queue = new LinkedList<int[]>();
		
		int startX = 0 , startY = 0;
		int endX = 0 , endY = 0;
		for(int i = 0 ; i < y; i++) {
			String str = br.readLine();
			for(int j = 0; j < x; j++) {
				arr[i][j] = str.charAt(j);
				if(str.charAt(j) == '*') {
					index[i][j] = 0;
					queue.add(new int[] {i , j , 1});
				}
				else if(str.charAt(j) == 'S') {
					startX = j;
					startY = i;
				}
				else if(str.charAt(j) == 'D') {
					endX = j;
					endY = i;
				}
			}
		}

		int coorX[] = {-1,1,0,0};
		int coorY[] = {0,0,-1,1};
		// 침수지역 확인
		while(!queue.isEmpty()) {
			int data[] = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int x_2 = coorX[i] + data[1];
				int y_2 = coorY[i] + data[0];
				int count = data[2];
				
				if(x_2 < 0 || x_2 >= x || y_2 < 0 || y_2 >= y) continue;
				
				if(arr[y_2][x_2] == '.' && index[y_2][x_2] == 0) {
					index[y_2][x_2] = count;
					queue.add(new int[] {y_2 , x_2 , count + 1});
				}
			}
		}
		
		queue.add(new int[] {startY , startX , 1});
		
		// 오리 이동
		while(!queue.isEmpty()) {
			int data[] = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int x_2 = coorX[i] + data[1];
				int y_2 = coorY[i] + data[0];
				int count = data[2];
				
				if(x_2 < 0 || x_2 >= x || y_2 < 0 || y_2 >= y) continue;
				
				if((arr[y_2][x_2] == '.' || arr[y_2][x_2] == 'D') && (index[y_2][x_2] > count || index[y_2][x_2] == 0)) {
					index[y_2][x_2] = count;
					queue.add(new int[] {y_2 , x_2 , count + 1});
				}
			}
		}
		
		if(index[endY][endX] == 0) System.out.println("KAKTUS");
		else System.out.println(index[endY][endX]);
	}
}