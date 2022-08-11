import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str_2 = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		
		StringBuilder sb = new StringBuilder();
		int str2Length = str_2.length();
		
		for(int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i));
			if(str_2.charAt(str2Length - 1) == str.charAt(i)) {
				for(int j = 1; j <= str2Length; j++) {
					if(stack.search(str_2.charAt(str2Length - j)) != j) {
						break;
					}
					if(j == str_2.length()) {
						for(int z = 0; z < str2Length; z++) {
							stack.pop();
						}
					}
				}
			}
		}
		
		for(char ch : stack) {
			sb.append(ch);
		}
		
		if(stack.isEmpty()) System.out.println("FRULA");
		else System.out.println(sb);
	}
}