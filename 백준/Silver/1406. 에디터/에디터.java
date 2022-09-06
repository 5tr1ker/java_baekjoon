import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			if(input[0].equals("P")) {
				left.push(input[1].charAt(0));
			}
			else if(input[0].equals("L")) {
				if(left.size() > 0) {
					right.push(left.pop());
				}
			}
			else if(input[0].equals("D")) {
				if(0 < right.size()) {
					left.push(right.pop());
				}
			}
			else if(input[0].equals("B")) {
				if(left.size() > 0) left.pop();
			}
		}
		
		while(left.size() > 0) right.push(left.pop());
		
		StringBuilder sb = new StringBuilder();
		while(right.size() > 0) sb.append(right.pop());
		
		System.out.println(sb);
	}
}