import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][N];
		boolean check[][] = new boolean[N][N];

		int coorx[] = { -1, 1, 0, 0 };
		int coory[] = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> queue_find = new LinkedList<int[]>(); // 탐ㅅ맥용
		int totalDay = 0;
		int total = 0;

		while (true) {
			boolean is_count = true;
			check = new boolean[N][N];
			total = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (!check[i][j]) {
						queue_find.add(new int[] { i, j });

						while (!queue_find.isEmpty()) { // 모든 요소 탐색
							int index[] = queue_find.poll();
							int y = index[0];
							int x = index[1];

							for (int z = 0; z < 4; z++) {
								int x2 = x + coorx[z];
								int y2 = y + coory[z];

								if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= N)
									continue;
								if (!check[y2][x2] && Math.abs(arr[y][x] - arr[y2][x2]) >= L
										&& Math.abs(arr[y][x] - arr[y2][x2]) <= R) {
									total += arr[y2][x2];
									queue.add(new int[] { y2, x2 });
									queue_find.add(new int[] { y2, x2 });
									check[y2][x2] = true;
								}
							}
						}
					}
					
					if (queue.size() > 1) { // 해당 그룹이 만들어 졌으면 계산
						int data = total / queue.size();
						while (!queue.isEmpty()) {
							int index[] = queue.poll();
							int y = index[0];
							int x = index[1];
							arr[y][x] = data;
						}
						if (is_count) {
							totalDay++;
						}
						is_count = false;
						total = 0;
					}
				}
			}

			if (is_count) { // 변경된 요소가 없다면 할 필요가 없다..
				System.out.println(totalDay);
				return;
			}
		}
	}
}