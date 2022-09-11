import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= Integer.parseInt(str[0]); i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i = 1; i < Integer.parseInt(str[1]); i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}

}
