import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str[] = br.readLine().split("");
		
		stack.push(Integer.parseInt(str[0]));
		for(int i = 1; i < N; i++) {
			int number = Integer.parseInt(str[i]);
			if(K > 0) {
				while(K > 0 && !stack.isEmpty() && stack.peek() < number) {
					stack.pop();
					K--;
				}
			}
			stack.push(number);
		}
		
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		while(K > 0) {
			sb.delete(0, 1);
			K--;
		}
		System.out.println(sb.reverse());
	}
}