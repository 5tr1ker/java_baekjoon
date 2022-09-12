import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int total = 0;
		int tmp = 1;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				tmp *= 2;
				stack.push('(');
			} else if (str.charAt(i) == '[') {
				tmp *= 3;
				stack.push('[');
			} else {
				if(str.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() == '[') {
						System.out.println("0");
						return;
					} else if(str.charAt(i - 1) == '(') {
						total += tmp;
					}
					tmp /= 2;
					stack.pop();
				} else if (str.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() == '(') {
						System.out.println("0");
						return;
					} else if(str.charAt(i - 1) == '[') {
						total += tmp;
					}
					tmp /= 3;
					stack.pop();
				}
			}
		}
		
		if(!stack.isEmpty()) System.out.println("0");
		else System.out.println(total);
	}

}