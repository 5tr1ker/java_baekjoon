import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int arr[][];
	public static int N , M;
	public static int result = 0;
	
	public static void bruthForce() {
		int i , j , index;
		for(i = 0; i < N; i++) {
			for(j = 0; j < M; j++) {
				
				// ㅁ자 도형
				if(i + 1 < N && j + 1 < M) {
					index = arr[i][j] + arr[i][j + 1] + arr[i+1][j] + arr[i+1][j+1];
					result = Math.max(result, index);
				}
				
				// ㅡ자 도형
				if(i + 3 < N) {
					index = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
					result = Math.max(result, index);
				}
				if(j + 3 < M) {
					index = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
					result = Math.max(result, index);
				}
				
				// ㄴ자 도형
				if(j + 2 < M && i + 1 < N) {
					index = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j];
					result = Math.max(result, index);
				}
				if(j + 2 < M && i + 1 < N) {
					index = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
					result = Math.max(result, index);
				}
				if(j + 2 < M && i + 1 < N) {
					index = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
					result = Math.max(result, index);
				}
				if(j + 2 < M && i + 1 < N) {
					index = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+2];
					result = Math.max(result, index);
				}
				
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i][j+1];
					result = Math.max(result, index);
				}
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+2][j];
					result = Math.max(result, index);
				}
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
					result = Math.max(result, index);
				}
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
					result = Math.max(result, index);
				}
				
				// ㅗ 자 도형
				if(j + 2 < M && i + 1 < N) {
					index = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+1];
					result = Math.max(result, index);
				}
				if(j + 2 < M && i + 1 < N) {
					index = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
					result = Math.max(result, index);
				}
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
					result = Math.max(result, index);
				}
				if(i + 2 < N && j + 1 < M) {
					index = arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+1][j];
					result = Math.max(result, index);
				}
				
				// N 모양
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
					result = Math.max(result, index);
				}
				if(j + 1 < M && i + 2 < N) {
					index = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
					result = Math.max(result, index);
				}
				if(j + 2 < M && i + 1 < N) {
					index = arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i][j+2];
					result = Math.max(result, index);
				}
				if(j + 2 < M && i + 1 < N) {
					index = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
					result = Math.max(result, index);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bruthForce();
		
		System.out.println(result);
	}
}