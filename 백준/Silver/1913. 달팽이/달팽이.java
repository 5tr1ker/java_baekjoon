import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		
		int dx = 0 , dy = 0;
		int mid = N / 2;
		int cnt = 2;
		
		arr[mid][mid] = 1;
		int x = mid - 1 , y = mid;
		
		for(int i = 1; i <= mid; i++) {
			// 상단에서 오른쪽
			for(int j = 0; j < i * 2; j++) {
				arr[x][y++] = cnt++;
			}
			
			// 우측에서 하단
			y--; x++;
			for(int j = 0; j < i * 2; j++) {
				arr[x++][y] = cnt++;
			}
			
			// 하단에서 좌측
			x--; y--;
			for(int j = 0; j < i * 2; j++) {
				arr[x][y--] = cnt++;
			}
			
			// 좌축에서 상단
			x--; y++;
			for(int j = 0; j < i * 2; j++) {
				arr[x--][y] = cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
				if(arr[i][j] == M) {
					dx = i + 1;
					dy = j + 1;
				}
			}
			sb.append("\n");
		}
		
		
		
		sb.append(dx).append(" ").append(dy);
		
		System.out.println(sb);
		
	}

}