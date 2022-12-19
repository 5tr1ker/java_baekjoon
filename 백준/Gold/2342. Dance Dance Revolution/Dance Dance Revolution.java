import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int dp[][][];
	static int move[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		dp = new int[5][5][input.length - 1];
		move = new int[input.length - 1];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				Arrays.fill(dp[i][j] , -1);
			}
		}
		
		for(int i = 0; i < input.length - 1; i++)
			move[i] = Integer.parseInt(input[i]);
		
		System.out.println(solved(0 , 0 , 0));
	}
	
	public static int solved(int left , int right , int cnt) {
		if(cnt == move.length) return 0;
		if(dp[left][right][cnt] != -1) return dp[left][right][cnt];
		
		dp[left][right][cnt] = Math.min(solved(move[cnt] , right , cnt + 1) + calculate(left , move[cnt]) , solved(left , move[cnt] , cnt + 1) + calculate(right , move[cnt]));
		
		return dp[left][right][cnt];
	}
	
	public static int calculate(int direct , int des) {
		int num = Math.abs(direct - des);
		if(direct == 0) return 2;
		else if (num == 0) return 1;
		else if (num == 1 || num == 3) return 3;
		else return 4;
	}
}