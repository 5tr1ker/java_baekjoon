import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N + 1][10];
		
		for(int i = 0; i < 10; i++) arr[0][i] = 1;
		
		for(int i = 1 ; i <= N; i++) {
			arr[i][9] = 1;
			for(int j = 8; j >= 0; j--) {
				arr[i][j] = (arr[i][j + 1] + arr[i - 1][j]) % 10007; 
			}
		}
		System.out.println(arr[N][0]);
	}
}
