
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
	static int virus_arr[][];
	static boolean check[][];
	static int N , M;
	static int coorX[] = {-1,1,0,0};
	static int coorY[] = {0,0,-1,1};
	
	static int virus_count = Integer.MAX_VALUE;
	static int save_zone = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		virus_arr = new int[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);

		System.out.println(save_zone);
	}

	public static void dfs(int wall) { // 벽 세우기
		
		if(wall == 3) {
			virus_dfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(wall + 1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void virus_dfs() { // virus_퍼트리기

		int virus_count2 = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				virus_arr[i][j] = arr[i][j];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virus_arr[i][j] == 2)
					virus_count2 = virus_diffusion(i, j, virus_count2);					
				
				if(virus_count2 > virus_count) return;
			}
			if(virus_count2 > virus_count) return;
		}
		
		save_bfs();
		virus_count = Math.min(virus_count2 , virus_count);
	}
	
	public static int virus_diffusion(int Y, int X, int virus_count2) {
		
		for(int i = 0; i < 4; i++) {
			int X2 = X + coorX[i];
			int Y2 = Y + coorY[i];
			
			if(X2 < 0 || X2 >= M || Y2 < 0 || Y2 >= N) continue;
			
			if(virus_arr[Y2][X2] == 0) {
				virus_arr[Y2][X2] = 2;
				virus_count2 = virus_count2 + 1;
				virus_count2 = virus_diffusion(Y2, X2, virus_count2);
			}
		}

		return virus_count2;
	}
	
	public static void save_bfs() { // 안전지대 찾기
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virus_arr[i][j] == 0) count++;
			}
		}
		
		save_zone = Math.max(count, save_zone);
	}
}
