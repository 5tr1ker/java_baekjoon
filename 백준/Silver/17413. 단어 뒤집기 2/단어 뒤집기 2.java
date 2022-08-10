import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , "<> " , true);
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		
		boolean isChange = true;
		String str;
		
		while(st.hasMoreTokens()) {
			str = st.nextToken();
			if(str.equals("<")) {
				isChange = false;
			} else if (str.equals(">")) {
				isChange = true;
			}
			
			if(!isChange) {
				sb.append(str);
			} else {
				for(int i = 0; i < str.length(); i++) {
					stack.push(str.charAt(i));
				}
				
				while(!stack.isEmpty()) sb.append(stack.pop());
			}
			
		}
		System.out.println(sb);
	}
}