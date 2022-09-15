import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean check[];
	
	public static void bruthForce(int i , int count) {
		
		if(count == N / 2) {
			calculationScore();
			return;
		}
		
		for( ; i < N ; i++) {
			if(!check[i]) {
				check[i] = true;
				bruthForce(i , count + 1);
				check[i] = false;
			}
		}
	}
	
	public static void calculationScore() {
		int firstTeamScore = 0;
		int secondTeamScore = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(check[i] && check[j]) {
					firstTeamScore += arr[i][j];
					firstTeamScore += arr[j][i];
				}
				
				if(!check[i] && !check[j]) {
					secondTeamScore += arr[i][j];
					secondTeamScore += arr[j][i];
				}
			}
		}
		
		min = Math.min(min, Math.abs(secondTeamScore - firstTeamScore));
		
		if(min == 0) {
			System.out.println(0);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bruthForce(0 , 0);
		System.out.println(min);
	}

}
