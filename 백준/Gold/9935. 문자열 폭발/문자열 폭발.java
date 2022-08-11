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
		
		for(int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i));
			sb.append(str.charAt(i));
			if(str_2.charAt(str_2.length() - 1) == str.charAt(i)) {
				for(int j = 1; j <= str_2.length(); j++) {
					if(stack.search(str_2.charAt(str_2.length() - j)) != j) {
						break;
					}
					if(j == str_2.length()) {
						for(int z = 0; z < str_2.length(); z++) {
							stack.pop();
							sb.deleteCharAt(sb.length() - 1);
						}
					}
				}
			}
			
		}
		if(stack.isEmpty()) System.out.println("FRULA");
		else System.out.println(sb);
	}
}