import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
	static int N , M;
	static int coorX[] = {-1,1,0,0};
	static int coorY[] = {0,0,-1,1};
	static int minIndex = Integer.MAX_VALUE;
	static List<int []> camera;
	static int index[];
	static int copy[][];
	
	public static void findIndex(int y , int x , int direct) {
		
		for(int i = 1; ; i++) {
			int nx = i * coorX[direct] + x;
			int ny = i * coorY[direct] + y;
			
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || copy[ny][nx] == 6) break;
			
			if(copy[ny][nx] == 0) copy[ny][nx] = 9;
			else continue;
		}
		
	}
	
	public static void bruthForce(int[] cctv, int direct) {

		if (cctv[0] == 1) {
			findIndex(cctv[1], cctv[2], direct);
		} else if (cctv[0] == 2) {
			if (direct % 2 == 0) {
				findIndex(cctv[1], cctv[2], 0);
				findIndex(cctv[1], cctv[2], 1);
			} else {
				findIndex(cctv[1], cctv[2], 2);
				findIndex(cctv[1], cctv[2], 3);
			}
		} else if (cctv[0] == 3) {
			if(direct == 0) {
				findIndex(cctv[1], cctv[2], 0);
				findIndex(cctv[1], cctv[2], 2);
			} else if(direct == 1) {
				findIndex(cctv[1], cctv[2], 1);
				findIndex(cctv[1], cctv[2], 2);
			} else if(direct == 2) {
				findIndex(cctv[1], cctv[2], 0);
				findIndex(cctv[1], cctv[2], 3);
			} else if(direct == 3) {
				findIndex(cctv[1], cctv[2], 1);
				findIndex(cctv[1], cctv[2], 3);
			}
		} else if (cctv[0] == 4) {
			for (int i = 0; i < 4; i++) {
				if (i != direct) {
					findIndex(cctv[1], cctv[2], i);
				}
			}
		} else if (cctv[0] == 5) {
			for (int i = 0; i < 4; i++) {
				findIndex(cctv[1], cctv[2], i);
			}
		}
	}
	
	public static void findCamera(int size) {
		
		if(size == camera.size()) { 
			for(int i = 0; i < N; i++)
				copy[i] = arr[i].clone();
			
			for(int i = 0; i < index.length; i++) {
				bruthForce(camera.get(i), index[i]);
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copy[i][j] == 0) count++;
				}
			}
			minIndex = Math.min(minIndex, count);
			return;
			
		}
		
		for (int j = 0; j < 4; j++) { // 4방향
			index[size] = j; // 방향 설정
			findCamera(size + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		copy = new int[N][M];
		camera = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > 0 && arr[i][j] < 6) { // 카메라 위치
					camera.add(new int[] {arr[i][j] , i , j});
				}
			}
		}
		index = new int[camera.size()];
		
		findCamera(0);
		System.out.println(minIndex);
	}
}