import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int input[] = new int[N];
		int increase[] = new int[1_000_000 + 1];
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			increase[input[i]]++;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> output = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = N - 1; i >= 0; i--) {
			int idx = input[i];
			
			while(!stack.isEmpty()) { // 스택에 값이 존재한다면?
				if(increase[stack.peek()] > increase[idx]) { // 만약 더 큰수가 존재한다면?
					output.push(stack.peek());
					stack.push(idx);
					break;
				} else { // 값이 더 작으면?
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) { // 만약 스택이 비어져있다면?
				stack.push(idx);
				output.push(-1);
			}
		}
		
		while(!output.isEmpty()) {
			sb.append(output.pop()).append(" ");
		}
		
		System.out.println(sb);
		
	}

}