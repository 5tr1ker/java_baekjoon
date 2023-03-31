import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[][] , N , M;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			spin();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void spin() {
		
		int stand = Math.min(N, M) / 2;
		
		for(int cnt = 0; cnt < stand ; cnt++) {
			int tmp1 = 0;
			int tmp2 = 0;
			// 왼쪽 세로축
			tmp1 = arr[cnt][cnt];
			for(int i = cnt; i < N - cnt; i++) {
				tmp2 = arr[i][cnt];
				arr[i][cnt] = tmp1;
				tmp1 = tmp2;
			}
			// 하단 가로축
			for(int i = cnt + 1; i < M - cnt; i++) {
				tmp2 = arr[N - cnt - 1][i];
				arr[N - cnt - 1][i] = tmp1;
				tmp1 = tmp2;
			}
			// 우측 세로축
			for(int i = N - cnt - 2; i >= cnt; i--) {
				tmp2 = arr[i][M - cnt - 1];
				arr[i][M - cnt - 1] = tmp1;
				tmp1 = tmp2;
			}
			// 상단 가로축
			for(int i = M - cnt - 2; i >= cnt; i--) {
				tmp2 = arr[cnt][i];
				arr[cnt][i] = tmp1;
				tmp1 = tmp2;
			}
		}
	}

}