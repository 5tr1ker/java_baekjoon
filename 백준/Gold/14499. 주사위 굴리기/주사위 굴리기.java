import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/*
	 *   1
	 * 6 2 5
	 *   3
	 *   4
	 *   상 = 2 , 하 = 4
	 */

	static public int dice[] , arr[][];
	
	public static void copyDice(int x , int y) {
		if(arr[x][y] == 0) { // 값이 없다면
			arr[x][y] = dice[4];
		} else { // 값이 있다면
			dice[4] = arr[x][y];
			arr[x][y] = 0;
		}
	}
	
	public static void swap(int x , int y) {
		int tmp = dice[x];
		dice[x] = dice[y];
		dice[y] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int action = Integer.parseInt(st.nextToken()); // 명령 처리
			if (action == 1) { // 동 쪽
				if(y + 1 >= M) {
					continue;
				}
				y += 1;
				swap(2 , 6); swap(5 , 6) ; swap(4 , 6);
				copyDice(x , y);
			} else if (action == 2) { // 서 쪽
				if(y - 1 < 0) {
					continue;
				}
				y -= 1;
				swap(2 , 5); swap(4 , 6) ; swap(5 , 6);
				
				copyDice(x , y);
			} else if (action == 3) { // 북 쪽
				if(x - 1 < 0) {
					continue;
				}
				x -= 1;
				swap(1 , 4); swap(1 , 2) ; swap(2 , 3);
				copyDice(x , y);
			} else if (action == 4) { // 남 쪽
				if(x + 1 >= N) {
					continue;
				}
				x += 1;
				swap(1 , 4); swap(2 , 3) ; swap(2 , 4);
				copyDice(x , y);
			}
			
			sb.append(dice[2]).append("\n");
		}
		
		System.out.println(sb);
	}

}