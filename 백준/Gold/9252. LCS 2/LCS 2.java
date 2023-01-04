import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static String str1 , str2;
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		dp = new int[str1.length() + 1][str2.length() + 1];
		
		for(int i = 1; i <= str1.length() ; i++ ) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i -1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
				}
			}
		}
		Stack<Character> stack = new Stack<Character>();
		int i = str1.length();
		int j = str2.length();
		while(i > 0 && j > 0) {
			if(i == 0 || j == 0) break;
			
			if(dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if(dp[i][j] == dp[i][j - 1]) {
				j--;
			} else {
				stack.push(str1.charAt(i - 1));
				i--;
				j--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
	
}