import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			
			if(str[0].equals("push")) {
				stack.add(str[1]);
			} else if (str[0].equals("pop")) {
				if(!stack.isEmpty()) sb.append(stack.pop() + "\n");
				else sb.append("-1" + "\n");
			} else if (str[0].equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (str[0].equals("empty")) {
				if(stack.isEmpty()) sb.append("1" + "\n");
				else sb.append("0" + "\n");
			} else if (str[0].equals("top")) {
				if(stack.isEmpty()) sb.append("-1" + "\n");
				else sb.append(stack.peek() + "\n");
			}
		}
		System.out.println(sb);
	}
}