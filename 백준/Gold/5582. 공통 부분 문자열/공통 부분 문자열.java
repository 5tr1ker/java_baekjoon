import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String str , str2;
	public static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		str2 = br.readLine();
		dp = new int[str.length() + 1][str2.length() + 1];
		int max = 0;
		for(int i = 1; i <= str.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		System.out.println(max);
	}
}