import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while(true) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			int cnt = 0;
			if(str.contains("-")) {
				break;
			}
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch == '{') {
					stack.push(ch);
				} else {
					if(stack.isEmpty()) {
						cnt++;
						stack.push('{');
					} else {
						stack.pop();
					}
				}
			}
			
			cnt += stack.size() / 2;
			
			sb.append(idx++).append(". ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}