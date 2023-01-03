import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int arr[] = new int[A];
		int dp[] = new int[A];
		int idx = 0;
		
		for(int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 0;
		}
		
		for(int i = 1; i < A; i++) {
			for(int j = i; j >= 0; j-- ) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					idx = Math.max(idx, dp[i]);
				}
			}
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = A - 1; i >= 0; i--) {
			if(dp[i] == idx) {
				stack.push(arr[i]);
				idx--;
			}
		}
		
		idx = stack.size();
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(idx + "\n" + sb);
	}
	
}