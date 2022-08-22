import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int arr[][];
	private static int N;
	private static boolean arr2[][];
	
	public static int dfs(int Y , int X , int height) {
		int coorX[] = {-1,1,0,0};
		int coorY[] = {0,0,-1,1};
		
		for(int i = 0; i < 4; i++) {
			if(X + coorX[i] < 0 || X + coorX[i] >= N || Y + coorY[i] < 0 || Y + coorY[i] >= N) continue;
			
			if(arr[Y + coorY[i]][X + coorX[i]] > height && !arr2[Y + coorY[i]][X + coorX[i]]) {
				arr2[Y + coorY[i]][X + coorX[i]] = true;
				dfs(Y + coorY[i] , X + coorX[i] , height);
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		arr2 = new boolean[N][N];
		
		StringTokenizer st;
		int maxValue = 0 , index = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(index < arr[i][j]) index = arr[i][j];
			}
		}
		
		for(int i = index; i >= 0; i--) {
			int count = 0;
			arr2 = new boolean[N][N];
			for(int j = 0; j < N; j++) {
				for(int z = 0; z < N; z++) {
					if(arr[j][z] > i && !arr2[j][z]) {
						arr2[j][z] = true;
						count += dfs(j , z , i); // 안전지대 찾기
					}
				}
			}
			maxValue = Math.max(maxValue, count);
		}
		
		System.out.println(maxValue);
	}

}