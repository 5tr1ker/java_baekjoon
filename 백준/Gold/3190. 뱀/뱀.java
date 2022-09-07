import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int K = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		
		for(int i = 0; i < K; i++) { // 사과 배치
			String str[] = br.readLine().split(" ");
			map[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		
		int directx[] = {1 , 0 , -1 , 0}; // 방향
		int directy[] = {0 , 1 , 0 , -1}; // 방향
		int nowdirect = 0; // 현재 방향
		
		Queue<int []> queue = new LinkedList<int[]>(); // 꼬리 위치
		int check_time = 0;
		int nowx = 0 , nowy = 0;
		
		int time = 0;
		String str[] = null;
		for(int i = 0; i <= L; i++) {
			if(i < L) {
				str = br.readLine().split(" ");
				time = Integer.parseInt(str[0]) - check_time;	
			} else {
				time = Integer.MAX_VALUE;
			}
			
			for(int j = 0 ; j < time; j++) {
				int x = nowx + directx[nowdirect];
				int y = nowy + directy[nowdirect];
				check_time++;
				
				if(x < 0 || y < 0 || x >= N || y >= N || map[y][x] == 2) { // 충돌
					System.out.println(check_time);
					return;
				}
				
				if(!queue.isEmpty() && map[y][x] != 1) { // 꼬리가 움직이자
					int index[] = queue.poll();
					map[index[0]][index[1]] = 0; // 해당 자리 꼬리 제거
					queue.add(new int[] {nowy , nowx});
					map[nowy][nowx] = 2; // 꼬리 최신화
				}
				
				if(map[y][x] == 1) 	{ // 사과 섭취
					queue.add(new int[] {nowy , nowx});
					map[nowy][nowx] = 2;
					map[y][x] = 0;
				}
				
				nowx = x;
				nowy = y;
			}
			

			if(str[1].equals("L")) { // 방향 조절 
				nowdirect--;
				if(nowdirect < 0) nowdirect = 3;
			} else if(str[1].equals("D")) {
				nowdirect++;
				if(nowdirect > 3) nowdirect = 0;
			}
		}
	}
}
