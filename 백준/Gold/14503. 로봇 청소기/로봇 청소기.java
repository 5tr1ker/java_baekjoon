import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int D, startX, startY; // 0 북 1 동 2 남 3 서
	static int map[][]; // 0 청소미완료 1 벽 2 청소함
	static int count = 0;

	static int coorY[] = { -1, 0, 1, 0 };
	static int coorX[] = { 0, 1, 0, -1 };
	static int N, M;

	public static void dfs(int startX, int startY, int direct) {
		if (map[startY][startX] == 0) { // 해당지역이 청소를 안한지역일경우
			map[startY][startX] = 2;
			count++;
		}
		
		int original = direct;
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int next_d = (direct + 3) % 4;
			int next_x = startX + coorX[next_d];
			int next_y = startY + coorY[next_d];
			
			if(next_x > 0 || next_y > 0 || next_x < M || next_y < N) {
				if (map[next_y][next_x] == 0) { // 주변 청소지역 탐색
					dfs(next_x, next_y, next_d);
					flag = true;
					break;
				}
			}
			direct = (direct + 3) % 4;
		}
		if (!flag) { // 주변이 모두 청소되어 있다면?
			int next_d = (original + 2) % 4;
			int next_x = startX + coorX[next_d];
			int next_y = startY + coorY[next_d];
			
			if(next_x > 0 || next_y > 0 || next_x < M || next_y < N) {
				if (map[next_y][next_x] != 1) {
					dfs(next_x, next_y, original); // 1보 후퇴
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(startY, startX, D);

		System.out.println(count);
	}
}