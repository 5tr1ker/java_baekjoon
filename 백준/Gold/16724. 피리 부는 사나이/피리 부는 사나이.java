import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static public int N , M;
	static public boolean check[][];
	static public int indexArr[][];
	static public char map[][];
	static public int count = 0;
	static public int coorX[] = {0,0,-1,1};
	static public int coorY[] = {-1,1,0,0};
	
	public static void dfs(int y , int x , int idx) {
		
		indexArr[y][x] = idx;
		check[y][x] = true;
		
		int index = 0;
		if(map[y][x] == 'U') {
			index = 0;
		} else if(map[y][x] == 'D') {
			index = 1;
		} else if(map[y][x] == 'L') {
			index = 2;
		} else if(map[y][x] == 'R') {
			index = 3;
		}
		
		if(indexArr[y + coorY[index]][x + coorX[index]] == idx && check[y + coorY[index]][x + coorX[index]]) {
			count++; // 반복 발생!
			return;
		}
		else if (check[y + coorY[index]][x + coorX[index]] && indexArr[y + coorY[index]][x + coorX[index]] != idx) {
			// 이미 존재하는 반복
			return;
		}
		else dfs(y + coorY[index] , x + coorX[index] , idx);
		// 더 탐색
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N][M];
		indexArr = new int[N][M];
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j]) {
					dfs(i , j , ++idx);
				}
			}
		}
		
		System.out.println(count);
	}

}