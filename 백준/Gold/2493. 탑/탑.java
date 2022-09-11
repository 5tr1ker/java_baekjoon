import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		StringBuilder sb = new StringBuilder();

		stack.add(new int[] { 1, Integer.parseInt(st.nextToken()) });
		sb.append("0 ");
		for (int z = 2; z <= N; z++) {
			int index = Integer.parseInt(st.nextToken());
			
			int data[] = stack.peek();
			while(!stack.isEmpty()) {
				if (data[1] >= index) { // 충돌
					sb.append(data[0] + " ");
					stack.add(data);
					break;
				} else {
					data = stack.pop();
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.add(new int[] {z , index});
		}

		System.out.println(sb);
	}
}