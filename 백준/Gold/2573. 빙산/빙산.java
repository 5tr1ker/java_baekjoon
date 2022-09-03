import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static boolean check[][];
	static int y, x;
	static boolean flag;
	static int coorX[] = { -1, 1, 0, 0 };
	static int coorY[] = { 0, 0, -1, 1 };

	public static void dfs(int cy, int cx) { // 녹이기

		check[cy][cx] = true;

		for (int i = 0; i < 4; i++) {
			int dire_x = cx + coorX[i];
			int dire_y = cy + coorY[i];
			if (dire_x < 0 || dire_y < 0 || dire_x >= x || dire_y >= y)
				continue;

			if (map[dire_y][dire_x] == 0 && !check[dire_y][dire_x] && map[cy][cx] > 0) { // 해당 방향이 0 인경우
				map[cy][cx] = map[cy][cx] - 1; // 녹이기
				flag = true;
			}

			if (map[dire_y][dire_x] > 0 && !check[dire_y][dire_x]) { // 육지 일경우
				dfs(dire_y, dire_x);
			}
		}
	}

	public static void dfs_find(int cy, int cx) { // 찾기 ....

		for (int z = 0; z < 4; z++) {
			int dx = cx + coorX[z];
			int dy = cy + coorY[z];

			if (dx < 0 || dy < 0 || dx >= x || dy >= y)
				continue;

			if (map[dy][dx] > 0 && !check[dy][dx]) {
				check[dy][dx] = true;
				dfs_find(dy, dx);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new int[y][x];
		check = new boolean[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		flag = false; // 변환된게 있나?

		// 섬이 있나 확인 BFS

		while (true) {
			flag = false;
			check = new boolean[y][x];
			
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (map[i][j] > 0 && !check[i][j]) { // 육지 발견
						if (flag) {
							System.out.println(count);
							return;
						}

						dfs_find(i, j);
						flag = true;

					}
				}
			}

			flag = false;
			check = new boolean[y][x];

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (map[i][j] > 0 && !check[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			
			if(!flag) break;
		}

		System.out.println(0);
	}
}