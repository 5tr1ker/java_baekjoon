import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean arr[][] = new boolean[N][M]; // 입력
		boolean arr2[][] = new boolean[N][M]; // 목표
		
		String[] input;
		int i , j;
		for(i = 0; i < N ; i++) {
			input = br.readLine().split("");
			for(j = 0 ; j < M ; j++) {
				arr[i][j] = input[j].equals("1") ? true : false;
			}
		}
		
		for(i = 0; i < N ; i++) {
			input = br.readLine().split("");
			for(j = 0 ; j < M ; j++) {
				arr2[i][j] = input[j].equals("1") ? true : false;
			}
		}
		
		int count = 0;
		int k2 , p2;
		
		for(i = 0; i < N - 2; i++) {
			for(j = 0; j < M - 2 ; j++) {
				if(arr[i][j] != arr2[i][j]) {
					for(k2 = i ; k2 < i + 3 ; k2++) {
						for(p2 = j ; p2 < j + 3; p2++) {
							arr[k2][p2] = !arr[k2][p2];
						}
					}
					count++;
				}
			}
		}
		
		boolean isChange = true;
		for(i = 0; i < N && isChange ; i++) {
			for(j = 0; j < M && isChange ; j++) {
				if(arr[i][j] != arr2[i][j]) { 
					isChange = false;
				}
			}
		}
		System.out.println(isChange ? count : -1);
	}
}
