import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static char[][] map;
	public static int R , C;
	public static boolean[] check;
	public static int max = 0;
	public static int coorX[] = {-1,1,0,0};
	public static int coorY[] = {0,0,-1,1};
	
	public static void bruthForce(int y , int x , int idx) {
		
		max = Math.max(max, idx);
		
		for(int i = 0; i < 4; i++) {
			
			int dx = x + coorX[i];
			int dy = y + coorY[i];
			if(dx < 0 || dy < 0 || dx >= C || dy >= R) continue;
			
			if(!check[map[dy][dx] - 'A']) { // 방문한 적이 없을 때!
				check[map[dy][dx] - 'A'] = true;
				bruthForce(dy , dx , idx + 1);
				check[map[dy][dx] - 'A'] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		check = new boolean[26];
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		check[map[0][0] - 'A'] = true;;
		bruthForce(0 , 0 , 1);
		
		System.out.println(max);
	}

}