import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[47];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i < 47; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		while(T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<Integer>();
			int sum = 0;
			
			for(int i = 46; i > 0; i--) {
				if(sum + arr[i] == sum) {
					stack.push(arr[i]);
					break;
				}
				
				if(sum + arr[i] > num) {
					continue;
				}
				
				sum += arr[i];
				stack.push(arr[i]);
				
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
}