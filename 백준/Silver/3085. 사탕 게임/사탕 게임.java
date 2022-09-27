import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static public int N;
	static public char map[][];
	static public int max = 0;
	static public int coorX[] = {-1,1,0,0};
	static public int coorY[] = {0,0,-1,1};
	
	public static void check() {
		int total = 0;
		char prev;
		
		// X 일때
		for(int i = 0; i < N; i++) {
			prev = map[i][0];
			total = 0;
			for(int j = 0; j < N; j++) {
				if(prev == map[i][j]) {
					total++;
				} else {
					prev = map[i][j];
					max = Math.max(total, max);
					total = 1;
				}
			}
			max = Math.max(total, max);
		}
		
		// Y 측정
		for(int i = 0; i < N; i++) {
			prev = map[0][i];
			total = 0;
			for(int j = 0; j < N; j++) {
				if(prev == map[j][i]) {
					total++;
				} else {
					prev = map[j][i];
					max = Math.max(total, max);
					total = 1;
				}
			}
			max = Math.max(total, max);
		}
	}
	
	public static void changeCandy() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int z = 0; z < 4; z++) {
					int dx = j + coorX[z];
					int dy = i + coorY[z];
					
					if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
					
					if(map[i][j] != map[dy][dx]) { // 캔디의 색이 다르다면?
						char inx = map[i][j];
						map[i][j] = map[dy][dx];
						map[dy][dx] = inx;
						check();
						inx = map[i][j];
						map[i][j] = map[dy][dx];
						map[dy][dx] = inx;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		String str;
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		changeCandy();
		System.out.println(max);
	}
}